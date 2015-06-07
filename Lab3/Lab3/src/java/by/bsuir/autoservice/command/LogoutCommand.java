package by.bsuir.autoservice.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.autoservice.manager.PropertiesManager;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String page = PropertiesManager.getProperty("paths","page.login");	
        request.getSession().invalidate();
        return page;
	}

}
