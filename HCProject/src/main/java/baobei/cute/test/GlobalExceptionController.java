package baobei.cute.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangminyan on 2020/3/26.
 */
@Controller
@RequestMapping("/exception")
@Slf4j
public class GlobalExceptionController {

    @RequestMapping("/math")
    public void exceptionTest() {
        int i = 1/0;
    }
}
