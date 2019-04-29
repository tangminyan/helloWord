package baobei.cute.rabbimq.controller;

import baobei.cute.rabbimq.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangminyan on 2019/3/12.
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    @Autowired
    private RabbitService rabbitService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String createOrder() {
        rabbitService.testRabbit();
        return "ok";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public String createOrder2() {
        rabbitService.testRabbit2();
        return "ok";
    }

    @RequestMapping(value = "/testMsg", method = RequestMethod.POST)
    public String testMsg() {
        rabbitService.testMessageBack();
        return "ok";
    }
}
