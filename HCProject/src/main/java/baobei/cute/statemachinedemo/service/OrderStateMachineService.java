package baobei.cute.statemachinedemo.service;

/**
 * Created by tangminyan on 2019/3/11.
 */
public interface OrderStateMachineService {
    String createOrders(Integer orderId);

    String payedOrders(Integer orderId);
}
