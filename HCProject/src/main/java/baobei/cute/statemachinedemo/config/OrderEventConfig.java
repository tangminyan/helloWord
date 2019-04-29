package baobei.cute.statemachinedemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Created by tangminyan on 2019/3/11.
 */
@WithStateMachine
@Slf4j
public class OrderEventConfig {

    @OnTransition(target = "UNPAYED")
    public void create() {
        log.info("待支付");
    }

    @OnTransition(source = "UNPAYED", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        log.info("支付完成，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        log.info("用户已收货，订单完成");
    }
}
