package com.mark.vote.service;

import com.mark.vote.common.ServerResponse;
import com.mark.vote.model.Account;

public interface IAccountService {

    public ServerResponse register(Account account);

}
