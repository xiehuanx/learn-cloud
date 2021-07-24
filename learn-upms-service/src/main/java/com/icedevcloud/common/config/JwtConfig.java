package com.icedevcloud.common.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Data
@Configuration
@ConfigurationProperties("jwt.config")
public class JwtConfig {

    private String secret;

    private long ttl;

    private String license;

    /**
     * 创建 JWT
     *
     * @return
     */
    public String createJWT(String id, String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        long ttlMillis = nowMillis + (ttl);
        Date now = new Date(nowMillis);
        Date exp = new Date(ttlMillis);

        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(signatureAlgorithm, secret)
                .setHeaderParam("typ", "JWT") //设置header
                .setIssuedAt(now)
                .setExpiration(exp)
                .setId(id)
                .setSubject(subject)
                .claim("license", license);

        return jwtBuilder.compact();
    }

    /**
     * 解析 JWT
     *
     * @param jwtStr
     * @return
     */
    public Claims parseJWT(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jwtStr)
                .getBody();
    }

}
