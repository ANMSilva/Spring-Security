package com.nipun.Spring.Security.service.Impl;

import com.nipun.Spring.Security.service.HttpRequestHeaderManagementService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HttpHeaderManagementServiceImpl implements HttpRequestHeaderManagementService {

    @Override
    public void getHttpHeaderLogs(HttpServletRequest request) {
        log.info(request.getSession().getId());
        log.info(request.getHeader("cookie"));
        log.info(request.getHeader("Authorization"));
        log.info(request.getHeader("X-Requested-With"));
        log.info(request.getHeader("User-Agent"));
        log.info(request.getHeader("Referer"));
        log.info(request.getHeader("Accept"));
        log.info(request.getHeader("Accept-Language"));
        log.info(request.getHeader("Accept-Encoding"));
        log.info(request.getHeader("Connection"));
        log.info(request.getHeader("Host"));
        log.info(request.getHeader("Cache-Control"));
        log.info(request.getHeader("Pragma"));
        log.info(request.getHeader("If-Modified-Since"));
        log.info(request.getHeader("If-None-Match"));
    }
}
