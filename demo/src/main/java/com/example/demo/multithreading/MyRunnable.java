package com.example.demo.multithreading;

public class MyRunnable implements Runnable { // 实现Runnable接口，作为线程的实现类
    private String name;       // 表示线程的名称

    public MyRunnable(String name) {
        this.name = name;      // 通过构造方法配置name属性
    }

    public void run() {  // 覆写run()方法，作为线程 的操作主体
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行，i = " + i);
        }
    }


}
