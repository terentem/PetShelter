package org.example.utils;
import com.google.gson.reflect.TypeToken;
import org.example.model.Inhabitant;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GetByFilter {

   private GetByFilter(){}

   public static  List<Inhabitant> selection(String path, String filter) {
        System.out.println("Виконується selection(path,filter)");
        Type listType = new TypeToken<List<Inhabitant>>() {
        }.getType();
        List<Inhabitant> register = JSONmanipulation.readFromJson(path, listType);
       //System.out.println("Register size= " + register.size());
        if (register != null && register.size() > 0) {
           List<Inhabitant> selection = new ArrayList<>();
            for (Inhabitant r : register) {
                if (r.getType().equals(filter)) {
                    selection.add(r);
                }
                else if (filter.equals("all")) {
                    selection.add(r);
                }
            }
            System.out.println("Розмір вибірки за фільтром "+filter+"= "+selection.size() );
            return selection;
        }
        else {
            System.out.println("No register by filter ");
            return List.of();}


    }


    public static  List<Inhabitant> deleteFromRegister (String path, String name) {
        System.out.println("Виконується deleteFromRegister(path,filter). "+" name= "+ name+". Path= "+path);
        Type listType = new TypeToken<List<Inhabitant>>() {
        }.getType();
        List<Inhabitant> register = JSONmanipulation.readFromJson(path, listType);
        //System.out.println("Register size= " + register.size());
        if (register != null && register.size() > 0) {
            List<Inhabitant> newRegister = new ArrayList<>();
            for (Inhabitant r : register) {
                if (!r.getName().equals(name)) {
                    newRegister.add(r);
                }

            }

            return newRegister;
        }
        else {
            System.out.println("No register by filter ");
            return List.of();}


    }


}
