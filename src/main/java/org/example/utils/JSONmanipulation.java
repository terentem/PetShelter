package org.example.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONmanipulation {
 private static final Gson gson =new GsonBuilder().setPrettyPrinting().create();

    public static <T> T  readFromJson(String path, Type typeOfT){
        File file = new File(path);
        if(!file.exists()){
            try {return gson.fromJson("{}", typeOfT);}
            catch(Exception e) {return null;}
        }
        try(FileReader reader = new FileReader(file)){
            return gson.fromJson(reader, typeOfT);
        }
        catch(IOException e){e.printStackTrace(); return null;}
    }



public static <T> void writeToJson(String path, T data)
{
    try(FileWriter writer =new FileWriter(path))
    {gson.toJson(data, writer);
    System.out.println("Файл записано в "+path);}
    catch(IOException e){e.printStackTrace();}
}}
