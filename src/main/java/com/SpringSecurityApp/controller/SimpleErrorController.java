package com.SpringSecurityApp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
public class SimpleErrorController implements ErrorController {
	
	private static final String PATH = "/error";
	
	@RequestMapping(path=PATH)
    public void error(HttpServletResponse response) throws IOException {
		response.sendRedirect("/html/403.html");
    }
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}*/
