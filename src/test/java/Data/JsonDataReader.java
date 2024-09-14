package Data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonDataReader {
   public String UserName , Password;
    public void JsonReader() throws FileNotFoundException {
        String FilePath =System.getProperty("user.dir")+"/src/test/java/Data/UserData.Json";
        File srcFile = new File(FilePath);
        JsonParser parser = new JsonParser();
        JsonArray Jarray = (JsonArray)parser.parse(new FileReader(srcFile));
        for (JsonElement element :Jarray)
        {
            JsonObject person = element.getAsJsonObject();
            UserName = person.get("UserName").getAsString();
            System.out.println(UserName);
            Password = person.get("Password").getAsString();
            System.out.println(Password);
        }
    }
}
