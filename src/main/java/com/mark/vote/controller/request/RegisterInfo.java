package com.mark.vote.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;

@Getter
@Setter
@ToString
public class RegisterInfo {

    @Email
    private String email;

    private String password;

    private String passwordAgain;
    @Null
    private String phone;
}
