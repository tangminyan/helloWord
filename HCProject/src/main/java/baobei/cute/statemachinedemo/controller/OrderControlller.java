package baobei.cute.statemachinedemo.controller;

import baobei.cute.statemachinedemo.service.OrderStateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangminyan on 2019/3/11.
 */
@RestController
@RequestMapping("/order")
public class OrderControlller {
    @Autowired
    OrderStateMachineService orderStateMachineService;

    @RequestMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String haode(String a, String b, List<String> pam) {
        return "ok";
    }

    @RequestMapping(value = "/create")
    public String createOrder(Integer orderId) {
        try {
            orderStateMachineService.createOrders(orderId);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "success";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String payOrder(Integer orderId) {
        return orderStateMachineService.payedOrders(orderId);
    }
}
