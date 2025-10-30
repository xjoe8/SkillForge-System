package lab6;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class JsonDatabaseManager {
    private String filePath;
    public JsonDatabaseManager(String filePath){
        this.filePath = filePath;
    }
    public void loadData(){
        JSONParser parser = new JSONParser();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))){
            JSONArray users = (JSONArray) parser.parse(reader);
            for (Object obj : users){
                JSONObject user = (JSONObject) obj;
                String userID = (String) user.get("userID");
                String username = (String) user.get("username");
                String name = (String) user.get("name");
                String email = (String) user.get("email");
                String password = (String) user.get("password");
                JSONArray coursesArray = (JSONArray) user.get("courses");
                String[] courses = new String[coursesArray.size()];
                for (int i = 0; i < coursesArray.size(); i++) {
                    courses[i] = (String) coursesArray.get(i);
                }

                System.out.println(userID);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error, File Not Found");
        }catch (IOException e){
            System.out.println("Error, File cannot be opened");
        }catch (ParseException e){
            System.out.println("Error in Parsing");
        }
    }
}
