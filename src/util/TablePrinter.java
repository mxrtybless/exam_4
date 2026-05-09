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
            String number = cat.isActionDoneToday() ? (i + 1) + " *" : String.valueOf(i + 1);

            System.out.printf(
                    "| %-2s | %-10s | %-7d | %-9d | %-10d | %-8d | %-15.0f |\n",
                    number,
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