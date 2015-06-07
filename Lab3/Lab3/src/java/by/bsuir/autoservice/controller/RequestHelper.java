package by.bsuir.autoservice.controller;

import by.bsuir.autoservice.command.AddWorkerCommand;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import by.bsuir.autoservice.command.Command;
import by.bsuir.autoservice.command.LoginCommand;
import by.bsuir.autoservice.command.LogoutCommand;
import by.bsuir.autoservice.command.GoToWorkerCommand;
import by.bsuir.autoservice.command.GoToWorkCommand;
import by.bsuir.autoservice.command.GoToOrderCommand;
import by.bsuir.autoservice.command.GoToUpdateWorkerCommand;
import by.bsuir.autoservice.command.UpdateWorkerCommand;
import by.bsuir.autoservice.command.GoToUpdateWorkCommand;
import by.bsuir.autoservice.command.UpdateWorkCommand;
import by.bsuir.autoservice.command.GoToAddWorkerCommand;
import by.bsuir.autoservice.command.GoToAddOrderCommand;
import by.bsuir.autoservice.command.GoToDeleteWorkerCommand;
import by.bsuir.autoservice.command.GoToDeleteWorkCommand;
import by.bsuir.autoservice.command.GoToDeleteOrderCommand;
import by.bsuir.autoservice.command.GoToAddWorkCommand;
import by.bsuir.autoservice.command.AddWorkCommand;
import by.bsuir.autoservice.command.AddOrderCommand;
import by.bsuir.autoservice.command.GoToUpdateOrderCommand;
import by.bsuir.autoservice.command.UpdateOrderCommand;
import by.bsuir.autoservice.command.GoToMainCommand;
import by.bsuir.autoservice.command.GoToMoneyCommand;
import by.bsuir.autoservice.command.GoToNextStepCommand;
import by.bsuir.autoservice.command.GoToNextStepAddOrderCommand;


public class RequestHelper {

    private static RequestHelper instance = null;
    HashMap <String, Command> commands = new HashMap<>();

    private RequestHelper() {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("gotoworker", new GoToWorkerCommand());
        commands.put("gotowork", new GoToWorkCommand());
        commands.put("gotoorder", new GoToOrderCommand());
        commands.put("gotoupdateworker", new GoToUpdateWorkerCommand());
        commands.put("updateworker", new UpdateWorkerCommand());
        commands.put("gotoupdatework", new GoToUpdateWorkCommand());
        commands.put("updatework", new UpdateWorkCommand());
        commands.put("gotoaddworker", new GoToAddWorkerCommand());
        commands.put("addworker", new AddWorkerCommand());
        commands.put("gotoaddwork", new GoToAddWorkCommand());
        commands.put("addwork", new AddWorkCommand());
        commands.put("gotoupdateorder", new GoToUpdateOrderCommand());
        commands.put("updateorder", new UpdateOrderCommand());
        commands.put("gotomain", new GoToMainCommand());
        commands.put("gotodeleteworker", new GoToDeleteWorkerCommand());
        commands.put("gotodeletework", new GoToDeleteWorkCommand());
        commands.put("gotodeleteorder", new GoToDeleteOrderCommand());
        commands.put("gotomoney", new GoToMoneyCommand());
        commands.put("gotonextstep", new GoToNextStepCommand());
        commands.put("updateorder", new UpdateOrderCommand());
        commands.put("gotoaddorder", new GoToAddOrderCommand());
        commands.put("gotonextstepaddorder", new GoToNextStepAddOrderCommand());
        commands.put("addorder", new AddOrderCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
        if (command == null) {
        }
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
        }
        return instance;
    }
}
