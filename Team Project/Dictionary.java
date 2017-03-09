
/**
 * Write a description of class Dictionary here.
 * 
 * @author (Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (10/03/17)
 */
public class Dictionary
{
    public Word root;
    

    /**
     * Constructor for objects of class Dictionary
     */
    public Dictionary(String english, String german)
    {
       root = new Word(english,german);
    }
    
     //Alternate constructor
 
     public Dictionary()
    {
        root = null;
    }
    
    
    public void add(String english, String german)
    {
        root = add(root,english,german);
    }
    
    public Word add(Word node, String english, String german)
    {

        return node;
    }
    
    
    public void delete()
    {
        
    }
    
    public void search()
    {
        
    }
    
    public void load()
    {
        
    }
    
    public void save()
    {
        
    }
    
    public void compareWord()
    {
        
    }
    
    public void calculateTimeTaken()
    {
        
    }
}
