package com.sandu.web.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CopyRight (c) 2018 Sandu Technology Inc.
 * <p>
 * sandu-api-demo
 *
 * @author sandu (yocome@gmail.com)
 * @datetime 2018/4/24 11:41
 */
@RestController
@Api(value = "用户", tags = "User")
@RequestMapping(value = "/v1/user")
public class UserController {

    @PostMapping(value = "/login")
    public void login(){

    }

    @GetMapping(value = "/logout")
    public void logout(){

    }

}
