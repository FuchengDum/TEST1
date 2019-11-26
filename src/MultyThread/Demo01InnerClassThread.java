package MultyThread;

public class Demo01InnerClassThread {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                for (int i=0;i<100;i++)
                    System.out.println(Thread.currentThread().getName()+i);
            }
        }.start();
        Runnable ra=new Runnable(){
            @Override
            public void run(){
                for (int i=0;i<100;i++)
                    System.out.println(Thread.currentThread().getName()+"->"+i);
            }
        };
        new Thread(ra).start();
    }
}
