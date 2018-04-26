package com.sandu.api.user.model.bo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author by bvvy
 * @date 2018/4/25
 */
@Data
@Builder
public class LoginBO {
    private List<String> auth;
    private String nickname;
}
