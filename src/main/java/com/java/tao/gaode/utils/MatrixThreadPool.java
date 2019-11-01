package com.java.tao.gaode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class MatrixThreadPool {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixThreadPool.class);

    /**
     * 一个大小为70的线程池(用来处理小数据量的)
     */
    public static ExecutorService service = Executors.newFixedThreadPool(70);
    /**
     * 3个10*10的线程池(用来处理大数据量的)
     */
    private static ArrayBlockingQueue<ExecutorService> queue = new ArrayBlockingQueue<>(3);

    /**
     * 初始3个大小为10的线程池对象
     */
    static {
        LOGGER.info("init MatrixThreadGroup[I]");
        System.out.println("init ExecutorService ArrayBlockingQueue ...");
        for (int i=0;i<3;i++){
            ThreadPoolExecutor service = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
            service.setKeepAliveTime(10, TimeUnit.SECONDS);
            queue.add(service);
        }
        LOGGER.info("init MatrixThreadGroup[O]");
    }

    /**
     * 获取一个线程池对象
     * @return
     */
    public static ExecutorService getExecutorService(String name){
        LOGGER.info(name+" getService pre size={}", queue.size());
        ExecutorService poll = null;
        try {
            poll = queue.poll(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(name+" getService end size={}", queue.size());
        return poll;
    }

    /**
     * 放回一个线程池对象
     * @param service
     * @return
     */
    public static boolean setExecutorService(ExecutorService service, String name){
        LOGGER.info(name+" setService pre size={}", queue.size());
        boolean offer = queue.offer(service);
        LOGGER.info(name+" setService end size={}", queue.size());
        return offer;
    }

}
