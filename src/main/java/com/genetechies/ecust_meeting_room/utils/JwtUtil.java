package com.genetechies.ecust_meeting_room.utils;

import com.genetechies.ecust_meeting_room.config.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;


@Component
public class JwtUtil {
    byte[] jwtSecretKey = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);

    public String generateToken(Authentication aUthentication){
        String username = aUthentication.getName();
        Date now = new  Date();
        Date expiredDate = new Date(now.getTime() + SecurityConstants.JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(Keys.hmacShaKeyFor(jwtSecretKey), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Claims claims =
                    Jwts.parserBuilder().setSigningKey(jwtSecretKey).build().parseClaimsJws(token).getBody();
            return claims != null && claims.getExpiration().after(new Date());
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Jwt parse exception or expired");
        }
    }
}
