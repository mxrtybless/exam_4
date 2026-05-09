package util;

import model.Cat;

import java.util.List;

public class TablePrinter {

    public static void printCats(List<Cat> cats) {

        System.out.println("----------------------------------------------------------------------------");
        System.out.printf(
                "| %-2s | %-10s | %-7s | %-9s | %-10s | %-8s | %-15s |\n",
                "#",
                "имя",
                "возраст",
                "здоровье",
                "настроение",
                "сытость",
                "средний уровень"
        );
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 0; i < cats.size(); i++) {

            Cat cat = cats.get(i);

            System.out.printf(
                    "| %-2d | %-10s | %-7d | %-9d | %-10d | %-8d | %-15.2f |\n",
                    i + 1,
                    cat.getName(),
                    cat.getAge(),
                    cat.getHealth(),
                    cat.getMood(),
                    cat.getSatiety(),
                    cat.getAverageLifeLevel()
            );
        }

        System.out.println("----------------------------------------------------------------------------");
    }
}