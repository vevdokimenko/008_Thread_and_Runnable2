package practice;

/*
* Создать массив на 1000 рандомных чисел. После чего запускаются две потока.
* Первый поток находит максимум в массиве. Второй поток находит минимум в массиве.
* Результаты вычислений возвращаются в метод main.
* */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
            System.out.println(array[i]);
        }

        MaxThread maxThread = new MaxThread(array);
        Thread t1 = new Thread(maxThread);
        MinThread minThread = new MinThread(array);
        Thread t2 = new Thread(minThread);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Max: " + maxThread.getMax());
        System.out.println("Min: " + minThread.getMin());
    }
}

class MaxThread implements Runnable {
    private int[] array;
    private int max;

    public MaxThread(int[] array) {
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        this.max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > this.max)
                this.max = array[i];
        }
    }
}

class MinThread implements Runnable {
    private int[] array;
    private int min;

    public MinThread(int[] array) {
        this.array = array;
    }

    public int getMin() {
        return min;
    }

    @Override
    public void run() {
        this.min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < this.min)
                this.min = array[i];
        }
    }
}
