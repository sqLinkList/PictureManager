package com.yupi.yupicturebackend.model.dto.user;

import java.io.Serializable;

public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -4736848543355614070L;
    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 确认密码
     */
    private String checkPassword;


    public String getUserAccount() {
        return userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }
}
