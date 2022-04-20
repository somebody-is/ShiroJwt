package com.lzf.shirojwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public class JwtUtils {

    public static final String SECRET = "A person's travel, meet the most real yourself on the road";

    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static final Long EXPIRE_TIME = 1000L * 60 *60;

    public static String sign(Integer id){
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .setSubject("JWT")
                // 过期时间
                .setExpiration(new Date(now + EXPIRE_TIME))
                .claim("userId", id)
                //.claim("username",id)
                // 使用secretKey进行签名
                .signWith(SECRET_KEY)
                .compact();
    }

    public static boolean verify(String token){
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().requireSubject("JWT").setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static Integer getId(String token) throws Exception{
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        return (Integer) claims.get("userId");
    }

}
