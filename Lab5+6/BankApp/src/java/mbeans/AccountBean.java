/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Account;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sessions.AccountFacade;

/**
 *
 * @author Asus
 */
@ManagedBean
@RequestScoped
public class AccountBean {
    
    @EJB
    AccountFacade facade;

    public AccountFacade getFacade() {
        return facade;
    }

    public void setFacade(AccountFacade facade) {
        this.facade = facade;
    }

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountBean() {
        account = new Account();
    }
    
    public String actionMethod()
    {
        facade.openAccount(account.getOwnername(), account.getBalance());
        return "response";
    }
    
    public String index()
    {
        return "index";
    }

}
