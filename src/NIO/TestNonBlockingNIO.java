package NIO;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class TestNonBlockingNIO {
    @Test
    public void client() throws IOException {
        //1、获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1234));

        //2、切换非阻塞模式
        sChannel.configureBlocking(false);

        //3、分配缓冲区
        ByteBuffer buf = ByteBuffer.allocate(20);
       Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            //4、发送数据到服务端
            String str= scan.next();
            System.out.println(str);
            buf.put((new Date().toString()+str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        ssChannel.configureBlocking(false);

        ssChannel.bind(new InetSocketAddress(1234));

        Selector selector = Selector.open();

        //将通道注册到选择器,选择器监听状态
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //通过选择器轮询式获取选择器上已经准备就绪的事件
        while (selector.select() > 0) {
            //7.获取选择器中获得的就绪事件
            Iterator<SelectionKey> state = selector.selectedKeys().iterator();
            while (state.hasNext()) {
                SelectionKey sk = state.next();
                if (sk.isAcceptable()) {
                  //  state.remove();
                    SocketChannel sChannel = ssChannel.accept();

                    sChannel.configureBlocking(false);

                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(20);
                    int len = 0;
                    while ((len = sChannel.read(buf)) >0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                //取消选择器
                state.remove();
            }

        }
    }
}
