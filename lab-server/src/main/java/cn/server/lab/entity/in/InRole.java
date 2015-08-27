package cn.server.lab.entity.in;

import cn.server.lab.entity.Role;

/**
 * Created by Fu Zhong on 2015/8/21.
 */
public class InRole extends Role {
    private String createUserName;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
