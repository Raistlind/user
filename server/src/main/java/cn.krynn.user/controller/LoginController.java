package cn.krynn.user.controller;

import cn.krynn.user.VO.ResultVO;
import cn.krynn.user.constant.CookieConstant;
import cn.krynn.user.dataobject.UserInfo;
import cn.krynn.user.enums.ResultEnum;
import cn.krynn.user.enums.RoleEnum;
import cn.krynn.user.repository.UserInfoRepostory;
import cn.krynn.user.service.UserService;
import cn.krynn.user.utils.CookieUtil;
import cn.krynn.user.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by RaistlinD
 * 2018/10/9 9:56 PM
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInfoRepostory repostory;

    @Autowired
    private UserService userService;

    /**
     * 买家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {

        // 1.openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. cookie里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     *
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response) {

        // 1.openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2.判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. cookie里设置openid=abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.EXPIRE);

        // 4. 写Redis

        return ResultVOUtil.success();
    }
}
