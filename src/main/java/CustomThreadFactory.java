package main.java;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("Creating thread...");
        Thread thread = new Thread(r);
        return thread;
    }
}
