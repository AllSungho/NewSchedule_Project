package org.example.newschedule_project.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/user/signup", "/login", "/logout"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        // 많은 기능을 위해 다운 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // 많은 기능을 위해 다운 캐스팅
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if(!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute("sessionKey value") == null) {
                throw new RuntimeException("로그인 해주십셔");
            }
        }

        chain.doFilter(request, response);
    }

    public boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
