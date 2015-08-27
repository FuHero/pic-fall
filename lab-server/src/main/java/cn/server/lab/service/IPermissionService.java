package cn.server.lab.service;

import cn.server.lab.entity.Permission;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/16.
 */
public interface IPermissionService {
    List<Permission> getTreePermissions (String parentId);
}
