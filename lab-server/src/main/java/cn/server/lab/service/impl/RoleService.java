package cn.server.lab.service.impl;

import cn.server.lab.dao.RoleDAO;
import cn.server.lab.entity.Role;
import cn.server.lab.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/21.
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public String createRole(Role role) {
        Role queryRole = new Role(role.getName(), null);
        if (roleDAO.total(queryRole) != 0) {
            return MessageFormat.format("角色名以存在", role);
        }
        roleDAO.create(role);
        return null;
    }

    @Override
    public void deleteRole(String id) {
        roleDAO.delete(id);
    }

    @Override
    public String updateRole(Role role) {
        Role queryRole = new Role(role.getName(), null);
        if (roleDAO.total(queryRole) != 0) {
            return MessageFormat.format("角色名以存在", role);
        }
        roleDAO.update(role);
        return null;
    }

    @Override
    public List<Role> getRoleList(Role role) {
        return roleDAO.query(role);
    }

    @Override
    public int getRoleTotal(Role role) {
        return roleDAO.total(role);
    }

    @Override
    public Role getRole(Role role) {
        role.setOffset(0);
        role.setLimit(1);
        List<Role> list = roleDAO.query(role);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
