package com.exalt.tasks.springboot.errorehandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomErrorController.class);

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        String errorPage = "error";
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status == null) return errorPage;

        Integer statusCode = Integer.valueOf(status.toString());
        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            //handle the error
            errorPage = "error/404";
            LOGGER.error("Error 404");
        } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
            errorPage = "error/403";
        }

        return errorPage;
    }


}
