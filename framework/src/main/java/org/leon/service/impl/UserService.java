package org.leon.service.impl;

import org.leon.annotation.Service;
import org.leon.entity.User;
import org.leon.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/8/7 20:53
 * @Description:
 */
@Service
public class UserService implements IUserService {
    /**
     * 获取所有用户
     */
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Tom", 22));
        userList.add(new User(2, "Alic", 12));
        userList.add(new User(3, "Bob", 32));
        return userList;
    }

    @Override
    public User GetUserInfoById(Integer id) {
        return null;
    }

    @Override
    public boolean updateUser(int id, Map<String, Object> fieldMap) {
        return false;
    }
}
