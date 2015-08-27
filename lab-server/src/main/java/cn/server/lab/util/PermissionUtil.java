package cn.server.lab.util;

import cn.server.lab.entity.Permission;
import cn.server.lab.entity.out.OutPermission;

import java.util.List;

/**
 * Created by Fu Zhong on 2015/8/20.
 */
public class PermissionUtil {

    public static List<Permission> getPermissionChildren (List<Permission> list, String id) {
        List<Permission> children = null;
        if (list != null || list.size() > 0) {
            for (Permission permission : list) {
                if (permission instanceof OutPermission) {
                    OutPermission out = (OutPermission) permission;
                    if (out.getId().equals(id)) {
                        children = out.getChildren();
                    } else {
                        children = getPermissionChildren(out.getChildren(), id);
                    }
                    if (children != null){
                        return children;
                    }
                }
            }
        }
        return children;
    }
}
