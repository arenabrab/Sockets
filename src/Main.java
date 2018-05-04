public class Main implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a thread");
        IDBActions idbActions = new DBActions();
    }

    public static void main(String[] args){

        // TODO - Start thread that handles DBActions
        // In DBActions, have all the choices and stuff implemented

        new Thread(new Main()).start();
//        IDBActions idbActions = new DBActions();
        System.out.println("Goodbye!");
    }


}
