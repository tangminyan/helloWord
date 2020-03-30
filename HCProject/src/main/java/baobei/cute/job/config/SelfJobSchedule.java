package baobei.cute.job.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangminyan on 2019/5/13.
 */
public class SelfJobSchedule {

    @Autowired
    private Scheduler scheduler;

    public void createJobSchedule(Class jobClass, String name, String group, String cronSchedule) {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, group).build();

        TriggerKey triggerKey = TriggerKey.triggerKey(name, group);
    }
}
