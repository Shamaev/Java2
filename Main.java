public class Main {
    public static void main(String[] args) {
        thread1();
        thread2();



    }

    static final int size = 10000000;
    static final int h = size / 2;

    private static void  thread1() {
        float[] arr = new float[size];


        for (int i = 0; i <arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis(); // Время заполнения единицами

        for (int i = 0; i <arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время выполнения расчета первого метода: " + (System.currentTimeMillis() - a));

    }

    private static void thread2() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i <arr.length; i++) {
            arr[i] = 1;
        }

        System.out.println();
        long a = System.currentTimeMillis(); // Время разбивки массивов

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        long b = System.currentTimeMillis(); // Время разбивки массивов
        System.out.println("Время разбивки массива: " + (b-a));


        Thread m1 = new Thread(() -> {

            long c = System.currentTimeMillis(); // Засекли время расчета половины массива

            for (int i = 0; i <a1.length; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            long d = System.currentTimeMillis(); // Засекли конец время расчета половины массива
            System.out.println("Время расчета первой половины массива: " + (d-c));
        });


        Thread m2 = new Thread(() -> {

            long c = System.currentTimeMillis(); // Засекли время расчета половины массива

            for (int i = 0; i <a2.length; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            long d = System.currentTimeMillis(); // Время расчета второй половины массива
            System.out.println("Время расчета второй половины массива: " + (d-c));
        });

        m1.start();
        try {
            m1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2.start();
        try {
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long c = System.currentTimeMillis(); // Время склейки массива

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long d = System.currentTimeMillis(); // Время склейки массива
        System.out.println("Время склейки массива: " + (d - c));


        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis()-a));
    }


}
