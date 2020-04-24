package com.ztgeo.pointtopoint.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.JsonObject;
import com.ztgeo.pointtopoint.entity.CXR_MSG;
import com.ztgeo.pointtopoint.execute.TimingTask;
import com.ztgeo.pointtopoint.utils.callInterface.CallInterface;
import com.ztgeo.pointtopoint.controller.entity.CXR_MSGDirect;
import com.ztgeo.pointtopoint.handle.Hand;
import com.ztgeo.pointtopoint.utils.save.SaveToDB;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@CrossOrigin("*")
@Component
public class Controller {
    private Logger log = LoggerFactory.getLogger(getClass());
    private static String xzqdm;//行政区代码
    private CallInterface callInterface = new CallInterface();
    private TimingTask timingTask = new TimingTask();
    @Autowired
    private SaveToDB saveToDB;

    @Value("${token.xzqdm}")//从配置文件中读取行政区代码
    public void setXzqdm(String xzqdm) {  //注入行政区代码,注意@Value()只能写在非静态属性或者方法上
        Controller.xzqdm = xzqdm;
    }


    @RequestMapping(value = "/bdc/run", method = RequestMethod.POST)
    public String run() {
        String json = new CallInterface().request();
        callInterface.saveAndConfirm(json);//保存请求数据并告诉接口哪些数据已经获取
        callInterface.dataOrganization();
        callInterface.response("",0);
        return "启动成功";
    }

    @RequestMapping(value = "/bdc/test",method = RequestMethod.GET)
    public String test() {
        return  "测试";
    }

    //解析文件 并入库 需要传入保存成功后的json文件
    @RequestMapping(value = "/bdc/zxsj",method = RequestMethod.POST)
    public String zxsj(@RequestParam("file") MultipartFile file) {
        //读取文件并转换成 字符串
        log.info("方法被触发并开始解析文件....");
        try{
            InputStream inputStream = file.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bf = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String content = "";
            while (content != null) {
                content = bf.readLine();
                if (content == null) {
                break;
                }
                sb.append(content.trim());
                }
            isr.close();
            bf.close();
            log.info("文件解析结束..准备数据入库");

            saveToDB.addCXR_MSG_Only(sb.toString());
        }catch(IOException io){
                log.error("io异常");
        }


        //解析文件

        return "执行成功";
    }

    @RequestMapping(value = "/bdc/feedback", method = RequestMethod.POST)
    public String feedback() {
        timingTask.executeFeedbackFailureData("", 0);
        return "启动成功";
    }

    @RequestMapping(value = "/bdc/response", method = RequestMethod.POST)
    public String bdcResponse() {
        callInterface.response("",0);
        return "启动成功";
    }

    /**
     * 发布网络直接查询接口
     *
     * @return
     */
    @RequestMapping(value = "/api/v1/bdc/realtime-query", method = RequestMethod.POST)
    public String manage(@RequestBody String demand) {
        log.info(demand);
        HandleCXR_MSGDirect handleCXR_msgDirect = new HandleCXR_MSGDirect();
        CXR_MSGDirect cxr_msgDirect = handleCXR_msgDirect.saveCXR_MSGDirect(demand); //解析请求的数据，入库并解析出反馈格式
        log.info("请求报文:" + demand);
        Hand hand = new Hand();
        JSONObject json = new JSONObject(); //组织反馈报文
        JSONObject head = new JSONObject();
        if (cxr_msgDirect == null) { //openid验证失败
            head.put("xzqdm", xzqdm);
            head.put("code", "1001");
            head.put("msg", "openid验证失败");
            json.put("head", head);
            JSONObject data = new JSONObject();
            json.put("data", data);
            return JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue);
        }
        //openid验证成功
        head.put("xzqdm", xzqdm);
        head.put("code", "0000");
        head.put("msg", "success");
        json.put("head", head);
        JSONArray json_data = hand.getDirectRecord(cxr_msgDirect);//获取请求人的权力信息
        json.put("data", json_data);
        String jsonString = JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue);
        log.info(jsonString);
        return jsonString;
    }

}
