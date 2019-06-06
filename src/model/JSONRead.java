package model;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;

/**
 * JSONRead
 * @author BIZOUARN Aymeric
 * @author BOISNARD Noéwen
 * @author DELOURMEL Arnaud
 */
public class JSONRead {

    /**
     * Read json file
     * @param  index     get the slide index
     * @return           String[] of json elements
     * @throws Exception IOError
     */
    public static String[] readJSON(int index) throws Exception {
        File file = new File("data/file.json");
        String content = FileUtils.readFileToString(file, "utf-8");
        JSONObject json = new JSONObject(content);

        String title = json.getJSONObject(Integer.toString(index)).getString("title");
        String dec = json.getJSONObject(Integer.toString(index)).getString("desc");
        String loc = json.getJSONObject(Integer.toString(index)).getString("location");

        String[] a = {title, dec, loc};
        return a;
    }

}
