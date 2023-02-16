package MultiThreading;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Display {

        public synchronized void wish(String name){
        for(int i=0;i<3;i++){
            System.out.print("Good Morning: ");
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){}
            System.out.println(name);
        }
    }
    }
    class MyThread extends Thread{
        Display d;
        String name;
        MyThread(Display d, String name){
            this.d=d;
            this.name=name;
        }
        public void run(){
            d.wish(name);
        }
    }
    class SynchronizedDemo{

        public static void main(String[] args) {
            Display d = new Display();
            MyThread t1 = new MyThread(d,"Asrith");
            MyThread t2 = new MyThread(d,"Manoj");
            t1.start();
            t2.start();
        }
    }