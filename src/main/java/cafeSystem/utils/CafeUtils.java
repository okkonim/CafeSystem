package cafeSystem.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CafeUtils {
    private CafeUtils() {}

    public static ResponseEntity<String> getResponseEntity(String response, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"message\":\"" + response + "\"}", httpStatus);
    }

    public static String getUUID() {
        return "BILL-" + System.currentTimeMillis();
    }

    public static JSONArray getJsonArrayFromString(String data) throws JSONException {
        return new JSONArray(data);
    }

    public static Map<String, Object> getMapFromJson(String data) {
        if (!Strings.isNullOrEmpty(data))
            return new Gson().fromJson(data, new TypeToken<Map<String, Object>>() {}.getType());
        return new HashMap<>();
    }

    public static Boolean isFileExists(String path) {
        try {
            File file = new File(path);
            return (file != null && file.exists());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
} 