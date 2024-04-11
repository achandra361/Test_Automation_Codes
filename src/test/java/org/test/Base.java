package org.test;

public class Base {

    public static void main(String[] args) {
        Base b = new Base();
        b.testclass();
        b.checkprime(0);
    }

    public void testclass() {
        System.out.println("Hello Programming");
    }

    public void checkprime(int num) {

        if (num <= 1) {
            System.out.println("The number is Not Prime " + num);

        } else {
            int counter = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    counter++;
                }


            }
            if (counter == 0) {
                System.out.println("Num is Prime");
            } else System.out.println("Num is Not Prime");
        }

    }


}