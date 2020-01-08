package kr.ac.skuniv.medicalhelper.global.jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private final String SECRET_KEY = "MEDICALHELPER";
    private final long EXPIRE_TIME = 100000 * 60 * 60;

    public String createJwt(String userId){
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("ID", userId);

        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + EXPIRE_TIME);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("issueDate", System.currentTimeMillis())
                .setClaims(claimMap)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                //직렬화
                .compact();
    }

    private byte[] generateKey() {
        try{
            return SECRET_KEY.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new SecretKeyConvertFailException();
        }
    }

    public boolean isUsable(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException e){
            return false;
        }
    }

    public String findUserIdByJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(token)
                .getBody();

        return (String) claims.get("ID");
    }
}
