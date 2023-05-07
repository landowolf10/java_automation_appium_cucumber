package framework.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser
{
    public static JSONObject getJsonData(String userType)
    {
        JSONParser jsonParser = new JSONParser();
        JSONObject user;
        int userIndex = switch (userType.toLowerCase()) {
            case "agronomist" -> 0;
            case "sales rep" -> 1;
            case "seller" -> 2;
            case "grower" -> 3;
            case "grower 2" -> 4;
            case "fsm" -> 5;
            case "dm" -> 6;
            case "sales rep kurt" -> 7;
            case "invalid user" -> 8;
            default -> -9;
        };

        Object obj;
        try {
            obj = jsonParser.parse(new FileReader("src/test/java/users.json"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONArray users = (JSONArray) jsonObject.get("user");
        user = (JSONObject) users.get(userIndex);

        return user;
    }

    public static String getNestedData(String userType, String growerName)
    {
        String user = "";
        int growerIndex = -1;

        switch (userType) {
            case "Sales Rep" -> user = "sellers";
            case "Seller", "Agronomist" -> user = "growers";
        }

        JSONArray jsonArray = (JSONArray) JsonParser.getJsonData(userType).get(user);
        JSONObject sellerList = (JSONObject) jsonArray.get(0);

        if(userType.equals("Seller"))
        {
            for (int i = 0; i <= jsonArray.size(); i++)
            {
                JSONObject growerNameList = (JSONObject) jsonArray.get(i);

                if(growerNameList.get("name").toString().contains(growerName))
                {
                    growerIndex = i;
                    break;
                }
            }

            sellerList = (JSONObject) jsonArray.get(growerIndex);
        }

        return sellerList.get("name").toString();
    }
}