package by.teachmeskills.penkovsky;

import by.teachmeskills.penkovsky.models.FlashCard;
import by.teachmeskills.penkovsky.models.FlashCardSet;
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
                    break;
                case 3:
                    System.out.println("Введите наименование набора карточек: ");
                    String title = scanner.nextLine();
                    FlashCardSet flashCardSet = new FlashCardSet(title);
                    flashCardService.addFlashCardSet(flashCardSet);
                    flashCardService.getAllCards().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Введите id набора карточек: ");
                    int setId = scanner.nextInt();
                    System.out.println("Введите наименование карточки: ");
                    String titleCard = scanner.next();
                    System.out.println("Введите вопрос карточки: ");
                    String cardQuestion = scanner.next();
                    System.out.println("Введите ответ карточки: ");
                    String cardAnswer = scanner.next();
                    FlashCard flashCard = new FlashCard(null, titleCard, cardQuestion, cardAnswer, false, setId);
                    flashCardService.addFlashCard(flashCard);
                    break;
                case 5:
                    System.out.println("Введите id карточки для удаления: ");
                    int cardId = scanner.nextInt();
                    FlashCard flashCard1 = new FlashCard(cardId);
                    flashCardService.deleteFlashCard(flashCard1);
                    break;
                case 6:
                    System.out.println("Введите id карточки для обновления: ");
                    int cardIdForUpdate = scanner.nextInt();
                    FlashCard flashCard2 = new FlashCard(cardIdForUpdate, null, null, null, true, null);
                    flashCardService.updateFlashCard(flashCard2);
                    break;
                case 7:
                    System.out.println("Введите id набора карточек для удаления: ");
                    int cardIdSet = scanner.nextInt();
                    FlashCardSet flashCardSet1 = new FlashCardSet(cardIdSet);
                    flashCardService.deleteFlashCardSet(flashCardSet1);
                    break;
                case 8:
                    System.out.println("Введите id набора карточек: ");
                    int flashCardIdSetForTraining = scanner.nextInt();
                    System.out.println("Введите смещение: ");
                    int offset = scanner.nextInt();
                    System.out.println(flashCardService.getCardByIdAndOffset(flashCardIdSetForTraining, offset));
                    break;
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
        System.out.println("3. Добавить новый набор карточек: ");
        System.out.println("4. Добавить новую карточку в наборе карточек: ");
        System.out.println("5. Удалить карточку в наборе карточек: ");
        System.out.println("6. Обновить изучение карточки");
        System.out.println("7. Удалить набор карточек");
        System.out.println("8. Тренировка 1");

    }
}

