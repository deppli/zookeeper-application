package org.zk.application.core.distconfigure.service;

import freemarker.template.Template;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;
import org.zk.application.core.distconfigure.pojo.MailSendInfo;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lishuhong on 16/7/1.
 */
public class MailService {
    @Resource
    private JavaMailSender javaMailSenderImpl;

    @Resource
    private FreeMarkerConfigurer freemarkerConfig;


    public void sendMail(MailSendInfo mailSendInfo) {
        if (mailSendInfo.getType() == MailSendTypeEnum.TEXT) {
            sendTextMail(mailSendInfo);
        }else if (mailSendInfo.getType() == MailSendTypeEnum.HTML){
            sendHtmlMail(mailSendInfo);
        }


    }

    private void sendHtmlMail(MailSendInfo mailSendInfo) {

    }

    private void sendTextMail(MailSendInfo mailSendInfo) {

    }


    private String getHtml(String path, Map<String,String> params) {
        try {
            Template template = freemarkerConfig.getConfiguration().getTemplate(path);

        } catch (IOException e) {
            return null;
        }


        return null;
    }



}
