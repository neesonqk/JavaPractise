package stream.practise1;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtility {

    private String path = FileUtility.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/stream/practise1";

    @Test
    public void fileCopy() throws IOException{
        try(InputStream inputStream = new FileInputStream(path + "/pack.zip")){
            try (OutputStream outputStream = new FileOutputStream(path + "/pack2.zip")){
                byte[] buffer = new byte[1024];
                while (inputStream.read(buffer) != -1){
                    outputStream.write(buffer);
                }
            }
        }
    }

    @Test
    public void fileCopy2() throws IOException{
        try(FileInputStream inputStream = new FileInputStream(path + "/pack.zip")){
            try (FileOutputStream outputStream = new FileOutputStream(path + "/pack2.zip")){
                FileChannel inChannel = inputStream.getChannel();
                FileChannel outChannel = outputStream.getChannel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while (inChannel.read(byteBuffer) != -1){
                    byteBuffer.flip();
                    outChannel.write(byteBuffer);
                    byteBuffer.clear();
                }
            }
        }
    }
}
