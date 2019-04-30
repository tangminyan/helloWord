package baobei.cute.statemachinedemo.service;

import baobei.cute.statemachinedemo.entity.Order;

/**
 * Created by tangminyan on 2019/3/11.
 */
public interface OrderStateMachineService {
    Order createOrders(Integer orderId) throws Exception;

    String payedOrders(Integer orderId);
}
