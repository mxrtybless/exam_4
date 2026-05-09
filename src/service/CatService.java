package service;

import model.Cat;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CatService {

    private final Random random = new Random();

    public void sortCats(List<Cat> cats) {
        cats.sort(Comparator.comparingDouble(Cat::getAverageLifeLevel).reversed());
    }

    public Cat createRandomCat(String name, int age) {
        int health = random.nextInt(61) + 20;
        int mood = random.nextInt(61) + 20;
        int satiety = random.nextInt(61) + 20;

        return new Cat(name, age, health, mood, satiety);
    }

    public void feedCat(Cat cat) {
        cat.changeSatiety(getIncreaseStep(cat));
        cat.changeMood(getIncreaseStep(cat));
    }

    public void playWithCat(Cat cat) {
        cat.changeMood(getIncreaseStep(cat));
        cat.changeHealth(getIncreaseStep(cat));
        cat.changeSatiety(-getDecreaseStep(cat));
    }

    public void healCat(Cat cat) {
        cat.changeHealth(getIncreaseStep(cat));
        cat.changeMood(-getDecreaseStep(cat));
        cat.changeSatiety(-getDecreaseStep(cat));
    }

    private int getIncreaseStep(Cat cat) {
        int age = cat.getAge();

        if (age >= 1 && age <= 5) {
            return 7;
        }

        if (age >= 6 && age <= 10) {
            return 5;
        }

        return 4;
    }

    private int getDecreaseStep(Cat cat) {
        int age = cat.getAge();

        if (age >= 1 && age <= 5) {
            return 3;
        }

        if (age >= 6 && age <= 10) {
            return 5;
        }

        return 6;
    }
}