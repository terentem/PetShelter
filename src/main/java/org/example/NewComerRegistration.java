package org.example;

import com.google.gson.reflect.TypeToken;
import org.example.model.Inhabitant;
import org.example.utils.JSONmanipulation;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewComerRegistration {
    public static void main(String[] args) {

    String type;
    String breed;
    String gender;
    String name;
    String chipCode;
    String color;
    String personInCharge;
    String arivalDate;
    String path = "D:\\Education\\java\\PetShelter\\inhabitants.json";

        System.out.println("Запускаю сканер");
//Заводимо дані для реєстрації тваринки з консолі
        Scanner scanner=new Scanner(System.in);
        System.out.println("Тип підопічного (cat, dog, etc): ");
        type=scanner.nextLine();
        System.out.println("Порода підопічного: ");
        breed=scanner.nextLine();
        System.out.println("Гендер підопічного: ");
        gender=scanner.nextLine();
        System.out.println("Ім'я: ");
        name=scanner.nextLine();
        System.out.println("Колір:");
        color=scanner.nextLine();
        System.out.println("ChipCode підопічного: ");
        chipCode=scanner.nextLine();
        System.out.println("ФІО особи - реєстратора: ");
        personInCharge=scanner.nextLine();
        System.out.println("Дата реєстрації: ");
        arivalDate=scanner.nextLine();

        scanner.close();

        //спроба вичитати json, якщо readFromJson() поверне null, створюємо пустий register=new ArrayList<>()
    Type listtype = new TypeToken<List<Inhabitant>>(){}.getType();
    List<Inhabitant> register= JSONmanipulation.readFromJson(path, listtype);
    if(register==null){register=new ArrayList<>();}
    Inhabitant document = new Inhabitant();

    {
        document.setType(type);
        document.setName(name);
        document.setBreed(breed);
        document.setGender(gender);
        document.setChipCode(chipCode);
        document.setEyesColor(color);
        document.setResponsiblePerson(personInCharge);
        document.setRegistrationDate(arivalDate);
    }
    register.add(document);

        JSONmanipulation.writeToJson(path, register);

        System.out.println("Тваринку зареєстровано!");
        System.out.println("Всього в реєстрі: " + register.size()+ " тваринок.");

}

}
