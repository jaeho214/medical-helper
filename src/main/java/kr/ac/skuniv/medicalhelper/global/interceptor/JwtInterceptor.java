package kr.ac.skuniv.medicalhelper.global.interceptor;

import kr.ac.skuniv.medicalhelper.domain.member.exception.UnauthorizedUserException;
import kr.ac.skuniv.medicalhelper.global.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.persistence.Converter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final String HEADER_AUTH = "token";

    @Autowired
    JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String token = request.getHeader(HEADER_AUTH);

        if(token != null && jwtService.isUsable(token)){
            return true;
        }else{
            throw new UnauthorizedUserException();
        }
    }
}
