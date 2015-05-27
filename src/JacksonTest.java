import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravi on 5/27/15.
 */
public class JacksonTest
{
    public static void main(String [] args)
    {
        String userJson = "{\"userId\": 100, \"userName\": \"Ravi\"}";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            //Parse the json string and create UserInfo Object
            UserInfo user = mapper.readValue(userJson, UserInfo.class);

            //Check if the user object gets the required values
            System.out.println(user.getUserId());
            System.out.println(user.getUserName());


            //Create json from Map
            Map<String, Object> userData = new HashMap<String, Object>();
            userData.put("userId", 101);
            userData.put("userName", "Chandra");
            //write it to a file user.json in the current directory
            mapper.writeValue(new File("user.json"), userData);

            //try to load json from a file into Java object
            UserInfo user1 = mapper.readValue(new File("user.json"), UserInfo.class);

            //Test if the object got the values
            System.out.println(user1.getUserId());
            System.out.println(user1.getUserName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
