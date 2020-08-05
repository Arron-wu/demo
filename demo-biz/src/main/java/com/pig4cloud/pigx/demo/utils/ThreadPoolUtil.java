/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: ThreadPoolUtil
 * Author:   Arron-wql
 * Date:     2020/7/6 15:07
 * Description: 线程池工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.utils;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池工具类
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/7/6
 * @Version 1.0.0
 */
public class ThreadPoolUtil {

	/**
	 * 核心线程数，会一直存活，即使没有任务，线程池也会维护线程的最少数量
	 */
	private static final int SIZE_CORE_POOL = 5;
	/**
	 * 线程池维护线程的最大数量
	 */
	private static final int SIZE_MAX_POOL = 10;
	/**
	 * 线程池维护线程所允许的空闲时间
	 */
	private static final long ALIVE_TIME = 2000;
	/**
	 * 线程缓冲队列
	 */
	private static BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(100);
	private static ThreadPoolExecutor pool = new ThreadPoolExecutor(SIZE_CORE_POOL, SIZE_MAX_POOL, ALIVE_TIME, TimeUnit.MILLISECONDS, bqueue, new ThreadPoolExecutor.CallerRunsPolicy());

	static {
		pool.prestartAllCoreThreads();
	}

	public static ThreadPoolExecutor getPool() {
		return pool;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=1;i<5;i++){
			list.add(i);
		}
		final int[] j = {5};
		list.stream().forEach(m ->{  //遍历查出来的所有数据
			ThreadPoolUtil.getPool().execute(new Runnable() {
				@Override
				public void run() {
					//连接查询数据
					decre(j);
				}
			});
		});
		ThreadPoolUtil.getPool().shutdown();
		while (true){
			if (ThreadPoolUtil.getPool().isTerminated()){  //所有子线程执行完毕
				break;
			}
		}
		//执行接下来的逻辑
		System.out.println("执行完毕");
	}

	public static synchronized void decre(int[] j){
		j[0]--;
		System.out.println(j[0]);
	}
}
