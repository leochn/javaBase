package com.vnext.w15jdk8.exer;

import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架
 * Fork/Join采用“工作窃取模式”，当执行新的任务时他可以将其拆分成更小的任务执行，
 *   并将小任务加到线程队列中，然后再从一个随即线程中偷一个并把它加入自己的队列中。
 *
 *   就比如两个CPU上有不同的任务，这时候A已经执行完，B还有任务等待执行，这时候A就会将B队尾的任务偷过来，
 *   加入自己的队列中，对于传统的线程，ForkJoin更有效的利用的CPU资源！
 * @author leo
 * @version 2018/2/28 20:22
 * @since 1.0.0
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 13475679780L;

    private long start;
    private long end;

    private static final long THRESHOLD = 10000L; //临界值

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end )/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork(); // 拆分，并将该子任务压入线程队列中

            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();

            return left.join() + right.join();
        }
    }
}
