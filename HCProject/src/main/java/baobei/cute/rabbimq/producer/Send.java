package baobei.cute.rabbimq.producer;

import baobei.cute.rabbimq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by tangminyan on 2019/3/12.
 */
@Component
public class Send implements RabbitTemplate.ConfirmCallback{
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public Send(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMsg(String content) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY, content, correlationData);
    }

    public void sendMsg(String exchange, String key, String content) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(exchange, key, content, correlationData);
    }

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("回调id：" + correlationData);
        if(ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败：" + cause);
        }
    }
}
