package by.htp.periodicals.web.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.periodicals.web.action.ActionManager;
import by.htp.periodicals.web.action.BaseAction;
import static by.htp.periodicals.web.util.WebConstantDecloration.*;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 55673768434007181L;

	public FrontController() {
		super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		WebApplicationContext appContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		String actionName = request.getParameter(REQUEST_PARAM_ACTION);
		BaseAction action = ActionManager.getAction(actionName, appContext);
		String page = action.execute(request);
		if (action != null) {
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			response.getWriter().println("Incorrect Action!");
		}
	}

}
