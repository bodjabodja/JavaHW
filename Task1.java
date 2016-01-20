package JavaPro.Lesson2.JSON1.JsonTask;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Богдан on 18.01.2016.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\TestFiles\\json.txt";
        String result = request(path);
        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result, JSON.class);


        System.out.println("JSON: \n\t" + gson.toJson(json));
    }
    private static String request(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader reader = new FileReader(path);
        int c;
        while((c=reader.read())!=-1){
            sb.append((char)c);
        }
        System.out.println(sb.toString());
        return  sb.toString();
    }

}
