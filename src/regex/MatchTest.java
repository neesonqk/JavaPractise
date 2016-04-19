package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchTest {
    private final String simple = "2311 2323 asdf 21231 sdfadfa  2342asdf 12315 123";

    @Test
    public void findAll2(){
        Pattern pattern = Pattern.compile("(23)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(simple);
        if(matcher.find()){
            System.out.println(matcher.group(0));
            //System.out.println(matcher.group());
        }else {
            System.out.println("Found nothing.");
        }
    }
}
