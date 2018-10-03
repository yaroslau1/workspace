package com.teaachmeskills.autosalon.app;

import com.teaachmeskills.autosalon.controllers.Controller;
import com.teaachmeskills.autosalon.entity.Auto;

import java.util.Scanner;

/**
 * Created by TMS on 24.04.2018.
 */
public class Application {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void start(){
        System.out.println("Добро пожаловать!!!");
        run();
        System.out.println("Пока!!!");
    }

    private void run(){
        do{
            showMenu();
        }while (choice());
    }

    private boolean choice(){
        switch (action()){
            case 1:
                getAutos();
                break;
            case 2:
                addAuto();
                break;
            case 3:
                search();
                break;
            case 0:
                return false;
        }
        return true;
    }

    private void getAutos(){
        Auto[] autos = controller.getAutos();
        System.out.println("***Список всех автомобилей***");
        showAutos(autos);
    }

    private void addAuto(){
        System.out.println("Введите марку");
        String marka = scanner.next();
        System.out.println("Введите скорость");
        int speed = scanner.nextInt();
        System.out.println("Введите цену");
        int price = scanner.nextInt();
        Auto auto = new Auto(marka, speed, price);
        controller.addAuto(auto);
        System.out.println("Сохранено!!!");

    }

    private void showAutos(Auto[] autos){
        for (int i = 0; i < autos.length; i++){
            System.out.println(autos[i]);
        }
    }

    private void search(){
        System.out.println("Введите марку для поиска");
        String marka = scanner.next();
        Auto[] autos = controller.getAutos(marka);
        System.out.println("Все автомобили с маркой "+marka);
        showAutos(autos);
    }

    private int action(){
        return scanner.nextInt();
    }

    private void showMenu(){
        System.out.println("Введите 1 для просмотра всех автомобилей");
        System.out.println("Введите 2 для добавления автомобиля");
        System.out.println("Введите 3 для поиска по марке");
        System.out.println("Введите 0 для выхода");

    }
}
