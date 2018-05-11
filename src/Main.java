import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main{

//    @Override
//    public void run() {
//        System.out.println("Hello from a thread");
//        IDBActions idbActions = new DBActions();
//    }


    /*
     *  I want to connect to DB
     *  I want to see a menu
     *  I want to make my choices
     *  I want to CRUD
     *  I want to quit
     *  I want all DB actions on a thread
     */
    public static void main(String[] args){

        // TODO
        // make a threadFactory
        // make executorService->1 executor
        // initialize IF->DBActions
        // executorService.execute(DBActions)

        ThreadFactory tf = new CustomThreadFactory();
        System.out.println("ThreadFactory created: " + tf.toString());

        ExecutorService executorService = Executors.newFixedThreadPool(2, tf);
        System.out.println("ExecutorService created: " + executorService.toString());

        IDBActions dbActions1 = new DBActions(1);

        executorService.execute(dbActions1);
        executorService.shutdownNow();

        System.out.println("Goodbye!");
    }


}
