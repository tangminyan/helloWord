package baobei;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by tangminyan on 2019/3/1.
 */
@SpringBootApplication
@EntityScan("baobei.cute")
@ComponentScan(basePackages = {"baobei.cute"}) // controller service注解
@EnableJpaRepositories("baobei.cute") //jpa
@ServletComponentScan
public class CandyHackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CandyHackerApplication.class, args);
    }

}









