package com.aseguradora.apiHilda.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)  {

        AuthCredentials  authCredentials = new AuthCredentials();
            try {
                authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class );
            } catch (IOException e){

            }

        UsernamePasswordAuthenticationToken usernamPat = new UsernamePasswordAuthenticationToken(
                authCredentials.getMail(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );

                return getAuthenticationManager().authenticate(usernamPat);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
       UserDetailsImpl userDetails=  (UserDetailsImpl) authResult.getPrincipal();
       String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());

       response.addHeader("Authorization", "Bearer " + token);
       response.getWriter().flush();

       super.successfulAuthentication(request,response,chain,authResult);
    }
}
