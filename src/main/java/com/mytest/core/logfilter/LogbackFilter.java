package com.mytest.core.logfilter;

import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: zouyongqi
 * @Description: 基于logback添加唯一追踪ID
 * @Date: Created in 18:51 2019-08-27
 */
public class LogbackFilter implements Filter {

//    private static final String UNIQUE_ID = "traceRootId";
    private static final String UNIQUE_ID = "TID";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean insertMDC = insertMDC();
        try {
            chain.doFilter(request, response);
        } finally {
            if(insertMDC) {
                MDC.remove(UNIQUE_ID);
            }
        }
    }

    private boolean insertMDC() {
        UUID uuid = UUID.randomUUID();
        String uniqueId = UNIQUE_ID + "-" + uuid.toString().replace("-","");
        MDC.put(UNIQUE_ID, uniqueId);
        return true;
    }

    @Override
    public void destroy() {

    }
}
