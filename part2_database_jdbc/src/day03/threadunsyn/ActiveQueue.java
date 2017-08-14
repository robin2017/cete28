package day03.threadunsyn;

import java.util.Stack;
//Class
public class ActiveQueue {
	private Stack _queue;
	private final static int QUEUE_SIZE = 20;

	public ActiveQueue() {
		_queue = new Stack();
	}

	public synchronized  void enqueue(MethodRequest mr) {
		while (_queue.size() > QUEUE_SIZE) {
			try {
		     this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		_queue.push(mr);
		this.notifyAll();
		System.out.println("将产品放入队列中，现在阻塞队列中产品个数："+_queue.size());
	}

	public synchronized MethodRequest dequeue() {
		MethodRequest mr;

		while (_queue.empty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mr = (MethodRequest) _queue.pop();
		this.notifyAll();

		return mr;
	}
	


}
