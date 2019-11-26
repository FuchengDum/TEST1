package MultyThread;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class MyThread extends Thread{
    @Override
    public void run(){
           // for(int i=0;i<20;i++)
            //    System.out .println("run:"+ i);
        //String name=getName();
        //System.out.println("Name="+name);
        //Thread t= currentThread();
        //String name=getName();
        System.out.println(Thread.currentThread().getName());
    }
}
