package org.banyan.concurrent.reentrant;

/**
 * synchronized 可重入锁
 * User : krisjin
 * Date: 2015/9/8
 */
public class ReentrantLockSynchronizedDemo implements Runnable {

    public static void main(String[] args) {
        ReentrantLockSynchronizedDemo demo01 = new ReentrantLockSynchronizedDemo();
        new Thread(demo01).start();
        new Thread(demo01).start();
        new Thread(demo01).start();
    }

    public synchronized void get() {
        System.out.println(Thread.currentThread().getId());
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getId());
    }

    @Override
    public void run() {
        get();
    }
}
