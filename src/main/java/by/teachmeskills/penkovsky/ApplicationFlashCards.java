package by.teachmeskills.penkovsky;

import by.teachmeskills.penkovsky.services.FlashCardService;
import by.teachmeskills.penkovsky.services.impl.FlashCardServiceImpl;

import java.util.Scanner;

public class ApplicationFlashCards {
    public void menu() {
        choiceMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        FlashCardService flashCardService = new FlashCardServiceImpl();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    flashCardService.getAllCards().forEach(System.out::println);
                    break;
                case 2:
                    flashCardService.getCards().forEach(System.out::println);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            choiceMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
    private static void choiceMenu() {
        System.out.println("Choose (press 0 to finish):");
        System.out.println("1. Вывести набор всех карточек");
        System.out.println("2. Вывести все карточки");
    }
}

