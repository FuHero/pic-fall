package cn.server.lab.controller;

import cn.server.lab.entity.Permission;
import cn.server.lab.model.Result;
import cn.server.lab.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/16.
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("macros/permission");
        view.addObject("tree", permissionService.getTreePermissions(null));
        return view;
    }

    @RequestMapping(value = "/query")
    public @ResponseBody String queryAll () {
        List<Permission> list = permissionService.getTreePermissions(null);
        return Result.toJSONSuccessResult(list.size(), list);
    }
}
