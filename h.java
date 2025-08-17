import java.util.HashSet;
import java.util.*;
public class h {
    public static void main(String[] args) {
        
        HashSet<String> h= new HashSet<>();
    h.add("preetham");
    h.add("naveen");
    Iterator<String> i=h.iterator();
    while(i.hasNext()){
        System.out.println(i.next());
    }
    }
    

}
