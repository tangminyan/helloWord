package baobei.cute.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


/**
 * Created by tangminyan on 2019/3/19.
 */

@Configuration
public class OAuth2Configuration {

    @Configuration
    @EnableResourceServer //开启资源服务器
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Autowired
        private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

        @Autowired
        private CustomLogoutSuccessHandler customLogoutSuccessHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.exceptionHandling()
            .authenticationEntryPoint(customAuthenticationEntryPoint)
            .and()
            .logout()
            .logoutUrl("oauth/logout")
            .logoutSuccessHandler(customLogoutSuccessHandler)
            .and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/secure/**").authenticated();
        }
    }
}


















