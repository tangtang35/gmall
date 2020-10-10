package com.example.demo.multithreading;

public class MyThread extends Thread {
    @Override
    public void run(){
        super.run();
        System.out.println("执行子线程...");
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println("主线程...");
    }
}
