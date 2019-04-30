package baobei.cute.statemachinedemo.service.impl;

import baobei.cute.statemachinedemo.dao.OrderRepository;
import baobei.cute.statemachinedemo.entity.Order;
import baobei.cute.statemachinedemo.enums.OrderStatus;
import baobei.cute.statemachinedemo.enums.OrderStetusChangeEvent;
import baobei.cute.statemachinedemo.service.OrderStateMachineService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

/**
 * Created by tangminyan on 2019/3/11.
 */
@Service
public class OrderStateMachineServiceImpl implements OrderStateMachineService {

    @Autowired
    private StateMachineFactory<OrderStatus, OrderStetusChangeEvent> machineFactory;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrders(Integer orderId) throws Exception {
        if(!ObjectUtils.isEmpty(orderRepository.findByOrderId(orderId))) {
            throw new Exception("the orderId is already exist");
        }
        String uuId = RandomStringUtils.randomAlphanumeric(9);
        StateMachine<OrderStatus, OrderStetusChangeEvent> stateMachine = machineFactory.getStateMachine(uuId);
        stateMachine.start();
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setMachineId(uuId);
        Order o =orderRepository.save(order);
        return o;
    }

    @Override
    public String payedOrders(Integer orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if(ObjectUtils.isEmpty(order)) {
            return "the orderId not exist";
        }
        StateMachine<OrderStatus, OrderStetusChangeEvent> stateMachine = machineFactory.getStateMachine(order.getMachineId());
        stateMachine.start();
        stateMachine.sendEvent(OrderStetusChangeEvent.PAYED);
        order.setStatus(stateMachine.getState().getId());
        orderRepository.save(order);
        return "success";
    }
}
