package MultiThreading;

public class InterThreadComm {
    public static void main(String[] args)throws Exception {
        ThreadB b = new ThreadB();
        b.start();
        synchronized(b){
            System.out.println("Main thread calling wait()");
            b.wait();
            System.out.println("Main thread got notification");
            System.out.println(b.total);
        }
    }
}
class ThreadB extends Thread{
    int total=0;
    public void run(){
        synchronized(this){
            System.out.println("Child thread calling start calculation");
            for(int i=1;i<=100;i++){
                total=total+i;
            }
            System.out.println("Child thread giving notification");
            this.notify();
        }
    }
}