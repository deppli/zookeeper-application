package org.zk.application.core.distconfigure.pojo;

import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;

import java.io.File;
import java.util.List;
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

    private Map<String,File> fileMap;

    private String text;

    private MailSendTypeEnum type;

    public MailSendTypeEnum getType() {
        return type;
    }

    public void setType(MailSendTypeEnum type) {
        this.type = type;
    }


    public Map<String, File> getFileMap() {
        return fileMap;
    }

    public void setFileMap(Map<String, File> fileMap) {
        this.fileMap = fileMap;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
