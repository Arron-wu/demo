/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestReadWriteLock
 * Author:   Arron-wql
 * Date:     2020/8/6 20:52
 * Description: 读写锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import cn.hutool.core.thread.ThreadUtil;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author qinglong.wu
 * @create 2020/8/6
 * @Version 1.0.0
 */
public class TestReadWriteLock {

	private volatile HashMap<String,Object> cache = new HashMap();

	private volatile ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public void setCache(String key,Object value){
		readWriteLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " : 开始写");
		try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
		cache.put(key,value);
		System.out.println(Thread.currentThread().getName() + " : 写完");
		readWriteLock.writeLock().unlock();
	}

	public void getCache(String key){
		readWriteLock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + " : 开始读");
		try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
		cache.get(key);
		System.out.println(Thread.currentThread().getName() + " : 读完");
		readWriteLock.readLock().unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		TestReadWriteLock testReadWriteLock = new TestReadWriteLock();
		//所有线程执行完毕之后  再执行最终逻辑
		CountDownLatch countDown = new CountDownLatch(10);
		for (int i = 0; i < 5; i++) {
			final int temp = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					testReadWriteLock.getCache(temp+"");
					countDown.countDown();
				}
			},"r"+i).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
                  testReadWriteLock.setCache(temp+"",temp+"");
                  countDown.countDown();
				}
			},"w"+i).start();
		}
		countDown.await();
		System.out.println("===========》  执行完毕  ");
	}
}
