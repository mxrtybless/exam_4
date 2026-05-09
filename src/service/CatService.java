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
        cat.changeSatiety(15);
        cat.changeMood(5);
    }

    public void playWithCat(Cat cat) {
        cat.changeMood(15);
        cat.changeSatiety(-10);
    }

    public void healCat(Cat cat) {
        cat.changeHealth(20);
        cat.changeMood(-5);
    }
}