package com.hku.common.core.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author pengzhengfa
 */
public class JwtUtil {
    
    /**
     * 密钥
     */
    private static final String secret = "hku";
    
    /**
     * @param userName   用户名
     * @param expireTime 过期时间
     * @return 加密的token
     */
    public static String createToken(String userName, Long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            /**
             * 附带userName信息
             */
            return JWT.create().withClaim("userName", userName)
                    /**
                     * 到期时间
                     */.withExpiresAt(date)
                    /**
                     * 创建一个新的JWT,并使用给定的算法进行标记
                     */.sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    /**
     * 校验 token 是否正确
     *
     * @param token    密钥
     * @param userName 用户名
     * @return 是否正确
     */
    public static boolean verify(String token, String userName) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            /**
             * 在token中附带了userName信息
             */
            JWTVerifier verifier = JWT.require(algorithm).withClaim("userName", userName).build();
            /**
             * 验证token
             */
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }
}