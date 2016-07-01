package org.zk.application.core.distconfigure.enums;

/**
 * Created by lishuhong on 16/7/1.
 * 邮件发送方式泛型
 */
public enum MailSendTypeEnum {
    /**
     * 文本方式
     */
    TEXT("text"),
    /**
     * html方式
     */
    HTML("html");

    private String value;

    private MailSendTypeEnum(String value){
        this.value = value;
    }
}
