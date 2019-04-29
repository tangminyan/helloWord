package baobei.cute.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tangminyan on 2019/4/23.
 */
@Controller
public class loginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginSuccess() {
        return "index";
    }

}
