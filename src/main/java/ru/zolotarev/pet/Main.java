package ru.zolotarev.pet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String str = sc.nextLine();
            switch (str.toLowerCase()){
                case "add":
                    System.out.println("Введите текст");
                    System.out.println(sc.nextLine());
                    break;
                case "exit":
                    return;
            }
        }
    }
}
