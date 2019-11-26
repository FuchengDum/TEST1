package MultyThread;

public class Demo01Thread {
    public static void main(String[] args) {
        //MyThread mt1= new MyThread();
        //mt1.start();
        //MyThread mt2 =new MyThread();
        //mt2.start();
        for(int i=0;i<20;i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(1000);
                //Thread.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
