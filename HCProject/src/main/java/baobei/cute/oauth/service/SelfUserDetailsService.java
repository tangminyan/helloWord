package baobei.cute.oauth.service;

import baobei.cute.oauth.dao.UserRepository;
import baobei.cute.oauth.entity.Authority;
import baobei.cute.oauth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 将UserInfo提供给权限系统，需要实现自定义的UserDetailsService,
 * 只包含一个方法，实际运行中，系统会通过这个方法获得登录用户的信息
 *
 * Created by tangminyan on 2019/3/19.
 */
@Service
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        String lowerCaseLogin = login.toLowerCase();

        User userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowerCaseLogin);
        if(ObjectUtils.isEmpty(userFromDatabase)) {
            throw new UsernameNotFoundException("User " + lowerCaseLogin + " was not found in database");
        }
        //获取用户所有权限形成SpringSecurity需要的集合
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(Authority authority : userFromDatabase.getAuthority()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority((authority.getName()));
            grantedAuthorities.add(grantedAuthority);
        }
        //返回SpringSecurity需要的集合
        return new org.springframework.security.core.userdetails.User(
                userFromDatabase.getUsername(),
                userFromDatabase.getPassword(),
                grantedAuthorities);
    }
}

















