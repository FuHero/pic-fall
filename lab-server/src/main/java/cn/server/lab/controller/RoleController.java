package cn.server.lab.controller;

import cn.server.lab.entity.Permission;
import cn.server.lab.entity.Role;
import cn.server.lab.entity.User;
import cn.server.lab.entity.in.InRole;
import cn.server.lab.entity.in.InUser;
import cn.server.lab.model.Result;
import cn.server.lab.service.IPermissionService;
import cn.server.lab.service.IRoleService;
import cn.server.lab.util.PermissionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/21.
 */
@Controller
@RequestMapping(value = "/system/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "")
    public ModelAndView detail (@RequestParam String id) {
        ModelAndView view = new ModelAndView("macros/role");
        List<Permission> tree = permissionService.getTreePermissions(null);
        view.addObject("tree", tree);
        view.addObject("children", PermissionUtil.getPermissionChildren(tree, id));
        return view;
    }

    @RequestMapping(value = "/query")
    public @ResponseBody String query (InRole role) {
        List<Role> list = roleService.getRoleList(role);
        int total = roleService.getRoleTotal(role);
        return Result.toJSONSuccessResult(total, list);
    }

}
