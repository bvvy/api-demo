package com.sandu.service.user.impl.biz;

import com.sandu.api.user.input.LoginInput;
import com.sandu.api.user.model.bo.LoginBO;
import com.sandu.api.user.output.LoginVO;
import com.sandu.api.user.service.biz.UserBizService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@Service("userBizService")
public class UserBizServiceImpl implements UserBizService {
    private static final String ERR_LOGIN_MSG = "用户名或密码错误";
    private static final Map<String, String> USER_PASSWORD = new HashMap<String, String>() {
        {
            put("user", "123456");
            put("admin", "123456");
        }
    };

    private static final Map<String, List<String>> USER_AUTH = new HashMap<String, List<String>>() {
        {
            put("user", Collections.singletonList("product:view"));
            put("admin", Arrays.asList("product:view", "product:add", "product:del", "product:manage", "product:edit"));
        }
    };

    @Override
    public LoginBO login(LoginInput loginInput) {
        if (loginInput.getPassword().equals(USER_PASSWORD.get(loginInput.getAccount()))) {
            return LoginBO.builder()
                    .nickname(loginInput.getAccount())
                    .auth(USER_AUTH.get(loginInput.getAccount()))
                    .build();
        } else {
            throw new RuntimeException(ERR_LOGIN_MSG);
        }
    }
}
