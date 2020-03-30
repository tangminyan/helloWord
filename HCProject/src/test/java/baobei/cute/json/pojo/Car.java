package baobei.cute.json.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by tangminyan on 2019/5/30.
 */
@Getter
@Setter
public class Car {
    private String brand;
    private String color;
    private List<Address> addList;
}
