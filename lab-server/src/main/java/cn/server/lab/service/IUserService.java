package cn.server.lab.service;

import cn.server.lab.entity.User;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
public interface IUserService {
    User login (String username, String password);
    List<User> getUserList (User user);
    int getUserListTotal (User user);
    User getUser (User user);
    String addUser (User user);
    void deleteUser (String id);
    String updateUser (User user);
}
