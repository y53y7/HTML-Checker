import java.util.*;

public class HTMLManager {
  private Queue<HTMLTag> tags;
  
  public HTMLManager(Queue<HTMLTag> html) {
     if(html.isEmpty()) {
        throw new IllegalArgumentException("The queue is empty");
     } else {
        tags = new LinkedList<>();
        while(!html.isEmpty()) {
           tags.add(html.remove());
        }
     }
  }
  
  public Queue<HTMLTag> getTags() {
     return tags;
  }
  
  public String toString() {
     Queue<HTMLTag> temp = new LinkedList<>();   //this queue is used to temporarily store tags
     String string = "";
     while(!tags.isEmpty()) {
        HTMLTag thisTag = tags.remove();
        string += thisTag + " ";
        temp.add(thisTag);                      //adds the current tag to the new queue
     }
     while(!temp.isEmpty()) {                  //moves the contents of the new queue back to the original queue
        tags.add(temp.remove());
     }
     return string;
  }
  
public void fixHTML() {
    Stack<HTMLTag> openTags = new Stack<>();
    Queue<HTMLTag> fixed = new LinkedList<>();

    while (!tags.isEmpty()) {
        HTMLTag tag = tags.remove();
        if (tag.isSelfClosing()) {
            fixed.add(tag);
        } else if (tag.isOpening()) {
            openTags.push(tag);
            fixed.add(tag);
        } else { 
            if (!openTags.isEmpty() && tag.matches(openTags.peek())) {
                openTags.pop();
                fixed.add(tag);
            } else {

            }
        }
    }

    while (!openTags.isEmpty()) {
        HTMLTag leftover = openTags.pop();
        fixed.add(leftover.getMatching());
    }

    tags = fixed;
}

}

