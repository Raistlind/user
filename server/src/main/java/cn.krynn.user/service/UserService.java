package cn.krynn.user.service;

import cn.krynn.user.dataobject.UserInfo;

/**
 * Created by RaistlinD
 * 2018/10/8 11:02 PM
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
