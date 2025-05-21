import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public static void HTMLManager(Queue<HTMLTag> html) {
     Queue<HTMLTag> newQueue = new LinkedList<>();
     if(html.size() == 0) {
        throw new IllegalArgumentException("The queue is empty");
     } else {
        while(!html.isEmpty()) {
           newQueue.add(html.remove());
        }
     }
  }
  
  public static Queue<HTMLTag> getTags() {
     return null;
  }
  
  public String toString() {
     return "";
  }
  
  public static void fixHTML() {
  }
}

