package baobei.cute.statemachinedemo.dao;

import baobei.cute.statemachinedemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tangminyan on 2019/3/11.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderId(Integer orderId);
}
