package com.ztgeo.pointtopoint.execute;

import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.service.mainService.CXSQDService;
import com.ztgeo.pointtopoint.service.mainService.RESULTService;
import com.ztgeo.pointtopoint.utils.callInterface.CallInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimingTask {
    private static CXSQDService cxsqdService;
    private static RESULTService resultService;
    private CallInterface callInterface = new CallInterface();

    @Autowired
    public void setCxsqdService(CXSQDService cxsqdService) {
        TimingTask.cxsqdService = cxsqdService;
    }

    @Autowired
    public void setResultService(RESULTService resultService) {
        TimingTask.resultService = resultService;
    }

    public void executeFeedbackFailureData(String cxsqdh, int byCxsqdh) {
        List<String> cxsqdIds = new ArrayList<>();
        if (byCxsqdh == 0) {
            List<CXSQD> cxsqds = cxsqdService.selectFailureData();
            for (CXSQD cxsqd : cxsqds) {
                cxsqdIds.add(cxsqd.getCxsqdh());
            }
        } else {
            cxsqdIds.add(cxsqdh);
        }

        if (cxsqdIds != null && cxsqdIds.size() > 0) {
            if (cxsqdIds.size() <= 300) {
                cxsqdService.updateFailureZtByCxsqdh(cxsqdIds);
            } else {
                int times = (int) Math.ceil(cxsqdIds.size() / 300.0);
                for (int i = 0; i < times; i++) {
                    cxsqdService.updateFailureZtByCxsqdh(cxsqdIds.subList(i * 300, Math.min((i + 1) * 300, cxsqdIds.size() - 1)));
                    resultService.deleteRESULTByCxsqds(cxsqdIds);
                }
            }
            if (byCxsqdh == 0) {
                callInterface.response("", 0);
            } else {
                callInterface.response(cxsqdh, 1);
            }
        }
    }


    public void executeProject() {
        String json = callInterface.request();
        callInterface.saveAndConfirm(json);//保存请求数据并告诉接口哪些数据已经获取
        callInterface.dataOrganization();
        callInterface.response("", 0);
    }
}
