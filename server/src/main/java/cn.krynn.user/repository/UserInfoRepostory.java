package cn.krynn.user.repository;

import cn.krynn.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RaistlinD
 * 2018/10/8 11:00 PM
 */
public interface UserInfoRepostory extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);


}
