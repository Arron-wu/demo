/**
 * Copyright (C), 2019-2020, 成都房联云码科技有限公司
 * FileName: TestCAS
 * Author:   Arron-wql
 * Date:     2020/8/4 14:23
 * Description: CAS
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pig4cloud.pigx.demo.test;

import com.pig4cloud.pigx.demo.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 算法
 *
 * @author qinglong.wu@funi365.com
 * @create 2020/8/4
 * @Version 1.0.0
 */
public class TestCAS {
	//CAS算法提供的数据类型
	private static AtomicInteger atomicInteger =  new AtomicInteger();
	//同步容器
	private static ConcurrentHashMap<String,Object>  concurrentHashMap= new ConcurrentHashMap();
	public static int getAtomicInteger(){
		return atomicInteger.getAndIncrement();
	}
	public static void setConcurrentHashMap(int v){
      concurrentHashMap.put(v+"",v);
		Collection<Object> values = concurrentHashMap.values() ;// 得到全部的value
		Iterator<Object> iter = values.iterator() ;
		String str = "";
		while(iter.hasNext())
		{
			str = iter.next().toString() + "," ;
		}
		System.out.print(str) ;
	}

	public static void main(String[] args) {
		ArrayList<Future<Integer>> list = new ArrayList<>();
		for (int i=0;i<10;i++){
			Future<Integer> future = ThreadPoolUtil.getPool().submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int atomicInteger = getAtomicInteger();
					System.out.println(atomicInteger);
					setConcurrentHashMap(atomicInteger);
					return 1;
				}
			});
			list.add(future);
		}
		ThreadPoolUtil.getPool().shutdown();
		while (true) {//等待所有任务都执行结束
			if (ThreadPoolUtil.getPool().isTerminated()) {//所有子线程执行完毕
				break;
			}
		}
		System.out.println("==================");
		//list.forEach(System.out::println);
		for (Future<Integer> f: list) {
			try {
				System.out.print(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}