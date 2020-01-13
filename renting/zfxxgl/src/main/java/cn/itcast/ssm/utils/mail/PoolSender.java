package cn.itcast.ssm.utils.mail;

import java.util.concurrent.*;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.utils.mail
 * @ClassName: PoolSender
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2019/12/20 19:06
 * @Version: 1.0
 */
public class PoolSender {
    private BlockingQueue<Runnable> workQurty;//任务队列
    private ExecutorService es;//线程池接口

    public PoolSender(){
        workQurty = new LinkedBlockingQueue<Runnable>();//构造无界的任务队列，资源足够，理论可以支持无线个任务
        //核心线程（常驻）：2，最大线程数：4，允许线程最大空闲时间，30，最大线程时间单位：秒，线程使用的缓冲队列，对拒绝任务的处理策略：重试
        es = new ThreadPoolExecutor(4, 8, 30, TimeUnit.SECONDS, workQurty,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * 添加任务
     * @param task
     */
    public void send(Runnable task){
        es.execute(task);
    }

    /**
     * 清除线程池
     */
    public void close(){
        es.shutdown();
    }

    public static void main(String[] args) {
        PoolSender ps = new PoolSender();
        for (int i=0; i<10; i++){
            ps.send(new Sender("haha","123456","2449269649@qq.com","as2d1asda4s454a6",0,0));
        }
        ps.close();
    }
}
