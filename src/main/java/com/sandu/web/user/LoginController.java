package com.sandu.web.user;

import com.sandu.api.user.input.LoginInput;
import com.sandu.api.user.model.bo.LoginBO;
import com.sandu.api.user.output.LoginVO;
import com.sandu.api.user.service.biz.UserBizService;
import com.sandu.common.BaseController;
import com.sandu.common.ReturnData;
import com.sandu.constant.ResponseEnum;
import com.sandu.util.ReturnDataUtil;
import com.sandu.web.context.LoginContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@SuppressWarnings("unchecked")
@RestController
@Api(value = "登录", tags = "登录")
@Validated
public class LoginController extends BaseController {

    @Resource
    private UserBizService userBizService;

    @PostMapping("/login")
    @ApiOperation(value = "登录", response = LoginVO.class)
    public ReturnData<LoginVO> login(@Valid @RequestBody LoginInput loginInput, BindingResult br, HttpSession session) {

        if (br.hasErrors()) {
            return processValidError(br, ReturnData.builder());
        }
        LoginBO loginBO = userBizService.login(loginInput);
        LoginVO loginVO = LoginVO.builder()
                .auth(loginBO.getAuth())
                .nickname(loginBO.getNickname())
                .token(session.getId())
                .build();
        LoginContext.storageLoginInfo(session, loginVO);
        return ReturnData.builder().data(loginVO).code(ResponseEnum.SUCCESS);
    }

    @PostMapping
    @ApiOperation(value = "退出登录", response = ReturnData.class)
    public ReturnData logout(@Valid @RequestBody Token token, BindingResult br) {
        if (br.hasErrors()) {
            return processValidError(br, ReturnData.builder());
        }
        LoginContext.removeLoginInfo(token.getToken());
        return ReturnData.builder().code(ResponseEnum.SUCCESS);
    }


    @Data
    @ApiModel("token")
    private static class Token {
        @NotEmpty(message = "token不能为空")
        @ApiModelProperty("token")
        private String token;
    }
}
