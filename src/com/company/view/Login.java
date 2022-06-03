package com.company.view;

import com.company.controllers.ControlUser;
import com.company.exceptions.InvalidUserTypeException;
import com.company.models.User;
import com.company.models.UserSimpleFactory;

import java.util.Scanner;
import static com.company.helpers.Helpers.*;

public class Login {

    ControlUser controlUser;

    public Login() {
        controlUser = new ControlUser();
    }

    private void showMenu() {

    }

    private String menu() {
        String string = "";
        string += "Apasati 1 pentru a crea un nou utilizator\n";
        string += "Apasati orice altceva pentru a iesit\n";
        return string;
    }

    public void play() {
        boolean running = true;
        int choice = -1;

        while (running) {
            showMenu();
            choice = choiceSelect();
            switch (choice) {
                default:
                    running = !exit();
                    break;
                case 1:
                    addUser();
                    break;
            }
        }
    }

    private int choiceSelect() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private boolean exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iesiti din aplicatie?");
        String ans = scanner.nextLine().toLowerCase();
        return boolStringCheck(ans);
    }

    private boolean addUser() {
        Scanner scanner = new Scanner(System.in);
        UserSimpleFactory factory = new UserSimpleFactory();
        System.out.println("Introduceti tipul si numele noului utilizator separate prin virgula");
        String[] input = scanner.nextLine().split(",");
        if (input.length == 2) {
            String type = input[0];
            String name = input[1];
            int id = controlUser.generateID();
            try {
                controlUser.add(factory.createUser(type, id, name));
                return true;
            } catch (InvalidUserTypeException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Date invalide");
            return false;
        }
    }
}
