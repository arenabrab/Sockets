import javax.sound.midi.SysexMessage;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class DBActions implements IDBActions, Runnable {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static Scanner scanner = new Scanner(System.in);
    public int num;

    @Override
    public void run() {
        connectToDb();
        userMenu();
    }

    public void connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sockets?" +
                    "user=root&password=skate1");
            System.out.println("Is connection closed? : " + conn.isClosed());
        } catch (Exception e) {
            System.out.println("This is 1: " + e);
        }
    }

//    DBActions(int num){
//        this.num = num;
//        System.out.println("Thank you for creating DBActions Object :-) " + num);
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/sockets?" +
//                    "user=root&password=skate1");
//        } catch (Exception e) {
//            System.out.println("This is 1: " + e);
//        }
////        run();
////        userMenu();
DBActions(int num){
    super();
    this.num = num;
    }

    private void userMenu() {
        String choice;
        do{
            System.out.println("Please choose an option:\nInsert\tDelete\nUpdate\tSelect");
            choice = scanner.next();
            System.out.println(choice);
            switch(choice){
                case "Insert":
                    insertIntoDb();
                    break;
                case "Delete":
                    deleteFromDb();
                    break;
                case "Update":
                    updateDb();
                    break;
                case "Select":
                    selectFromDb();
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Please try another string");
                    break;
            }
        }
        while(!choice.equals("q"));
    }

    @Override
    public void deleteFromDb(){
        System.out.println("Please select row to delete:");
        String trax = scanner.next();
        String query = "DELETE FROM wallet WHERE TRANS_NUM=" + trax;
        try{
            stmt = conn.createStatement();
            int numRows = stmt.executeUpdate(query);
            System.out.println("delete: numRows: " + numRows);
        } catch (Exception e){
            System.out.println("This is delete: " + e);
        }
    }

    @Override
    public void insertIntoDb(){
        System.out.println("Please select row to insert:");
        String trax = scanner.next();
        if(trax.equals("q"))
            return;
        String query = "INSERT INTO wallet (TRANS_NUM) VALUE (" + trax + ")";
        System.out.println(query);
        try {
            stmt = conn.createStatement();
            int numRows = stmt.executeUpdate(query);
            System.out.println("numRows = " + numRows);
        } catch (Exception e)
        {
            System.out.println("This is insert: " + e);
        }
    }

    @Override
    public void selectFromDb(){
        System.out.println("TRANS_NUM\t|\tTRANS_AMT");
        System.out.println("------------|---------------");
        String query = "SELECT * FROM wallet ORDER BY TRANS_NUM";
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt("TRANS_NUM") + "\t\t\t|\t" + rs.getBigDecimal("TRANS_AMT"));
            }
        } catch(Exception e){
            System.out.println("This is select: " + e);
        }
    }

    @Override
    public void updateDb(){
        System.out.println("What transaction number would you like to update?");
        int transNum = scanner.nextInt();
        System.out.println("What is the new transaction amount?");
        BigDecimal value = scanner.nextBigDecimal();
//        scanner.reset();
        String query = "UPDATE wallet SET TRANS_AMT=" + value + " WHERE TRANS_NUM=" + transNum;

        System.out.println(query);

        try{
            stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(query) + " row(s) updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
