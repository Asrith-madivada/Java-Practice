package MultiThreading;
class A{
    public synchronized void m1(B b){
        System.out.println("Thread 1 starts executing m1(B b)");
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){}
        System.out.println("Thread 1 trying to call B's n2()");
        b.n2();
    }
    public synchronized void m2(){
        System.out.println("m2() of Class A");
    }

}
class B{
    public synchronized void n1(A a){
        System.out.println("Thread 2 starts executing n1(A a)");
        try{
            Thread.sleep(1);
        }
        catch (InterruptedException e){}
        System.out.println("Thread 2 trying to call A's m2()");
        a.m2();
    }
    public synchronized void n2(){
        System.out.println("n2() of Class B");
    }

}
public class Deadlock extends Thread {
    A a = new A();
    B b = new B();
    public void m1(){
        this.start();
        a.m1(b);
    }
    public void run(){
        b.n1(a);
    }
    public static void main(String[] args){
        Deadlock d = new Deadlock();
        d.m1();
    }
}
