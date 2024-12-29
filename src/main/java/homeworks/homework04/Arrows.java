package homeworks.homework04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arrows {
    public static void main(String[] args) {
        String arrows = ">>--><<-->----<-->>>";
        Pattern pattern = Pattern.compile("(>>-->)|(<--)");
        Matcher matcher = pattern.matcher(arrows);
        int counter = 0 ;
        while (matcher.find()) {
            counter++;
        }
        System.out.println(counter);

    }
}
