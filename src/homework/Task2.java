package homework;

/*
 * Задание 2
 * Создать 2 класса. Реализовать взаимную блокировку(deadlock) этих классов.
 * */

public class Task2 {
    public static void main(String[] args) {
        DeathLock deathLock = new DeathLock();
        Thread vasya = new Thread(deathLock, "Вася");
        Thread sasha = new Thread(deathLock, "Саша");

        vasya.start();
        sasha.start();
    }
}

class DeathLock implements Runnable {
    private final Object scissors = new Object();
    private final Object paper = new Object();

    public void makeSun() {
        synchronized (scissors) {
            System.out.println(Thread.currentThread().getName() + " взял ножницы для вырезания солнышка");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взял бумагу для вырезания солнышка");
                System.out.println(Thread.currentThread().getName() + " вырезает солнышко");
            }
        }
    }

    public void makeCloud() {
        synchronized (paper) {
            System.out.println(Thread.currentThread().getName() + " взял бумагу для вырезания тучки");
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName() + " взял ножницы для вырезания тучки");
                System.out.println(Thread.currentThread().getName() + " вырезает тучку");
            }
        }
    }

    @Override
    public void run() {
        makeSun();
        makeCloud();
    }
}