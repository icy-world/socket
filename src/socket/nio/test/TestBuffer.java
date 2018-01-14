package socket.nio.test;

import java.nio.IntBuffer;

/**
 * Created by root on 2018/1/15.
 */
public class TestBuffer {
    public static void main(String[] args) {
        /*
        创建容量为10的buffer
        put元素之后
        需要进行flip进行复位：limit = position，position = 0
         */
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(1);
        buffer.put(20);
        buffer.put(15);
        System.out.println("flip之前的buffer" + buffer);
        for (int i = 0; i < buffer.limit(); i++) {
            //会报错
//            System.out.println(buffer.get());
        }
        buffer.flip();
        System.out.println("flip之后的position" + buffer.position());
        System.out.println("flip之后的limit" + buffer.limit());
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.println(buffer.get());

        }
        System.out.println("--------------------------------------------");
        int [] arr  = {1,2,3,4,5};
        IntBuffer buffer1 = IntBuffer.wrap(arr);
        System.out.println("通过wrap创建buffer：" + buffer1);
        for (int i = 0; i < buffer1.limit(); i++) {
            System.out.println(buffer1.get());
        }
        buffer1.flip();
        System.out.println("flip buffer1:" + buffer1);


        System.out.println("--------------------------------------------");
        //position=3，limit=6
        IntBuffer buffer2 = IntBuffer.wrap(arr,2,2);
        System.out.println("buffer2" + buffer2);

        //remaining返回limit - position
        buffer2.position(1);
        System.out.println("buffer2 remaining:" + buffer2.remaining());
        for (int i = 0; i < buffer2.remaining(); i++) {
            System.out.println("buffer2.get(i):" + buffer2.get(i));
        }
        buffer2.position(0);//只复位position，limit不变
        for (int i = 0; i < buffer2.limit(); i++) {
            System.out.println(buffer2.get());
        }
    }
}
