package model;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;

public class JSONRead { 

    // Ou peut-être une constructeur, à voir
    public static void main(String[] args) {/**
        try {
            String[] a = readJSON(2);
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println(a[2]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }

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
