package com.aseguradora.apiHilda.security;

import lombok.Data;

@Data
public class AuthCredentials {

    private String mail;
    private String password;
}
