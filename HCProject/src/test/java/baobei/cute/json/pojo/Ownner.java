package baobei.cute.json.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by tangminyan on 2019/5/30.
 */
@Getter
@Setter
public class Ownner {

    private String name;
    private int age;
    private Address address;
    private List<Car> cars;

    @Override
    public String toString() {
        return "name:" + this.name + "\n age:" + this.age +
                "\n address: province: " + this.address.getProvince() + "\t address: city:" + this.address.getCity() +
                "\n cars: [pinpai: " + this.cars.get(0).getBrand() + "\t yanse: "+this.cars.get(0).getColor() + "]" +
                "\n; [pinpai: " + this.cars.get(1).getBrand() + "\t yanse: "+this.cars.get(1).getColor() + "]" ;
    }
}
