package com.SpringSecurityApp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.SpringSecurityApp.model.ErrorJson;

@RestController
public class SimpleErrorController implements ErrorController {

	
	 /* private static final String PATH = "/error";
	 * 
	 * @RequestMapping(path=PATH) public void error(HttpServletResponse
	 * response) throws IOException { //response.sendRedirect("/index.html");
	 * response.sendError(HttpServletResponse.SC_UNAUTHORIZED); }
	 * 
	 * @Override public String getErrorPath() { return "/error"; }
	 * 
	 * }
	 */

	private static final String PATH = "/error";

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping(value = PATH)
	/*ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
		// Appropriate HTTP response code (e.g. 404 or 500) is automatically set
		// by Spring.
		// Here we just define response body.
		return new ErrorJson(response.getStatus(), getErrorAttributes(request, false));
	}*/
	ErrorJson error(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Appropriate HTTP response code (e.g. 404 or 500) is automatically set
		// by Spring.
		// Here we just define response body.
		
		if((getErrorAttributes(request, false).get("message"))=="Unauthorized"){
			response.sendRedirect("/");
		}
		System.out.println(getErrorAttributes(request, false));
		return new ErrorJson(response.getStatus(), getErrorAttributes(request, false));
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	}

}
