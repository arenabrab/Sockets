package main.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main{
    /*
     *  I want to connect to DB - check
     *  I want to see a menu - check
     *  I want to make my choices - check
     *  I want to CRUD - check
     *  I want to quit - check
     *  I want all DB actions on a thread - check
     */
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);

        // TODO
        // make a threadFactory - check
        // make executorService->1 executor - check
        // initialize IF->main.java.DBActions - check
        // executorService.execute(main.java.DBActions) - check

        ThreadFactory tf = new CustomThreadFactory();
        System.out.println("ThreadFactory created: " + tf.toString());

        ExecutorService executorService = Executors.newFixedThreadPool(1, tf);
        System.out.println("ExecutorService created: " + executorService.toString());

        IDBActions dbActions1 = new DBActions(1);

        executorService.execute(dbActions1);
        executorService.shutdownNow();

        System.out.println("Goodbye!");
    }


}
