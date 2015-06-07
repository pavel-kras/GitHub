package by.bsuir.autoservice.service;

import by.bsuir.autoservice.dao.WorkerDAO;
import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.domain.Worker;
import java.util.List;

public class WorkerService {
    public static List<Worker> getWorkerList() {
    	List <Worker> list = WorkerDAO.getWorkerList();
    	return list;
    }
    
    public static Worker getWorkerListUpdate(int update) {
    	Worker list = WorkerDAO.getWorkerListUpdate(update);
    	return list;
    }

    public static void updateWorker(Worker worker) {
        WorkerDAO.updateWorker(worker);
    }
    
    public static void addWorker(Worker worker) {
        WorkerDAO.addWorker(worker);
    }
    
    public static void deleteWorker(Worker worker) {
        WorkerDAO.deleteWorker(worker);
    }
    
    public static List<Order> getStatWorkerList(Order order) {
    	List <Order> list = WorkerDAO.getStatWorkerList(order);
    	return list;
    }
    public static int getSumWorker(List<Order> list){
        int sum = WorkerDAO.getSumWorker(list);
        return sum;
    }
    
    public static int getTimeWorker(List<Order> list){
        int sum = WorkerDAO.getTimeWorker(list);
        return sum;
    }
}
