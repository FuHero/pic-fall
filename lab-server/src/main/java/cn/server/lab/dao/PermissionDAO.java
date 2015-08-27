package cn.server.lab.dao;

import cn.server.lab.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/16.
 */
@Repository
public interface PermissionDAO {
    List<Permission> queryTreeModel (String parentId);
}
