package MultyThread;

import sun.awt.geom.AreaOp;

public class Demo01Runable {
    public static void main(String[] args) {
        Runnable ra=new RunnableImp();
        Thread t1= new Thread(ra);
        t1.start();
        for(int i=0;i<10;i++)
            System.out.println(Thread.currentThread().getName()+"->"+i);
        //System.out.println();
    }

}
