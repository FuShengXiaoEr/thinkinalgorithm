package org.chen.algorithm.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-09 22:49
 */
public class FileReadAndWrite {

    public static void main(String[] args) throws IOException {
        File sou = new File("F:\\极客时间\\JAVA36讲\\1.txt");
        File dest = new File("F:\\极客时间\\JAVA36讲\\2.txt");
        if (!sou.exists()) {
            sou.createNewFile();
        }

        if (!dest.exists()) {
            dest.createNewFile();
        }

//        copyFileByStream(sou,dest);
//        copyFileByChannel(sou, dest);
        copyFileByBuffer(sou,dest);
    }

    public static void copyFileByStream(File sou, File dest) throws IOException {
        try (InputStream is = new FileInputStream(sou);
             OutputStream os = new FileOutputStream(dest);) {
            byte[] bytes = new byte[1024];
            int length;
            while ((length = is.read(bytes)) > 0) {
                os.write(bytes, 0, length);
            }
        }
    }

    public static void copyFileByChannel(File sou, File dest) throws IOException {
        try (FileChannel souChannel = new FileInputStream(sou).getChannel();
             FileChannel destChannel = new FileOutputStream(dest).getChannel();) {
            for (long count = souChannel.size(); count > 0; ) {
                long trans = souChannel.transferTo(souChannel.position(), count, destChannel);
                count -= trans;
            }
        }
    }

    public static void copyFileByBuffer(File sour,File dest)throws IOException{
        try(FileChannel souChannel = new FileInputStream(sour).getChannel();
        FileChannel destChannel = new FileOutputStream(dest).getChannel();){
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = souChannel.read(byteBuffer);
            while(bytesRead!= -1){
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    destChannel.write(byteBuffer);
                }
                byteBuffer.clear();
                bytesRead = souChannel.read(byteBuffer);
            }
        }
    }
}
