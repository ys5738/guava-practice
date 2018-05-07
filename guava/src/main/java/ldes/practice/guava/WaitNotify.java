package ldes.practice.guava;

class NumberPrint implements Runnable{  
    private int number;  
    public byte res[];  
    public static int count = 5;  
    public NumberPrint(int number, byte a[]){  
        this.number = number;  
        res = a;  
    }  
    public void run(){  
        synchronized (res){  
            while(true){  
                try {  
                    res.notifyAll();//唤醒等待res资源的线程，把锁交给线程（该同步锁执行完毕自动释放锁）  
                    System.out.println(" "+number);  
                    res.wait();//释放CPU控制权，释放res的锁，本线程阻塞，等待被唤醒。  
                    System.out.println("------线程"+Thread.currentThread().getName()+"获得锁，wait()后的代码继续运行："+number);  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }//end of while  
        }//synchronized  
          
    }  
}  

public class WaitNotify {  
    public static void main(String args[]){  
        final byte a[] = {0};//以该对象为共享资源  
        new Thread(new NumberPrint((1),a),"1").start();  
        new Thread(new NumberPrint((2),a),"2").start();  
        new Thread(new NumberPrint((3),a),"3").start();  
        new Thread(new NumberPrint((4),a),"4").start();  
        new Thread(new NumberPrint((5),a),"5").start();  
    }  
}  
