package com.mark.vote.service.impl;

import com.mark.vote.common.ServerResponse;
import com.mark.vote.controller.request.LoginRequest;
import com.mark.vote.controller.request.RegisterInfo;
import com.mark.vote.dao.UserInfoMapper;
import com.mark.vote.dao.manual.MUserInfoMapper;
import com.mark.vote.model.UserInfo;
import com.mark.vote.service.IUserInfoService;
import com.mark.vote.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService{

    @Autowired
    private MUserInfoMapper mUserInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ServerResponse<UserInfo> registrate(RegisterInfo info) {
        ServerResponse serverResponse = this.checkEmail(info.getEmail());
        if (!serverResponse.success()) {
            return serverResponse;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(info.getEmail());
        userInfo.setPassword(MD5Util.MD5EncodeUtf8(info.getPassword()));
        userInfo.setPhone(info.getPhone());

        int result = mUserInfoMapper.insertSelective(userInfo);
        if (result > 0) {
            userInfo = userInfoMapper.selectByPrimaryKey(result);
            userInfo.setPhone(null);
            return ServerResponse.createBySuccess(userInfo);
        }

        return ServerResponse.createByErrorMessage("注册失败");
    }

    @Override
    public ServerResponse<UserInfo> login(LoginRequest loginRequest) {
        String password = MD5Util.MD5EncodeUtf8(loginRequest.getPassword());
        int count = mUserInfoMapper.countByEmailAndPassword(loginRequest.getEmail(), password);
        if (count > 0) {
            UserInfo info = mUserInfoMapper.selectByEmailAndPassword(loginRequest.getEmail(), password);
            if (info != null) {
                info.setPassword(null);
                return ServerResponse.createBySuccess(info);
            }
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        return ServerResponse.createByErrorMessage("邮箱未注册或密码错误");
    }

    @Override
    public ServerResponse checkEmail(String email) {
        int count = mUserInfoMapper.countByEmail(email);
        if (count > 0) {
            return ServerResponse.createByErrorMessage("邮箱已被注册");
        }
        return ServerResponse.createBySuccessMessage("邮箱可用于注册");
    }


}
