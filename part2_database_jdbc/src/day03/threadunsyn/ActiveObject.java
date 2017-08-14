package day03.threadunsyn;


class ActiveObject extends Thread {
	public ActiveObject() {
		
		_queue = new ActiveQueue();
		this.start();
	}
	

	public void enqueue(MethodRequest mr) {
		_queue.enqueue(mr);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MethodRequest mr = _queue.dequeue();
			mr.call();
		}
	}

	private ActiveQueue _queue;
	
}
