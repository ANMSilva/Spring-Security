package com.nipun.Spring.Security.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@RequiredArgsConstructor
@Slf4j
public class WelcomeController {

    @GetMapping("")
    public String welcome() {
        log.info("Welcome to Spring Security");
        return "Welcome to Spring Security";
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    /**
     * CSRF (Cross-Site Request Forgery) attacks exploit the trust that a web application places in the user's browser.
     * Hackers trick users into performing unintended actions on websites where they are already authenticated.
     *
     * For example, a hacker could potentially deactivate your Netflix account by sending a forged request to the Netflix
     * server using your session ID stored in the browser's cookies
     *
     * How CSRF(cross-site request forgery) token works
     * A popular way to protect our applications from CSRF attacks is to create a CSRF token in the backend on login,
     * store this CSRF token on the frontend(not in cookies), and manually send this on every request.
     *
     * The backend can validate the CSRF token along with the session token when validating the request.
     *
     * A different frontend would not have access to the CSRF token since it is not saved as a
     * cookie and hence cannot be sent from a different web application.
     *
     * Prevents Cross-Site Request Forgery attacks where unauthorized commands are submitted by a user.
     * Essential for session-based applications with web forms to prevent CSRF attacks.
     *
     * */

    //Authentication types
    /**
     * When to Use Each?
     * Basic Authentication:
     *
     * Use for simple systems, internal tools, or as a quick solution for APIs with low security needs.
     * CSRF Protection:
     *
     * Essential for session-based applications with web forms to prevent CSRF attacks.
     * JWT Authentication:
     *
     * Ideal for modern web and mobile applications, especially those requiring stateless authentication and scalability.
     * */

}
