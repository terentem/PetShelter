package org.example;

import org.example.model.Inhabitant;
import org.example.utils.GetByFilter;
import org.example.utils.JSONmanipulation;

import java.util.List;
import java.util.Scanner;

public class LeaveFurEverHomeForm {
public static void main(String[] args){
    System.out.println("Запускаю сканер");
    String name;
    String newOwner;
    String newAddress;
    String path=args[0]; System.out.println("Path:"+path);
    String filter=args[1]; System.out.println("FIlter:"+ filter);

//Заводимо дані для випискм тваринки з консолі
    Scanner scanner=new Scanner(System.in);

    System.out.println("Ім'я тваринки для виписки: ");
    name=scanner.nextLine();
    System.out.println("ФІО нового власника:");
    newOwner=scanner.nextLine();
    System.out.println("Адреса нової домівки: ");
    newAddress=scanner.nextLine();

    scanner.close();


   //Отримуємо список без тваринки
    List<Inhabitant> newRegister = GetByFilter.deleteFromRegister(path,filter);

    //Перезаписуємо Реєстр
    JSONmanipulation.writeToJson(path,newRegister);


}}
