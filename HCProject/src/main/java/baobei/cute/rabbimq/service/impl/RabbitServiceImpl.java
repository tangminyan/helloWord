package baobei.cute.rabbimq.service.impl;

import baobei.cute.rabbimq.producer.Send;
import baobei.cute.rabbimq.producer.Send2;
import baobei.cute.rabbimq.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tangminyan on 2019/3/12.
 */
@Service
public class RabbitServiceImpl implements RabbitService {
    @Autowired
    private Send producer;

    @Autowired
    private Send2 producer2;

    public static final String EXCHANGE = "spring-boot-exchange";
    public static final String ROUTINGKEY = "spring-boot-routingKey";

    @Override
    public void testRabbit() {
        producer.sendMsg("测试");
    }

    @Override
    public void testRabbit2() {
        producer2.sendMsg("再一次");
    }

    @Override
    public void testMessageBack() {
        try {
            test1();
            test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void test1() throws InterruptedException{
        String message = "currentTime:"+System.currentTimeMillis();
        System.out.println("test1---message:"+message);
        //exchange,queue 都正确,confirm被回调, ack=true
        producer.sendMsg(EXCHANGE,ROUTINGKEY+"NO",message);
        Thread.sleep(1000);
    }

    private void test2() throws InterruptedException{
        String message = "currentTime:"+System.currentTimeMillis();
        System.out.println("test2---message:"+message);
        //exchange,queue 都正确,confirm被回调, ack=true
        producer2.sendMsg(EXCHANGE,ROUTINGKEY+"NO",message);
        Thread.sleep(1000);
    }
}
