package baobei.cute.job.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by tangminyan on 2019/3/14.
 */
public class SchedulerQuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        before();
        System.out.println("开始：" + System.currentTimeMillis());
        after();
    }

    private void before() {
        System.out.println("任务开始执行");
    }

    private void after() {
        System.out.println("任务执行结束");
    }

}















