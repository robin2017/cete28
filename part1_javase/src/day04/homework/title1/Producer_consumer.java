package day04.homework.title1;

import java.util.Date;

/**
 * 客户端
 */
public class Producer_consumer {
    /**主函数*/
    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();

        Thread producerThread = new Thread(new Producer(server));
        Thread consumerThread = new Thread(new Consumer(server));

        producerThread.start();
        consumerThread.start();
    }
}

/**抽象缓存*/
interface Buffer
{
    /**插入*/
    public abstract void insert(Object item);
    /**移除*/
    public abstract Object remove();
}
/**具体缓存*/
class BoundedBuffer implements Buffer {
    /**缓存空间大小*/
    private static final int BUFFER_SIZE = 5;
    /**缓存中对象个数*/
    private int count;
    /**缓存中下一个空闲坐标*/
    private int in;
    /**缓存中下一个满坐标*/
    private int out;
    /**缓存数组*/
    private Object[] buffer;
    /**构造器*/
    public BoundedBuffer() {
        count = 0;in = 0;out = 0;
        buffer = new Object[BUFFER_SIZE];
    }
    public synchronized void insert(Object item) {
        while (count == BUFFER_SIZE) {
            try {wait();} catch (InterruptedException e) {
            }
        }
        ++count;
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        if (count == BUFFER_SIZE)
            System.out.println("Producer Entered " + item + " Buffer FULL");
        else
            System.out.println("Producer Entered " + item + " Buffer Size = " + count);
        notify();
    }
    public synchronized Object remove() {
        Object item;

        while (count == 0) {
            try {wait();} catch (InterruptedException e) {
            }
        }
        --count;
        item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        if (count == 0)
            System.out.println("Consumer Consumed " + item + " Buffer EMPTY");
        else
            System.out.println("Consumer Consumed " + item + " Buffer Size = " + count);
        notify();
        return item;
    }
}

/**消费者*/
class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer b) {
        buffer = b;
    }
    public void run() {
        Date message;
        while (true) {
            System.out.println("Consumer napping");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // consume an item from the buffer
            System.out.println("Consumer wants to consume.");
            message = (Date) buffer.remove();
        }
    }
}

/**生产者*/
class Producer implements Runnable {
    private Buffer buffer;
    public Producer(Buffer b) {
        buffer = b;
    }
    public void run() {
        Date message;
        while (true) {
            System.out.println("Producer napping");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced " + message);
            buffer.insert(message);
        }
    }
}
