package com.mark.vote.controller;

import com.mark.vote.common.Const;
import com.mark.vote.common.ResponseCode;
import com.mark.vote.common.ServerResponse;
import com.mark.vote.controller.request.LoginRequest;
import com.mark.vote.controller.request.RegisterInfo;
import com.mark.vote.model.UserInfo;
import com.mark.vote.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @PostMapping("/register")
    public ServerResponse<UserInfo> register(@Valid RegisterInfo registerInfo, HttpSession session) {
        if (!registerInfo.getPassword().equals(registerInfo.getPasswordAgain())) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        ServerResponse serverResponse = iUserInfoService.registrate(registerInfo);
        if (serverResponse.success()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    @PostMapping("/login")
    public ServerResponse<UserInfo> login(@Valid LoginRequest loginRequest, HttpSession session) {
        ServerResponse serverResponse = iUserInfoService.login(loginRequest);
        if (serverResponse.success()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    @GetMapping("/info")
    public ServerResponse<UserInfo> getUserInfo(HttpSession session) {
        UserInfo info = (UserInfo) session.getAttribute(Const.CURRENT_USER);
        if (info != null) {
            return ServerResponse.createBySuccess(info);
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
    }

    @GetMapping("/check_email")
    public ServerResponse checkEmail(@Email String email) {
        return iUserInfoService.checkEmail(email);
    }

}
