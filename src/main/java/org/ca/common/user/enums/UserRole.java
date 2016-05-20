package org.ca.common.user.enums;

/**
 * Created by ligson on 2016/5/6.
 */
public enum UserRole {
    USER(1, "普通用户"), RA_ADMIN(2, "RA管理员"), CA_ADMIN(3, "CA管理员"), OFFLINE_ADMIN(4, "离线CA管理员"), SUPER(100, "超级管理员");
    private int code;
    private String msg;

    UserRole(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
