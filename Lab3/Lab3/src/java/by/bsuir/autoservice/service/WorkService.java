package by.bsuir.autoservice.service;

import by.bsuir.autoservice.dao.WorkDAO;
import by.bsuir.autoservice.domain.Work;
import java.util.List;

public class WorkService {

    public static List<Work> getWorkList() {
        List<Work> list = WorkDAO.getWorkList();
        return list;
    }
    
    public static List<Work> getWorkListSelect() {
        List<Work> list = WorkDAO.getWorkListSelect();
        return list;
    }

    public static void updateWork(Work work) {
        WorkDAO.updateWork(work);
    }
    
    public static void updateWorkSelect(int number) {
        WorkDAO.updateWorkSelect(number);
    }
    
    public static void updateWorkSelectDouble(int news, int old) {
        WorkDAO.updateWorkSelectDouble(news, old);
    }

    public static void addWork(Work work) {
        WorkDAO.addWork(work);
    }
    
    public static void deleteWork(Work work) {
        WorkDAO.deleteWork(work);
    }
}
