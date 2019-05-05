package cc.ant.user.services.Impl;

import cc.ant.user.DAO.UserRepository;
import cc.ant.user.entity.User;
import cc.ant.user.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: user_service
 * @description:
 * @Author: XINGUOZ
 * @date: 2019-05-03 20:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public User findByUserName(String username) {
        return userRepository.findByusername(username);
    }

    @Override
    public User save(User user) {
        return  userRepository.save(user);
    }
}
