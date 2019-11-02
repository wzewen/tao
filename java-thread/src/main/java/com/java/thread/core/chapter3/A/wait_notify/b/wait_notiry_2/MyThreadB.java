package com.java.thread.core.chapter3.A.wait_notify.b.wait_notiry_2;

public class MyThreadB extends Thread {
    private Object lock = new Object();
    public MyThreadB(Object lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try {
            synchronized (lock){
                for (int i=0; i<10; i++){
                    MyList.add();
                    System.out.println("add "+(i+1)+" element");
                    if(MyList.size()==5){
                        lock.notify();
                        System.out.println("already notify ...");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
