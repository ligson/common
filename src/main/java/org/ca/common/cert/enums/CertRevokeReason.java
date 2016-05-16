package org.ca.common.cert.enums;

/**
 * Created by ligson on 2016/5/16.
 */
public enum CertRevokeReason {
    unused(1, "未知"),
    keyCompromise(2, "密钥遭受损害"),
    caCompromise(3, "CA 遭受损害"),
    affiliationChanged(4, "从属关系变动"),
    superseded(5, "证书被替代"),
    cessationOfOperation(6, "停止使用"),
    certificateHold(7, "证书暂停使用");
    private int code;
    private String msg;

    CertRevokeReason(int code, String msg) {
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
