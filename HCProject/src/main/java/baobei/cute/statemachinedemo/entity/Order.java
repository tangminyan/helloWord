package baobei.cute.statemachinedemo.entity;

import baobei.cute.statemachinedemo.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by tangminyan on 2019/3/11.
 */
@Entity
@Table(name = "order_test")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue
    /**
     * JPA为开发人员提供了四种主键生成策略,其被定义在枚举类GenerationType中,
     * 包括GenerationType.TABLE,GenerationType.SEQUENCE,GenerationType.IDENTITY和GenerationType.AUTO
     */
    private Long id;

    @NotNull
    private Integer orderId;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    private String machineId;

    @Override
    public String toString() {
        return "Order{"+"\n orderId:"+orderId
                + "\n status:" + status + "\n machineId:" + machineId;
    }
}
