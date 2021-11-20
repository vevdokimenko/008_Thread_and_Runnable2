package homework;

/*
 * Задание
 * Создайте поток-демон и выведите про него как можно больше информации.
 * */

public class Extra {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            String info =
                    "Thread name: " + Thread.currentThread().getName() + "\n" +
                    "Is daemon: " + Thread.currentThread().isDaemon() + "\n" +
                    "Thread ID: " + Thread.currentThread().getId() + "\n" +
                    "Is interrupted: " + Thread.currentThread().isInterrupted() + "\n" +
                    "Is alive: " + Thread.currentThread().isAlive() + "\n" +
                    "Priority: " + Thread.currentThread().getPriority() + "\n" +
                    "Group: " + Thread.currentThread().getThreadGroup().toString() + "\n";
            System.out.print(info);
        });

        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
