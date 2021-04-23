package com.bitacademy.mysite.exception;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bitacademy.dto.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void handleException(
			HttpServletRequest request,
			HttpServletResponse response,
			Exception e) throws Exception {
		// 1. 로깅
		System.out.println(e);

		// 2. 요청 구분
		String accept = request.getHeader("accept");
		if(accept.matches(".*application/json.*")) {
			/* JSON 응답 */
			response.setStatus(HttpServletResponse.SC_OK);
			
			JsonResult jsonResult = JsonResult.fail(e.toString());
			String jsonString = new ObjectMapper().writeValueAsString(jsonResult);
			
			OutputStream os = response.getOutputStream();
			os.write(jsonString.getBytes("utf-8"));
			os.close();
			
		} else {
			// 3. 사과
			request.setAttribute("error", e.toString());
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, response);
		}
	}
	
	
}
