package cn.krynn.user.enums;

import lombok.Getter;

/**
 * Created by RaistlinD
 * 2018/10/9 10:34 PM
 */
@Getter
public enum RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
