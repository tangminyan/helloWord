package baobei.cute.json;

import baobei.cute.json.pojo.Ownner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * Created by tangminyan on 2019/5/30.
 */

public class FastJsonTest {

    @Test
    public void jsonFunc() {
        String jsonStr = "{\n" +
                "    \"name\":\"zhangsan\",\n" +
                "    \"address\":{\"city\":\"shanghaishi\",\"province\":\"shanghai\"},\n" +
                "    \"age\":24,\n" +
                "    \"cars\":[\n" +
                "        {\n" +
                "            \"brand\":\"BMW\",\n" +
                "            \"color\":\"red\",\n" +
                "            \"addList\":[{\"city\":\"sh\",\"province\":\"ssh\"}]\n" +
                "        },\n" +
                "        {\n" +
                "            \"brand\":\"benz\",\n" +
                "            \"color\":\"black\",\n" +
                "            \"addList\":[{\"city\":\"hz\",\"province\":\"hhz\"}]\n" +
                "        }\n" +
                "        ]\n" +
                "}";
        Ownner ownner = JSONObject.parseObject(jsonStr, Ownner.class);
        System.out.println(ownner);
        Ownner own = new Ownner();
        BeanUtils.copyProperties(JSON.parseObject(jsonStr, Ownner.class), own);
        System.out.println(own);
    }
}
