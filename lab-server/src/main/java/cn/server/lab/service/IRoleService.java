package cn.server.lab.service;

import cn.server.lab.entity.Role;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/21.
 */
public interface IRoleService {
    String createRole (Role role);
    void deleteRole (String id);
    String updateRole (Role role);
    List<Role> getRoleList (Role role);
    int getRoleTotal (Role role);
    Role getRole (Role role);
}
