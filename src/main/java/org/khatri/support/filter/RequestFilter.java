package org.khatri.support.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestFilter implements Filter {

    public static final Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("Init Called");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("Filter called");
        try {
            // Setup MDC data:
            MDC.put("RequestId", UUID.randomUUID().toString()); //Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
            chain.doFilter(request, response);
        } finally {
            LOGGER.debug("Finally Called");
            // Tear down MDC data:
            // ( Important! Cleans up the ThreadLocal data again )
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
        LOGGER.debug("Destroy called");
    }
}