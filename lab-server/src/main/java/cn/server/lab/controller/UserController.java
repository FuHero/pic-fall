package cn.server.lab.controller;

import cn.server.lab.entity.Permission;
import cn.server.lab.entity.User;
import cn.server.lab.entity.in.InUser;
import cn.server.lab.model.Result;
import cn.server.lab.service.IPermissionService;
import cn.server.lab.service.IUserService;
import cn.server.lab.util.PermissionUtil;
import cn.server.lab.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Controller
@RequestMapping(value = "/system/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "")
    public ModelAndView detail (@RequestParam String id) {
        ModelAndView view = new ModelAndView("macros/user");
        List<Permission> tree = permissionService.getTreePermissions(null);
        view.addObject("tree", tree);
        view.addObject("children", PermissionUtil.getPermissionChildren(tree, id));
        return view;
    }

    @RequestMapping(value = "/query")
    public @ResponseBody String query (InUser user) {
        List<User> list = userService.getUserList(user);
        int total = userService.getUserListTotal(user);
        return Result.toJSONSuccessResult(total, list);
    }

    @RequestMapping(value = "/add")
    public @ResponseBody String create (User user) {
        String msg = userService.addUser(user);
        if (StringUtils.hasText(msg)) {
            return  Result.toJSONFailResult(msg);
        }
        return  Result.toJSONSuccessResult(null);
    }

    @RequestMapping(value = "/update")
    public @ResponseBody String update (User user) {
        user.setIsLock(null);
        user.setIsDelete(null);
        user.setPassword(null);
        String msg = userService.updateUser(user);
        if (StringUtils.hasText(msg)) {
            return  Result.toJSONFailResult(msg);
        }
        return  Result.toJSONSuccessResult(null);
    }

    @RequestMapping(value = "/password")
    public @ResponseBody String updatePassword (User user) {
        User updateUser = new User(user.getUsername());
        updateUser.setId(user.getId());
        updateUser.setPassword(user.getPassword());
        String msg = userService.updateUser(updateUser);
        if (StringUtils.hasText(msg)) {
            return  Result.toJSONFailResult(msg);
        }
        return  Result.toJSONSuccessResult(null);
    }

    @RequestMapping(value = "/del")
    public @ResponseBody String updateDelete (User user) {
        User updateUser = new User(user.getUsername());
        updateUser.setId(user.getId());
        updateUser.setIsDelete(true);
        String msg = userService.updateUser(updateUser);
        if (StringUtils.hasText(msg)) {
            return  Result.toJSONFailResult(msg);
        }
        return  Result.toJSONSuccessResult(null);
    }

    @RequestMapping(value = "/lock")
    public @ResponseBody String updateLock (User user) {
        User updateUser = new User(user.getUsername());
        updateUser.setId(user.getId());
        updateUser.setIsLock(user.getIsLock());
        String msg = userService.updateUser(updateUser);
        if (StringUtils.hasText(msg)) {
            return  Result.toJSONFailResult(msg);
        }
        return  Result.toJSONSuccessResult(null);
    }

}
