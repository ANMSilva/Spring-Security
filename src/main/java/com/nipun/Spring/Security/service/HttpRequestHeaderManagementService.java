package com.nipun.Spring.Security.service;

import jakarta.servlet.http.HttpServletRequest;

public interface HttpRequestHeaderManagementService {

    public void getHttpHeaderLogs(HttpServletRequest request);

}
