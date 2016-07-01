package org.zk.application.core.distconfigure.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;
import org.zk.application.core.distconfigure.pojo.MailSendInfo;

import javax.annotation.Resource;

/**
 * Created by lishuhong on 16/7/1.
 */
public class MailService {
    @Resource
    private JavaMailSender JavaMailSenderImpl;

    @Resource
    private FreeMarkerConfigurer freemarkerConfig;

    public void sendMail(MailSendInfo mailSendInfo) {
        if (mailSendInfo.getType() == MailSendTypeEnum.TEXT) {
            sendTextMail(mailSendInfo);
        }else if (mailSendInfo.getType() == MailSendTypeEnum.HTML){
            sendHtmlMail(mailSendInfo);
        }


    }

    private void sendTextMail(MailSendInfo mailSendInfo) {

    }


    private void sendHtmlMail(MailSendInfo mailSendInfo) {

    }

}
