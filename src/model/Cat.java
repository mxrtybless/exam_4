package model;

public class Cat {

    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;

    public Cat(String name, int age, int health, int mood, int satiety) {
        this.name = name;
        this.age = age;
        this.health = validate(health);
        this.mood = validate(mood);
        this.satiety = validate(satiety);

        if (age < 1 || age > 18) {
            throw new IllegalArgumentException("Возраст должен быть от 1 до 18 лет");
        }

        this.age = age;
    }

    private int validate(int value) {
        return Math.max(0, Math.min(100, value));
    }

    public double getAverageLifeLevel() {
        return (health + mood + satiety) / 3.0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHealth() {
        return health;
    }

    public int getMood() {
        return mood;
    }

    public int getSatiety() {
        return satiety;
    }

    public void changeHealth(int value) {
        health = validate(health + value);
    }

    public void changeMood(int value) {
        mood = validate(mood + value);
    }

    public void changeSatiety(int value) {
        satiety = validate(satiety + value);
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s %-5d %-10d %-10d %-10d %-10.2f",
                name,
                age,
                health,
                mood,
                satiety,
                getAverageLifeLevel()
        );
    }
}