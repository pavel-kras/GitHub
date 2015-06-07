package by.bsuir.autoservice.service;


import by.bsuir.autoservice.dao.LoginDAO;

public class LoginService {
    public static String checkLogin(String login, String password) {
        String type = LoginDAO.checkLogin(login, password);
        return type;
    }
}
