package com.sandu.api.user.service.biz;

import com.sandu.api.user.input.LoginInput;
import com.sandu.api.user.model.bo.LoginBO;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
public interface UserBizService {

    /**
     * 登录
     * @param loginInput 登录信息
     * @return 信息
     */
    LoginBO login(LoginInput loginInput);
}
