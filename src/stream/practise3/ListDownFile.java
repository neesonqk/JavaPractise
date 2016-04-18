package stream.practise3;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.File;

public class ListDownFile {
    private String path = ListDownFile.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/stream/practise2";
    @Test
    public void listDown(){
        File file = new File(path);
        for (File f : file.listFiles()) {
            if(f.isFile()){
                System.out.println(f.getName());
            }
        }
    }

    public void recursiveListDown(String path){
        File file = new File(path);
        for (File f : file.listFiles()) {
            if(f.isFile()){
                System.out.println(f.getName());
            }else if(f.isDirectory()){
                recursiveListDown(f.getPath());
            }
        }
    }

    @Test
    public void testRecursive(){
        ListDownFile listDownFile = new ListDownFile();
        String path = ListDownFile.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        listDownFile.recursiveListDown(path);
    }
}
