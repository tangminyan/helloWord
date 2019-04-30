package baobei.cute.redis.controller;

import baobei.cute.statemachinedemo.dao.OrderRepository;
import baobei.cute.statemachinedemo.entity.Order;
import baobei.cute.statemachinedemo.service.OrderStateMachineService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangminyan on 2019/3/13.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderStateMachineService orderStateMachineService;

    @RequestMapping("/getAll")
    @Cacheable(value = "order_data", key = "'order_all'")
    public List<Order> getAll() {
//        String name = "order_" + id;
        List<Order> order = orderRepository.findAll();
//        redisTemplate.opsForValue().set(name, JSONObject.toJSONString(order));
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return order;
    }

    @RequestMapping("/getData")
    @Cacheable(value = "order_data", key = "'order_' + #p0")
    public Order getData(@Param("id") Integer id) {
//        String name = "order_" + id;
        Order order = orderRepository.findByOrderId(id);
//        redisTemplate.opsForValue().set(name, JSONObject.toJSONString(order));
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return order;
    }

    @RequestMapping(value = "/setData")
    public String setData(Integer id) {
        try {
            orderStateMachineService.createOrders(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }
}
