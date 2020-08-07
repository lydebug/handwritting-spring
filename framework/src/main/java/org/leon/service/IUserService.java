package org.leon.service;

import org.leon.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: liyang27
 * @Date: 2020/8/7 20:51
 * @Description:
 */
public interface IUserService {
    List<User> getAllUser();

    User GetUserInfoById(Integer id);

    boolean updateUser(int id, Map<String, Object> fieldMap);
}
