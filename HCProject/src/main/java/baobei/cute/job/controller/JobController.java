package baobei.cute.job.controller;

import baobei.cute.job.task.SelfQuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangminyan on 2019/3/15.
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private SelfQuartzScheduler quartzScheduler;

    @RequestMapping("/quartz")
    public void test() throws SchedulerException {
        quartzScheduler.startJob();
    }
}
