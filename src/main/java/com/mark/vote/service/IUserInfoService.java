package com.mark.vote.service;

import com.mark.vote.common.ServerResponse;
import com.mark.vote.controller.request.LoginRequest;
import com.mark.vote.controller.request.RegisterInfo;
import com.mark.vote.model.UserInfo;

public interface IUserInfoService {

    ServerResponse<UserInfo> registrate(RegisterInfo info);

    ServerResponse<UserInfo> login(LoginRequest loginRequest);

    ServerResponse checkEmail(String email);
}
