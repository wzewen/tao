package com.java.tao.gaode.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class MatrixThreadGroup {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixThreadGroup.class);

    private static ArrayBlockingQueue<ExecutorService> queue = new ArrayBlockingQueue<>(10);

    /**
     * 初始10个大小为10的线程池对象
     */
    static {
        LOGGER.info("init MatrixThreadGroup[I]");
        System.out.println("init ExecutorService ArrayBlockingQueue ...");
        for (int i=0;i<10;i++){
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
        LOGGER.info(name+" getExecutorService pre size={}", queue.size());
        ExecutorService poll = null;
        try {
            poll = queue.poll(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(name+" getExecutorService end size={}", queue.size());
        return poll;
    }

    /**
     * 放回一个线程池对象
     * @param service
     * @return
     */
    public static boolean setExecutorService(ExecutorService service, String name){
        LOGGER.info(name+" setExecutorService pre size={}", queue.size());
        boolean offer = queue.offer(service);
        LOGGER.info(name+" setExecutorService end size={}", queue.size());
        return offer;
    }

}
