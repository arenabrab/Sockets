package main.java;

public interface IDBActions extends Runnable {
    void connectToDb();
    void insertIntoDb();
    void selectFromDb();
    void deleteFromDb();
    void updateDb();
}
