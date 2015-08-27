package cn.server.lab.entity.out;

import cn.server.lab.entity.Role;

/**
 * Created by Fu Zhong on 2015/8/21.
 */
public class OutRole extends Role {
    private String createUserName;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
