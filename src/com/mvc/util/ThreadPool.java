package com.mvc.util;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mvc.dao.FoodDao;

public class ThreadPool {

	private static int queueDeep = 2000;

	public void createThreadPool() {
		/*
		 * 创建线程池，最小线程数为2，最大线程数为4，线程池维护线程的空闲时间为3秒，
		 * 使用队列深度为4的有界队列，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，
		 * 然后重试执行程序（如果再次失败，则重复此过程），里面已经根据队列深度对任务加载进行了控制。
		 */
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,2000, 3,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueDeep),
				new ThreadPoolExecutor.DiscardOldestPolicy());
		// 向线程池中添加 2000 个任务
		for (int i = 0; i < 2000; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (getQueueSize(tpe.getQueue()) >= queueDeep) {
				System.out.println("队列已满，等4秒再添加任务");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MyThreadPool ttp = new MyThreadPool(i);
			System.out.println("put i:" + i);
			tpe.execute(ttp);
		}

		tpe.shutdown();
	}

	private synchronized int getQueueSize(Queue queue) {
		return queue.size();
	}

	

	class MyThreadPool implements Runnable {
		private int foodId;

		public MyThreadPool(int foodId) {
			this.foodId = foodId;
		}

		public void run() {
			try {
				FoodDao fd=new FoodDao();
				//fd.editFoodNumber(foodId);
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
}
