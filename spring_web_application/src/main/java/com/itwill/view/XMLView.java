package com.itwill.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

public class XMLView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/*********************
		 * forward************************** RequestDispatcher rd =
		 * request.getRequestDispatcher("xxx.jsp"); rd.forward(request, response);
		 ********************************************************/
		/*********************
		 * redirect************************** response.sendRedirect("xxx.do");
		 ********************************************************/
	}

}
