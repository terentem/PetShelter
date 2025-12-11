package org.example.utils;

import org.example.model.Inhabitant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static List<Inhabitant> bubbleSortedArray(List<Inhabitant> unsortedArray, boolean isAsk, String sortByParameter) {

        if (unsortedArray == null || unsortedArray.isEmpty()) {
            throw new IllegalArgumentException("unsortedArray cannot be empty or null");
        } else if (!isAsk) {
            throw new IllegalArgumentException("isAsc can`t be false. Currently, this methd only for asc order.");
        } else if (!sortByParameter.equals("name")) {
            throw new IllegalArgumentException("Currently, this method only for sorting by name.");
        } else {
            int k=0;
            for(Inhabitant element:unsortedArray){
                k++;
                if(element.getName()==null){
                    throw new IllegalArgumentException("Name of element at index " +k + " is null.");
                }
            }
            for (int i = 0; i < unsortedArray.size() - 1; i++) {
                for (int j = 0; j < unsortedArray.size() - 1 - i; j++) {
                    if (unsortedArray.get(j).getName().compareTo(unsortedArray.get(j + 1).getName()) > 0) {
                        Collections.swap(unsortedArray, j, j + 1);
                    }
                }
            }
            return unsortedArray;
        }
    }
}




