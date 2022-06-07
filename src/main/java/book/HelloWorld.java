package book;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public String handler(String s) {
        return "Hello, " + s;
    }

    public List<Integer> handlerList(List<Integer> input) {
        List<Integer> newList = new ArrayList<>();
        input.forEach(x -> newList.add(100 + x));
        return newList;
    }
}