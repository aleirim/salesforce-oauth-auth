package com.demo.salesforce.salesforceAuth.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(Model model, WebRequest webRequest) {
        final Throwable error = errorAttributes.getError(webRequest);
        model.addAttribute("exception", error);
        model.addAttribute("error_message", error == null ? "" : error.getMessage());
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
