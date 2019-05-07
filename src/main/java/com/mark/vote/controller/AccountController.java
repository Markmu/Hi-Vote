package com.mark.vote.controller;

import com.mark.vote.common.ServerResponse;
import com.mark.vote.model.Account;
import com.mark.vote.service.IAccountService;
import com.mark.vote.util.MD5Util;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Controller for account service
 *
 * @author Mark C. Mu
 */


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;


    @PostMapping(path = "/register")
    public ServerResponse register(Account account) {

        String encryptedPasswod = MD5Util.MD5EncodeUtf8(account.getPassword());
        account.setPassword(encryptedPasswod);
        DateTime dateTime = new DateTime();
        Date now = new Date(dateTime.toInstant().getMillis());
        account.setCreateTime(now);
        return iAccountService.register(account);
    }


}
