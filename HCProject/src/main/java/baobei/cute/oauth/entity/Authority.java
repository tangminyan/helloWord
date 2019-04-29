package baobei.cute.oauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by tangminyan on 2019/3/19.
 */
@Entity
@Setter
@Getter
public class Authority {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 0, max = 50)
    private String name;
}
