package cn.edu.xju.librarymanagementsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JWT {
    static String signKey = "Javalibrarymanagementsystem";
    public static String getJWT(Map<String, Object> claims) {
        String jwtToken = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();
        return jwtToken;
    }
    
    public static Claims parseJWT(String jwtToken) {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwtToken)
                .getBody();
        return claims;
    }
}