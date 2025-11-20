package org.example;

import org.example.model.Inhabitant;
import org.example.utils.GetByFilter;
import org.example.utils.JSONmanipulation;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        String path=args[0];
        String filter=args[1];
        String pathForSelection=args[2];

        //Виклик методу selection(String path, String filter) з класу public class GetByFilter
        //GetByFilter gbf = new GetByFilter(path, filter);
        List<Inhabitant> result = GetByFilter.selection(path, filter);

        //Запис результату вибірки на диск

        JSONmanipulation.writeToJson(pathForSelection, result);
    }
}
