/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestCountDownLatch
 * Author:   Arron-wql
 * Date:     2020/8/9 13:58
 * Description: countdownlatch+cyclicbarrier+semaphore
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import java.util.concurrent.*;

/**
 * countdownlatch  减 (秦灭六国)
 * cyclicbarrier   加 (集齐龙珠召唤神龙)
 * semaphore       信号量 (抢车位)
 *
 * @author qinglong.wu
 * @create 2020/8/9
 * @Version 1.0.0
 */
public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
		/**
		 * CountDownLatch
		 */
		System.out.println("CountDownLatch开始=======================");
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 0; i < 6; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+"  执行完毕");
						TimeUnit.SECONDS.sleep(1);
						countDownLatch.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			},String.valueOf(i)).start();
		}
		countDownLatch.await();
		System.out.println("所有线程执行完毕，执行最后逻辑!");

		/**
		 * cyclicbarrier
		 */
		System.out.println("cyclicbarrier开始=======================");
		CyclicBarrier cyclicBarrier = new CyclicBarrier(6,()->{
			System.out.println("人到齐了，开始开会.......");
		});
		for (int i = 0; i < 6; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"  到达会场");
					try {
						cyclicBarrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			},String.valueOf(i)).start();
		}
		TimeUnit.SECONDS.sleep(1);

		/**
		 * semaphore
		 */
		System.out.println("semaphore开始=======================");
		Semaphore semaphore = new Semaphore(3,false);//可以设置公平和非公平锁
		for (int i = 0; i < 6; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName()+" 开始用餐");
						TimeUnit.SECONDS.sleep(2);
						System.out.println(Thread.currentThread().getName()+" 用餐结束");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						semaphore.release();
					}

				}
			},String.valueOf(i)).start();
		}
	}
}
