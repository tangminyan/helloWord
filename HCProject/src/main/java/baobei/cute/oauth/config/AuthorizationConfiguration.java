package baobei.cute.oauth.config;

import baobei.cute.oauth.enums.AuthorityEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/**
 * Created by tangminyan on 2019/4/22.
 */

@Configuration
@EnableAuthorizationServer
public class  AuthorizationConfiguration extends AuthorizationServerConfigurerAdapter implements EnvironmentAware {

    private static final String ENV_OAUTH = "authentication.oauth";
    @Value("${authentication.oath.clientid}")
    private String PROP_CLIENTID;
    @Value("${authentication.oath.secret}")
    private String PROP_SECRET;
    @Value("${authentication.oath.tokenValidityInSeconds}")
    private Integer PROP_TOKEN_VALIDITY_SECONDS;

    private RelaxedPropertyResolver propertyResolver;

    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(PROP_CLIENTID)
                .scopes("read", "write")
                .authorities(AuthorityEnum.ROLE_ADMIN.name(), AuthorityEnum.ROLE_USER.name())
                .authorizedGrantTypes("password", "refresh_token")
                .secret(PROP_SECRET)
                .accessTokenValiditySeconds(PROP_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH);
    }
}
