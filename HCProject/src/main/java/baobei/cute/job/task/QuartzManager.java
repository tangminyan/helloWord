package baobei.cute.job.task;

import org.quartz.Scheduler;
import org.springframework.stereotype.Component;

/**
 * Created by tangminyan on 2019/3/15.
 */
//@Component
public class QuartzManager {
    private Scheduler scheduler;

    public QuartzManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
