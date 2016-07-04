package org.zk.application.core.distconfigure.pojo;

import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;

import java.util.Map;

/**
 * Created by lishuhong on 16/5/23.
 */
public class MailSendInfo {

    private String fromAddress;

    private String toAddress;

    private String subject;

    private Map<String,String> params;

    private String ftlName;

    private String[] fileNames;

    private MailSendTypeEnum type;

    public MailSendTypeEnum getType() {
        return type;
    }

    public void setType(MailSendTypeEnum type) {
        this.type = type;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public void setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getFtlName() {
        return ftlName;
    }

    public void setFtlName(String ftlName) {
        this.ftlName = ftlName;
    }
}
