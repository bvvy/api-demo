package com.sandu.api.user.output;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@Data
@Builder
public class LoginVO implements Serializable{
    private String token;
    private List<String> auth;
    private String nickname;

}
