package com.ztgeo.pointtopoint.execute;

import com.ztgeo.pointtopoint.utils.callInterface.CallInterface;
import com.ztgeo.pointtopoint.entity.CXSQD;
import com.ztgeo.pointtopoint.service.mainService.CXSQDService;
import com.ztgeo.pointtopoint.service.mainService.RESULTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class Run {
    private TimingTask timingTask = new TimingTask();

    /**
     * 每日定时执行推送
     */
    @Scheduled(cron = "${scheduledMorningTime}")
    public void executeProjectMorning() {
        timingTask.executeProject();
    }

    /**
     *
     */
//    @Scheduled(cron = "${scheduledMorningTime}")
//    public void feedbackFailureData() {
//        timingTask.executeFeedbackFailureData("", 0);
//    }


}
