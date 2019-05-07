package com.mark.vote.service.impl;

import com.mark.vote.common.ServerResponse;
import com.mark.vote.dao.AccountMapper;
import com.mark.vote.model.Account;
import com.mark.vote.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public ServerResponse register(Account account) {
        int resultCount = accountMapper.insertSelective(account);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMessage("注册失败");
    }
}
