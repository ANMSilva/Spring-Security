package com.nipun.Spring.Security.controller;

import com.nipun.Spring.Security.service.HttpRequestHeaderManagementService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
@Slf4j
@RequiredArgsConstructor
public class LoggingController {

    private final HttpRequestHeaderManagementService httpRequestHeaderManagementService;

    @GetMapping("/log")
    public ResponseEntity<String> log(HttpServletRequest request) {
        ResponseEntity<String> responseEntity = null;
        log.info("Logging process started ");

        try {
            String message = "This is a demo for Spring Security";

            //log http header details
//            httpRequestHeaderManagementService.getHttpHeaderLogs(request);

            responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
            log.info("Logging process completed ");

        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            log.error("Exception occurred while logging");
            throw e;
        }

        return responseEntity;
    }
}
