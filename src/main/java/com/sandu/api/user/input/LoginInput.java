package com.sandu.api.user.input;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@Data
public class LoginInput implements Serializable{

    @NotEmpty(message = "账号不能为空")
    @Length(min = 4,max = 20,message = "账号长度在{min}-{max}之间")
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 30,message = "密码在{min}-{max}之间")
    private String password;

}
