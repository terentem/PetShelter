package org.example;

import com.google.gson.Gson;
import org.example.model.Inhabitant;
import org.example.utils.GetByFilter;
import org.example.utils.JSONmanipulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;



public class Main {
    public static void main(String[] args) {

        //Оркестратор:
        if(args.length>0){
           String path = "D:\\Education\\java\\PetShelter\\inhabitants.json";

        if(args[0].equals("registration"))
        {System.out.println("Запускаю програму  реєстрації");
            NewComerRegistration.main(new String[]{});}

        else if (args[0].startsWith("filter:"))
        {System.out.println("Запускаю програму  Select");
            //Парсимо rgs
            String[] k_v=args[0].split(":");
            String filter=k_v[1];
            String pathForSelection="D:\\Education\\java\\PetShelter\\getResults.json";
            Select.main(new String[]{path, filter, pathForSelection});

        }
        else if (args[0].startsWith("leave:"))
        {System.out.println("Запускаю програму  виписки з притулку");
            //Парсимо rgs
            String[] k_v=args[0].split(":");
            String filter=k_v[1];
            LeaveFurEverHomeForm.main(new String[]{path,filter});
            }


    } else {System.out.println("No valid arguments.");}

    }

}


