package practice;

/*
* Создать массив на 1000 рандомных чисел. После чего запускаются две потока.
* Первый поток находит максимум в массиве. Второй поток находит минимум в массиве.
* Результаты вычислений возвращаются в метод main.
* */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
            System.out.println(array[i]);
        }

        MaxThread maxThread = new MaxThread(array);
        maxThread.start();

        MinThread minThread = new MinThread(array);
        minThread.start();

        maxThread.join();
        minThread.join();
    }
}

class MaxThread extends Thread {
    int[] arr;

    public MaxThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("Max: " + max);
    }
}

class MinThread extends MaxThread {
    public MinThread(int[] arr) {
        super(arr);
    }

    @Override
    public void run() {
        int min = Arrays.stream(super.arr).min().getAsInt();
        System.out.println("Min: " + min);
    }
}
