import model.Cat;
import service.CatService;
import util.TablePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CatService catService = new CatService();
    private static final List<Cat> cats = new ArrayList<>();

    public static void main(String[] args) {
        addStartCats();

        while (true) {
            catService.sortCats(cats);
            TablePrinter.printCats(cats);
            printMenu();

            String command = scanner.nextLine().trim();

            switch (command) {
                case "1" -> feedCat();
                case "2" -> playWithCat();
                case "3" -> healCat();
                case "4" -> addNewCat();
                case "5" -> nextDay();
                case "0" -> {
                    System.out.println("Программа завершена.");
                    return;
                }
                default -> System.out.println("Такой команды нет. Введите номер действия.");
            }
        }
    }

    private static void addStartCats() {
        cats.add(new Cat("Peach", 11, 78, 86, 50));
        cats.add(new Cat("Jasper", 12, 83, 39, 43));
        cats.add(new Cat("Poppy", 9, 38, 57, 71));
    }

    private static void printMenu() {
        System.out.println("1: покормить кота");
        System.out.println("2: поиграть с котом");
        System.out.println("3: лечить кота");
        System.out.println("4: завести нового питомца");
        System.out.println("5: следующий день");
        System.out.println("0: выйти");
        System.out.print("Выберите действие: ");
    }

    private static void addNewCat() {
        String name = readName();
        int age = readAge();

        Cat cat = catService.createRandomCat(name, age);
        cats.add(cat);

        System.out.println("Новый кот добавлен: " + cat.getName() + ", " + cat.getAge() + " лет.");
    }

    private static void feedCat() {
        Cat cat = chooseCat();

        if (cat.isActionDoneToday()) {
            System.out.println("Сегодня с этим котом уже выполняли действие.");
            return;
        }

        catService.feedCat(cat);
        cat.setActionDoneToday(true);
        System.out.println("Вы покормили кота " + cat.getName() + ".");
    }

    private static void playWithCat() {
        Cat cat = chooseCat();

        if (cat.isActionDoneToday()) {
            System.out.println("Сегодня с этим котом уже выполняли действие.");
            return;
        }

        catService.playWithCat(cat);
        cat.setActionDoneToday(true);
        System.out.println("Вы поиграли с котом " + cat.getName() + ".");
    }

    private static void healCat() {
        Cat cat = chooseCat();

        if (cat.isActionDoneToday()) {
            System.out.println("Сегодня с этим котом уже выполняли действие.");
            return;
        }

        catService.healCat(cat);
        cat.setActionDoneToday(true);
        System.out.println("Вы отвели кота " + cat.getName() + " к ветеринару.");
    }

    private static void nextDay() {
        catService.nextDay(cats);

        for (Cat cat : cats) {
            cat.setActionDoneToday(false);
        }

        System.out.println("Наступил следующий день.");
    }

    private static Cat chooseCat() {
        while (true) {
            System.out.print("Введите номер кота: ");
            String input = scanner.nextLine().trim();

            try {
                int index = Integer.parseInt(input);

                if (index >= 1 && index <= cats.size()) {
                    return cats.get(index - 1);
                }

                System.out.println("Кота с таким номером нет.");
            } catch (NumberFormatException e) {
                System.out.println("Введите номер числом.");
            }
        }
    }

    private static String readName() {
        while (true) {
            System.out.print("Введите имя кота: ");
            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Имя не может быть пустым.");
        }
    }

    private static int readAge() {
        while (true) {
            System.out.print("Введите возраст кота от 1 до 18: ");
            String input = scanner.nextLine().trim();

            try {
                int age = Integer.parseInt(input);

                if (age >= 1 && age <= 18) {
                    return age;
                }

                System.out.println("Возраст должен быть от 1 до 18.");
            } catch (NumberFormatException e) {
                System.out.println("Введите возраст числом.");
            }
        }
    }
}