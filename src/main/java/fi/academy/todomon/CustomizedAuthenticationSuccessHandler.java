package fi.academy.todomon;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class CustomizedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) {
        try {

            response.setStatus(HttpServletResponse.SC_OK);

            boolean admin = false;

            logger.info("AT onAuthenticationSuccess(...) function!");

            for (GrantedAuthority auth : authentication.getAuthorities()) {
                if ("ROLE_ADMIN".equals(auth.getAuthority())) {
                    admin = true;
                }
            }

            if (admin) {
                response.sendRedirect("/admin");
            } else {
                response.sendRedirect("/main");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    Authentication tunnistus = SecurityContextHolder.getContext().getAuthentication();
  //  AuthenticationPrincipal
}