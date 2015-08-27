package cn.server.lab.service.impl;

import cn.server.lab.dao.PermissionDAO;
import cn.server.lab.entity.Permission;
import cn.server.lab.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/16.
 */
@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    public List<Permission> getTreePermissions(String parentId) {
        return permissionDAO.queryTreeModel(parentId);
    }
}
