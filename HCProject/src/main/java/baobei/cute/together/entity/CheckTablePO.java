package baobei.cute.together.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by tangminyan on 2019/3/1.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ckeck_table")
public class CheckTablePO {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private Integer status;

    private LocalDateTime createTime = LocalDateTime.now();
}
