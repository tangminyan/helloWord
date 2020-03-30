package mock.ibs.waf.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangminyan on 2019/9/7.
 */
@Controller
@RequestMapping(value = "waf-product/IBS")
public class WafMockController {

    @RequestMapping("/add")
    public ResponseEntity add(JSONObject jsonObject) {
        JSONObject res = new JSONObject();
        res.put("errCode", 0);
        res.put("msg", "操作成功");
        return ResponseEntity.ok(res);
    }


}
