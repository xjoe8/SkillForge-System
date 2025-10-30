package lab6;
public class Main {
    static public void main(String[] args){
        JsonDatabaseManager file = new JsonDatabaseManager("users.json");
        file.loadData();
    }
}
