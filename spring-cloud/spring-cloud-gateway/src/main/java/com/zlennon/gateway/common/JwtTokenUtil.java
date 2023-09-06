package com.zlennon.gateway.common;


import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;
import java.util.Map;

/**
 * @date 2021/3/9 16:17
 * @description jwt token 生成工具类
 */
@Slf4j
@Component
public class JwtTokenUtil {

    private final static Clock CLOCK = DefaultClock.INSTANCE;


    /**
     * 寻找证书文件
     */
    private static final InputStream INPUT_STREAM = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt_token.jks");
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    static { // 将证书文件里边的私钥公钥拿出来
        try {
            // java key store 固定常量
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(INPUT_STREAM, "123456".toCharArray());
            // jwt 为 命令生成整数文件时的别名
            privateKey = (PrivateKey) keyStore.getKey("jwt_token", "123456".toCharArray());
            publicKey = keyStore.getCertificate("jwt_token").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @author Administrator
     * @date 2021/3/9 17:36
     * @description 生成jwt token
     */
    public static String generateToken(Map<String, Object> claims, String subject, int expiration) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;
        // 生成签名密钥
        final Date createdDate = CLOCK.now();
        final Date expirationDate = calculateExpirationDate(createdDate, expiration);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(signatureAlgorithm, privateKey)
                .compact();

    }

    private static Date calculateExpirationDate(Date createdDate, int expiration) {
        return new Date(createdDate.getTime() + expiration);
    }

    /**
     * 解密Jwt内容
     *
     * @param jwt jwt
     * @return Claims
     */
    public static Claims parseJwtRsa256(String jwt) {
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(jwt).getBody();
    }

    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(privateKey).parseClaimsJws(token);
    }

}