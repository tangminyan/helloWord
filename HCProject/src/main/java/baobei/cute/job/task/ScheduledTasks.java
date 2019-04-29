package baobei.cute.job.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by tangminyan on 2019/3/14.
 */
@Component
@EnableScheduling
public class ScheduledTasks {

//    @Scheduled(cron = "0 */1 *  * * * ")
    public void displayTask() {
        System.out.println("时间为：" + LocalDateTime.now());
    }
}
