package homework;

/*
 * Задание 3
 * Изменить задание No2.
 * Всеми возможными способами (которые Вы знаете) решить проблему взаимной блокировки.
 * */

public class Task3 {
    public static void main(String[] args) {
        Job job = new Job();
        Thread vasya = new Thread(job, "Вася");
        Thread sasha = new Thread(job, "Саша");

        vasya.start();
        sasha.start();
    }
}

class Job implements Runnable {
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
        synchronized (scissors) {
            System.out.println(Thread.currentThread().getName() + " взял ножницы для вырезания тучки");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взял бумагу для вырезания тучки");
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