package org.example;
import com.google.gson.reflect.TypeToken;
import org.example.model.Inhabitant;
import org.example.utils.JSONmanipulation;
import org.example.utils.Sort;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SortingInhabitans {

    public static void main(String[] args) {

        //Отримуємо список тваринок з реєстра по PATH
        //String path = "D:\\Education\\java\\PetShelter\\inhabitants.json";
        String path = "/Education/java/PetShelter/inhabitants.json";
        List<Inhabitant> unsortedArray = new ArrayList<>();
        Type listType = new TypeToken<List<Inhabitant>>() {
        }.getType();
        List<Inhabitant> register = JSONmanipulation.readFromJson(path, listType);

        //Виводимо спиок тваринок (ім'я+тип)
        System.out.println("*************************************************************");
        System.out.println("Несортований (оригінальний) список імен з реєстру тваринок: ");
        for(Inhabitant animal:register){
            unsortedArray.add(animal);
            System.out.println(animal.getType()+":"+animal.getName());
        }

        //Сортуємо нативним методом
       /* unsortedArray.sort(Comparator
                        .comparing((Inhabitant inh) -> inh.getType())//сортуємо по типу
                        .thenComparing(Comparator.comparing((Inhabitant inh)-> inh.getName())));
        List<Inhabitant> sortedArray = new ArrayList<>(unsortedArray);
        System.out.println("******************************************");
        System.out.println("Виводимо нативно-сортований список тваринок");
        for(Inhabitant animal:unsortedArray){
            System.out.println(animal.getType()+":"+animal.getName());
        }
       */
        //Параметри кастомного компаратора
        System.out.println("Сортування за кастомним компоратором ");
        Scanner scanner=new Scanner(System.in);
        System.out.println("За яким параметром осортувати?");
        String sortByParameter= scanner.nextLine();
        System.out.println("Вкажіть порядок сортування: asc або desc: ");
        String sortOrder=scanner.nextLine();
        System.out.println("Наразі реалізовано сортування за алгоритмом bubble по name в asc порядку.");
        scanner.close();
        String type="bubble";
        boolean isAsc=true;

        //Виклик метода сортування по кастомному компаратору за bubble алгоритмом
        List<Inhabitant> sortedArray=Sort.bubbleSortedArray(unsortedArray,isAsc,sortByParameter);
        for(int i=0;i<sortedArray.size();i++){
        System.out.println(sortedArray.get(i).getName()+" : "+sortedArray.get(i).getType());}

    }

}

