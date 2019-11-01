package com.java.tao.gaode.service.impl;

import com.java.tao.gaode.service.MatrixService;
import com.java.tao.gaode.utils.MatrixThreadGroup;
import com.java.tao.gaode.utils.MatrixThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@Service
public class MatrixServiceImpl implements MatrixService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixServiceImpl.class);

    /**
     * 10*10线程池
     */
    @Override
    public List<String> matrix(List<String> lats, List<String> lons, Integer rows, String name) {
        LOGGER.info(name+" matrix method[I]");
        List<String> list = new ArrayList<>();
        Integer latSize = lats.size();
        int page = latSize/rows;
        int last = latSize%rows;
        ExecutorService service = MatrixThreadGroup.getExecutorService(name);
        try{
            if(service==null){
                return null;
            }
            LOGGER.info(name+" ExecutorService={}", service.toString());
            list = generate(service, lats, lons, rows, page, last, name);
            if(service!=null){
                MatrixThreadGroup.setExecutorService(service, name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        LOGGER.info(name+" matrix method[O]");
        return list;

    }

    /**
     * 生成矩阵
     */
    private List<String> generate(ExecutorService service, List<String> lats, List<String> lons, Integer rows, int page, int last, String name) throws ExecutionException, InterruptedException {
        LOGGER.info(name+" generate[I] rows={}, page={}, last={}", rows, page, last);
        List<String> list = new ArrayList<>();
        List<Future<List<String>>> futures = new ArrayList<Future<List<String>>>();
        for (int k=0;k<page;k++){
            int start = k*rows;
            int end = k*rows + rows;
            Future<List<String>> future = getFuture(service, lats, lons, start, end, name);
            futures.add(future);
        }
        if(last>0){
            int start = page*rows;
            int end = page*rows + last;
            Future<List<String>> future = getFuture(service, lats, lons, start, end, name);
            futures.add(future);
        }
        for (Future<List<String>> f : futures) {
            list.addAll(f.get());
        }
        LOGGER.info(name+" generate[O] rows={}, page={}, last={}", rows, page, last);
        return list;
    }

    private Future<List<String>> getFuture(ExecutorService service, List<String> lats, List<String> lons, int start, int end, String name){
        Future<List<String>> submit = service.submit(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                List<String> list = new ArrayList<>();
                LOGGER.info(name+" thread name --> " + Thread.currentThread().getName() + " start=" + start + ",end=" + end);
                for (int i = start; i < end; i++) {
                    for (int j = 0; j < lons.size(); j++) {
                        Thread.sleep(1000);
                        list.add(lats.get(i) + "-" + lons.get(j));
                    }
                }
                LOGGER.info(name+" thread name --> " + Thread.currentThread().getName() + " end ...");
                return list;
            }
        });
        return submit;
    }



    /**
     * 70自由线程+3*10线程池
     */
    @Override
    public List<String> matrix2(List<String> lats, List<String> lons, Integer rows, String name) {
        LOGGER.info(name+" matrix method[I]");
        List<String> list = new ArrayList<>();
        Integer latSize = lats.size();
        int page = latSize/rows;
        int last = latSize%rows;
        if(page>=4){
            /**
             * 使用3*10线程池
             */
            LOGGER.info(name+" into 3*10 thread pool");
            ExecutorService service = MatrixThreadPool.getExecutorService(name);
            try{
                if(service==null){
                    return null;
                }
                LOGGER.info(name+" service={}", service.toString());
                list = generate(service, lats, lons, rows, page, last, name);
                if(service!=null){
                    MatrixThreadPool.setExecutorService(service, name);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            /**
             * 使用70个自由线程
             */
            LOGGER.info(name + " into 70 free thread");
            try{
                LOGGER.info(name+" service={}", MatrixThreadPool.service.toString());
                list = generate(MatrixThreadPool.service, lats, lons, rows, page, last, name);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }

}
