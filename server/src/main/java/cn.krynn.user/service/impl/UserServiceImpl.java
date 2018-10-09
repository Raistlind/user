package cn.krynn.user.service.impl;

import cn.krynn.user.dataobject.UserInfo;
import cn.krynn.user.repository.UserInfoRepostory;
import cn.krynn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RaistlinD
 * 2018/10/8 11:08 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepostory repostory;

    @Override
    public UserInfo findByOpenid(String openid) {
        return repostory.findByOpenid(openid);
    }
}
