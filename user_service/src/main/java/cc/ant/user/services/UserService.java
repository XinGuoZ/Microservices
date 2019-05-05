package cc.ant.user.services;

import cc.ant.user.entity.User;

public interface UserService {
    User findByUserName(String username);

    User save(User user);
}
