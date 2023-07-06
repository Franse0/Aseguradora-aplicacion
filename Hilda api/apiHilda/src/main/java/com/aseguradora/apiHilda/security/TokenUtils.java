package com.aseguradora.apiHilda.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private final static String ACCES_TOKEN_SECRET="4qhq8LrBfYcaRHxhdb9zURb32rf8e7Uc";

    private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String nombre, String mail){
        Long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS*1000;
        Date expirateDate  = new Date(System.currentTimeMillis()+expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);

        return Jwts.builder()
                .setSubject(mail)
                .setExpiration(expirateDate)
                .addClaims(extra)
              /*  .signWith(SignatureAlgorithm.HS256, ACCES_TOKEN_SECRET.getBytes())*/
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();

    }


    public static UsernamePasswordAuthenticationToken getAuthentication(String token)throws Exception{
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String mail = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(mail,  null, Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}
