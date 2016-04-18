package stream.practise2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWordInFile {
    private String path = CountWordInFile.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/stream/practise2";
    private String findWord = "Sherlock";

    @Test
    public void count() throws IOException{
        int count = 0;
        try(FileReader fileReader = new FileReader(path + "/example.txt")){
            try(BufferedReader bufferedReader = new BufferedReader(fileReader)){
                String line;
                Pattern pattern = Pattern.compile(findWord);
                while ((line = bufferedReader.readLine()) != null){
                    Matcher matcher = pattern.matcher(line);
                    if(matcher.find()) count++;
                }
            }
        }
        System.out.println(count);
    }
}
