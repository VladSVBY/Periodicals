package by.htp.periodicals.web.action;

import org.springframework.web.context.WebApplicationContext;

public final class ActionManager {
	
	private ActionManager() {}
	
	public static BaseAction getAction(String actionName, WebApplicationContext webApplicationContext) {
		return webApplicationContext.getBean(actionName, BaseAction.class);
	}

}
