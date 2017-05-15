package com.concurrent.guard;

import com.concurrent.future.FutureData;
import com.concurrent.future.RealData;
import com.concurrent.util.SleepUtil;

/**
 * User shijingui
 * Date 2017/5/13
 */
public class ServerThread extends Thread {
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            final Request request = requestQueue.getRequest();//得到请求
            FutureData futureData = (FutureData) request.getResponse();
            RealData realData= new RealData(request.getName());
            futureData.setRealData(realData);
            SleepUtil.millisecond(100);//simulation request process cost
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }
}
