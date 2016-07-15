package org.zk.application.core.distconfigure.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zk.application.core.distconfigure.constants.Constants;
import org.zk.application.core.distconfigure.enums.MailSendTypeEnum;
import org.zk.application.core.distconfigure.pojo.MailSendInfo;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishuhong on 16/7/13.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath*:applicationContext-*.xml"})
public class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    public void testSendHmtlMail() throws Exception{
        MailSendInfo mailSendInfo = new MailSendInfo();
        Map<String,String> params = new HashMap<String, String>();
        params.put("href","http://www.dianping.com");
        mailSendInfo.setFromAddress(Constants.MAIL_FROMADDRESS);
        mailSendInfo.setFtlName("mail.ftl");
        mailSendInfo.setToAddress("shuhong.li@dianping.com");
        mailSendInfo.setSubject("验证邮件");
        mailSendInfo.setType(MailSendTypeEnum.HTML);
        mailSendInfo.setParams(params);
        mailService.sendMail(mailSendInfo);
    }

    @Test
    public void testSendTextMail() throws Exception{
        MailSendInfo mailSendInfo = new MailSendInfo();
        mailSendInfo.setFromAddress(Constants.MAIL_FROMADDRESS);
        mailSendInfo.setToAddress("shuhong.li@dianping.com");
        mailSendInfo.setSubject("验证邮件");
        mailSendInfo.setText("test");
        mailSendInfo.setType(MailSendTypeEnum.TEXT);
        mailService.sendMail(mailSendInfo);
    }

}
