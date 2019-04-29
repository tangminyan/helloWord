
package baobei.cute.oauth.dao;

import baobei.cute.oauth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by tangminyan on 2019/3/19.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username) ")
    User findByUsernameCaseInsensitive(@Param("username") String username);
}

