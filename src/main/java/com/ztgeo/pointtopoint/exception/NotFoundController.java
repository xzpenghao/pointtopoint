package com.ztgeo.pointtopoint.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class NotFoundController {
    @Controller
    public class NotFoundException implements ErrorController {

        @Override
        public String getErrorPath() {
            return "/error";
        }

        @RequestMapping(value = {"/error"})
        @ResponseBody
        public Object error(HttpServletRequest request) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", "not found");
            body.put("code", "404");
            return body;
        }
    }
}
