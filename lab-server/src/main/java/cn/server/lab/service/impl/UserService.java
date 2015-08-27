package cn.server.lab.service.impl;

import cn.server.lab.dao.UserDAO;
import cn.server.lab.entity.User;
import cn.server.lab.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        User user = new User(username);
        user.setPassword(new SimpleHash("SHA-1", password, user.getUsername()).toString());
        user.setIsLock(false);
        List<User> list = userDAO.query(user);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> getUserList(User user) {
        return userDAO.query(user);
    }

    @Override
    public int getUserListTotal(User user) {
        return userDAO.total(user);
    }

    @Override
    public User getUser(User user) {
        user.setOffset(0);
        user.setLimit(1);
        List<User> list = userDAO.query(user);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public String addUser(User user) {
        User queryUser = new User(user.getUsername());
        if (userDAO.total(queryUser) != 0) {
            return MessageFormat.format("用户名以存在", user);
        }
        String password = user.getPassword();
        password = new SimpleHash("SHA-1", password, user.getUsername()).toString();
        user.setPassword(password);
        userDAO.create(user);
        return null;
    }

    @Override
    public void deleteUser(String id) {
        userDAO.delete(id);
    }

    @Override
    public String updateUser(User user) {
        if (StringUtils.hasText(user.getPassword())) {
            String password = user.getPassword();
            password = new SimpleHash("SHA-1", password, user.getUsername()).toString();
            user.setPassword(password);
        }
        userDAO.update(user);
        return null;
    }
}
