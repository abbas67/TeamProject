import java.io.*;
/**
 * Write a description of class Dictionary here.
 * 
 * @author (Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (10/03/17)
 */
public class Dictionary
{
    public Word root;
    public String search2;

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


    public Word add(Word node, String english, String german)
    {

        return node;
    }

    public boolean add(String english, String german) 
    {

        Word newNode = new Word(english, german);
        Word current = root;
        Word previous = null;
        boolean foundNode = false;
        boolean valid;

        if(root == null)
        {
            root = newNode;

        }

        else
        {
            //find insertion point
            while(current != null)
            {
                if (current.getEnglish() == newNode.getEnglish())
                {
                    System.out.println("Value matches a previous one thats been entered, please try again");
                    return false;
                }
                else if ( current.getEnglish().compareTo(english) < 0) 
                {
                    previous = current;
                    current = current.getLeft();

                }
                else if (current.getEnglish().compareTo(english) > 0) 
                {
                    previous = current;
                    current = current.getRight();
                }
            }

            //now insert the number
            if(previous.getEnglish().compareTo(english) < 0)
            {
                previous.setLeft(newNode);
            }
            else
            {
                previous.setRight(newNode);
            }
        } 

        return true;
    }
    
      /**
     * prints all three trees, in order pre order and post order
     */

    public void printTree()
    {
        int id = 22;
        

        System.out.println(" - In order english numbers - ");
        inOrder(root);
        System.out.println(" ");

        System.out.println(" - Pre order english numbers - ")  ;  
        preOrder(root);
        System.out.println(" ");

        System.out.println(" - Post order english numbers - ");
        postOrder(root);
        System.out.println(" ");

    }

    private void print(Word node)
    {
        
        if (node!=null)
        {
           
           print(node.getRight());
           
           
           System.out.println("English: " + node.getEnglish() + " German: " + node.getGerman() );
           print(node.getLeft());
           
         }
    }

    //prints the tree
    public void print()
    {
        print(root);
    }
    
    
    /**
     * in order print method, looks at the left side of the tree then prints then looks right
     */

    public void inOrder(Word node)
    {

        if(node != null)
        {

            inOrder(node.getLeft());

            System.out.println("englishs id is - " + node.getEnglish());
            System.out.println(" with a mark of - " + node.getGerman());
            System.out.println(" ");

            inOrder(node.getRight());
        }

    }
    
    public void preOrder(Word node)
    {
        if(node != null)
        {
            System.out.println("englishs id is - " + node.getEnglish());
            System.out.println(" with a mark of - " + node.getGerman());
            System.out.println(" ");

            if(node.getLeft() != null)
                preOrder(node.getLeft());

            if(node.getRight() != null)
                preOrder(node.getRight());
        }
    }

    /**
     * post order print method, looks left and right then prints out
     */

    public void postOrder(Word node)
    {
        if(node != null)
        {
            if(node.getLeft() != null)
                postOrder(node.getLeft());

            if(node.getRight() != null)
                postOrder(node.getRight());

            System.out.println("englishs id is - " + node.getEnglish());
            System.out.println(" with a mark of - " + node.getGerman());
            System.out.println(" ");
        }
    }

    


    
    public void delete()
    {

    }

    private boolean search(Word node, String english)
    {
        boolean searching =  false;
        while (!searching && (node != null))
        {
            
            int i  = node.getEnglish().length();
            
            if(english.compareTo(english) < i)
            
                        node = node.getLeft();
                         else if(english.compareTo(english) > i)
                        node = node.getRight();
                        else
                        {
                        searching = true;
                        search2 = node.getGerman();
                        break;
                       }
            searching = search(node,english);
        }
        return searching;
    }
    
    public boolean search(String english)
    {
        search2 = " ";
        return search(root,english);
        
    }
    
    public String foundGerman()
    {
        return search2;
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
