
/**
 * Write a description of class Word here.
 * 
 * @author ( @author Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (10/03/17)) 
 */
public class Word
{
    public Word left,right;
    public String english;
    public String german;
    public String synonym;
    
    /**
     * Constructor for objects of class Word
     */
    public Word()
    {
        left = null;
        right = null;
        
        english = "";
        german = "";
        
        
    }
    
    
     /**
     * alternative constructor
     */
    public Word(String e, String g)
    {
        this.english = e;
        this.german = g;
        english = e;
        german = g;
   
    }
    
    
    //sets left node
    public void setLeft(Word n)
    {
        left = n;
    }
    
    //sets right node
    public void setRight(Word n)
    {
        right = n;
    }
    
    //getter for the left 
    public Word getLeft()
    {
        return left;
    }
    
    
    
    //getter for the right
    public Word getRight()
    {
        return right;
    }
    
    
    public String getEnglish()
    {
        return english;
    }
    
    public String getGerman()
    {
        return german;
    }
    
    public void setEnglish(String e)
    {
       english = e; 
        
    }
    
    public void setGerman(String g)
    {
        german = g;
    }
}
