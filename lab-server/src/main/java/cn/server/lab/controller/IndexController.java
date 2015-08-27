package cn.server.lab.controller;

import cn.server.lab.entity.User;
import cn.server.lab.model.Message;
import cn.server.lab.model.Result;
import cn.server.lab.service.IPermissionService;
import cn.server.lab.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Fu Zhong on 2015/8/15.
 */
@Controller
public class IndexController {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/logout")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("macros/login");
        return view;
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("macros/index");
        view.addObject("tree", permissionService.getTreePermissions(null));
        return view;
    }

    @RequestMapping(value = "/login")
    public @ResponseBody String login (@RequestParam String username, @RequestParam String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        User user = userService.login(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("user", user);
        } catch (AuthenticationException e) {
            return Result.toJSONFailResult(Message.PASSWORD_ERROR);
        }
        return Result.toJSONSuccessResult(user);
    }
}
