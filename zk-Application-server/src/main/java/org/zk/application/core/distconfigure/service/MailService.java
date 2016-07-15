package org.zk.application.core.distconfigure.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang.StringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.CollectionUtils;
import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;
import org.zk.application.core.distconfigure.pojo.MailSendInfo;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * Created by lishuhong on 16/7/1.
 */
@Service
public class MailService {
    @Resource
    private JavaMailSender mailSender;

    @Resource
    private Configuration freeMarkerConfiguration;


    public void sendMail(MailSendInfo mailSendInfo) throws Exception {
        if (mailSendInfo.getType() == MailSendTypeEnum.TEXT) {
            sendTextMail(mailSendInfo);
        } else if (mailSendInfo.getType() == MailSendTypeEnum.HTML) {
            sendHtmlMail(mailSendInfo);
        }


    }

    private void sendHtmlMail(MailSendInfo mailSendInfo) throws Exception {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
        messageHelper.setTo(mailSendInfo.getToAddress());
        messageHelper.setFrom(mailSendInfo.getFromAddress());
        messageHelper.setSubject(mailSendInfo.getSubject());
        messageHelper.setText(getHtml(mailSendInfo.getFtlName(), mailSendInfo.getParams()), true);
        Map<String, File> fileMap = mailSendInfo.getFileMap();
        if (!CollectionUtils.isEmpty(fileMap)) {
            for (Map.Entry<String, File> entry : fileMap.entrySet()) {
                String name = entry.getKey();
                File file = entry.getValue();
                if (StringUtils.isNotEmpty(name) && file != null) {
                    messageHelper.addInline(name,file);
                }
            }
        }
        mailSender.send(mailMessage);
    }

    private void sendTextMail(MailSendInfo mailSendInfo) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailSendInfo.getFromAddress());
        mailMessage.setTo(mailSendInfo.getToAddress());
        mailMessage.setSubject(mailSendInfo.getSubject());
        mailMessage.setText(mailSendInfo.getText());
        mailSender.send(mailMessage);
    }


    private String getHtml(String path, Map<String, String> params) throws Exception {
        Template template = freeMarkerConfiguration.getTemplate(path);
        String resultHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
        return resultHtml;
    }

}
