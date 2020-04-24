package com.ztgeo.pointtopoint.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.ztgeo.pointtopoint.controller.Controller;
import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.execute.TimingTask;
import com.ztgeo.pointtopoint.handle.Hand;
import com.ztgeo.pointtopoint.service.mainService.CXR_MSGService;
import com.ztgeo.pointtopoint.service.mainService.CXSQDService;
import com.ztgeo.pointtopoint.utils.Dict;
import com.ztgeo.pointtopoint.utils.Util;
import com.ztgeo.pointtopoint.utils.callInterface.CallInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin("*")
@Component
@Slf4j
public class MonitorController {
    private static CXSQDService cxsqdService;
    private static String scheduledMorningTime;
    private static String scheduledNightTime;
    private static CXR_MSGService cxr_msgService;
    private TimingTask timingTask = new TimingTask();
    private CallInterface callInterface = new CallInterface();

    @Value("${scheduledMorningTime}")
    public void setScheduledMorningTime(String scheduledMorningTime) {
        MonitorController.scheduledMorningTime = scheduledMorningTime;
    }

    @Value("${scheduledNightTime}")
    public void setScheduledNightTime(String scheduledNightTime) {
        MonitorController.scheduledNightTime = scheduledNightTime;
    }

    @Autowired
    public void setCxsqdService(CXSQDService cxsqdService) {
        MonitorController.cxsqdService = cxsqdService;
    }

    @Autowired
    public void setCxr_msgService(CXR_MSGService cxr_msgService) {
        MonitorController.cxr_msgService = cxr_msgService;
    }

    @GetMapping("/primary")
    @ResponseBody
    public Map<String, Object> primary(@RequestParam(value = "startTime", defaultValue = "", required = false) String startTime,
                                       @RequestParam(value = "endTime", defaultValue = "", required = false) String endTime) {
        Map<String, Object> map = new HashMap<>();
        if (startTime.equals("") || endTime.equals("")) {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 1);
            if (endTime.equals("")) {
                endTime = sdf.format(calendar.getTime()) + " " + "00:00";
            }
            if (startTime.equals("")) {
                startTime = sdf.format(new Date()) + " " + "00:00";
            }
        }
        Integer successCount = cxsqdService.getSuccessDataByTime(startTime, endTime);
        Integer failureCount = cxsqdService.getFailureDataByTime(startTime, endTime);
        Integer totalCount = cxsqdService.getTotalDataByTime(startTime, endTime);
        Integer noFeedbackCount = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String time = sdf.format(new Date());
        try {
            if (sdf.parse(startTime).getTime() >= sdf.parse(time).getTime()) {
                noFeedbackCount = cxsqdService.getNoFeedbackDataByTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("time", Util.getCronToDate(scheduledMorningTime) + "/" + Util.getCronToDate(scheduledNightTime));
        map.put("totalCount", totalCount);
        map.put("noFeedbackCount", noFeedbackCount);
        if (totalCount > 0 && successCount > 0) {
            map.put("successRate", Util.percent(successCount, totalCount) + "%");
        } else {
            map.put("successRate", "数据计算异常");
        }
        if (totalCount > 0 && failureCount > 0) {
            map.put("failureRate", Util.percent(failureCount, totalCount) + "%");
        } else {
            map.put("failureRate", "数据计算异常");
        }
        return map;
    }

    /**
     * 错误信息查看接口
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/errorInfos")
    @ResponseBody
    public List<Map<String, String>> errorInfos(@RequestParam(value = "startTime", defaultValue = "", required = false) String startTime,
                                                @RequestParam(value = "endTime", defaultValue = "", required = false) String endTime) {
        if (startTime.equals("") || endTime.equals("")) {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            calendar.setTime(new Date());
            calendar.add(calendar.DATE, 1);
            endTime = sdf.format(calendar.getTime()) + " " + "00:00";
            startTime = sdf.format(new Date()) + " " + "00:00";
        }
        List<Map<String, String>> result = new ArrayList<>();
        List<Map<String, Object>> list = cxsqdService.getErrorInfos(startTime, endTime);
        for (Map<String, Object> m : list) {
            Map<String, String> map = new HashMap<>();
            for (String s : m.keySet()) {    //取map集合里的String类型的key，
                if (StringUtils.equalsIgnoreCase(s, "cxsqdh")) {
                    map.put(s, m.get(s).toString());
                }
                if (StringUtils.equalsIgnoreCase(s, "code")) {
                    String codeValue = m.get(s).toString();
                    map.put(s, Dict.getResultCode(codeValue) + "(" + codeValue + ")");
                }
            }
            result.add(map);
        }
        return result;
    }

    /**
     * 以人查房接口
     *
     * @return
     */
    @RequestMapping(value = "/bdc/searchHouse", method = RequestMethod.GET)
    @ResponseBody
    public Object searchHouseByPeople(@RequestParam("qlrmc") String qlrmc, @RequestParam("qlrzjh") String qlrzjh) {
        Hand hand = new Hand();
        try {
            qlrmc = URLDecoder.decode(qlrmc, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String qlrzjlx = cxr_msgService.getQlrzjlx(qlrmc, qlrzjh).get(0);
        CXR_MSG cxr_msg = new CXR_MSG("", "", qlrmc, qlrzjh, "", Integer.parseInt(qlrzjlx), "");
        JSONObject jsonObject = hand.getHouseByPeople(cxr_msg);
        return jsonObject;
    }

    /**
     * 重新反馈全部失败单号
     *
     * @return
     */
    @RequestMapping(value = "/bdc/feedbackAll", method = RequestMethod.POST)
    @ResponseBody
    public String feedbackAll() {
        timingTask.executeFeedbackFailureData("", 0);
        return "success";
    }

    /**
     * 重新反馈指定失败单号
     *
     * @param cxsqdh
     * @return
     */
    @RequestMapping(value = "/bdc/feedbackByCxsqdh", method = RequestMethod.POST)
    @ResponseBody
    public String feedbackByCxsqdh(String cxsqdh) {
        timingTask.executeFeedbackFailureData(cxsqdh, 1);
        return "success";
    }

    /**
     * 根据查询申请单号获得报文信息
     *
     * @param cxsqdh
     * @return
     */
    @GetMapping(value = "/bdc/responseByCxsqdh")
    @ResponseBody
    public Object responseByCxsqdh(String cxsqdh) {
        Map map = callInterface.jsonDataArray(cxsqdh, 1);
        com.alibaba.fastjson.JSONArray array = (com.alibaba.fastjson.JSONArray) map.get("json_dataArray");
        return array.get(0);
    }
}
