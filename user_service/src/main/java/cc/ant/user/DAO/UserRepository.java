package cc.ant.user.DAO;

import cc.ant.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByusername(String username);

    User save(User user);
}
