package org.zk.application.core.distconfigure.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.zk.application.core.distconfigure.pojo.User;

import javax.annotation.Resource;

/**
 * Created by lishuhong
 */
@Service
public class UserService {

    @Resource
    private SqlSession sqlSession;



}
