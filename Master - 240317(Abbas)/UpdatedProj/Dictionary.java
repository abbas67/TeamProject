import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/**
 * Write a description of class Dictionary here.
 * 
 * @author (Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (24/03/17)
 */
public class Dictionary
{
    private Word root;

    public String fileWrite;
    public String preorderEnglish = "";
    public String preorderGerman = "";
    private boolean isLeft;

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

    public void setRoot(Word root)
    {
        this.root = root;

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
        //      int id = 22;
        //      
        //
        //      System.out.println(" - In order english numbers - ");
        //      inOrder(root);
        //      System.out.println(" ");

        //      System.out.println(" - Pre order english numbers - ")  ;  
        //      preOrder(root);
        //      System.out.println(" ");

        //      System.out.println(" - Post order english numbers - ");
        //      postOrder(root);
        //      System.out.println(" ");

    }

    private void print(Word node)
    {

        if (node!=null)
        {

            print(node.getRight());

            System.out.println("English: " + node.getEnglish() + "\n"  + "German: " + node.getGerman() );
            print(node.getLeft());

        }
    }

    //prints the tree
    public void print()
    {
        print(root);
    }

    public void printTree2()
    {

        //System.out.println(" - In order student numbers - ");
        //inOrder(root);
        //System.out.println(" ");

        // System.out.println(" - Pre order student numbers - ")  ;  
        preOrder(root);
        //  System.out.println(" ");

        // System.out.println(" - Post order student numbers - ");
        // postOrder(root);
        //System.out.println(" ");

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
            System.out.println("german is - " + node.getGerman());
            System.out.println(" ");

            inOrder(node.getRight());
        }

    }

    public void preOrder(Word node)
    {
        if(node != null)
        {
            System.out.println("english meaning " + node.getEnglish());
            System.out.println(" German meaning- " + node.getGerman());
            System.out.println(" ");

            if(node.getLeft() != null)
                preOrder(node.getLeft());

            if(node.getRight() != null)
                preOrder(node.getRight());
        }
    }

    private void getPreOrder(Word node)
    {
        if (node == null)
            return;

        preorderEnglish = preorderEnglish + node.getEnglish() + "\n ";
        preorderGerman = preorderGerman + node.getGerman()  + "\n ";
        getPreOrder(node.getLeft());
        getPreOrder(node.getRight());
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

            System.out.println("english is - " + node.getEnglish());
            System.out.println(" German is  - " + node.getGerman());
            System.out.println(" ");
        }
    }

    /**
     * a method used to find if a node is a parent node. 
     * Method is used in the delete method
     */

    public Word findParent(String english)
    {
        Word previous = null;
        Word current = root;

        while( current != null)
        {

            int searchID = current.getEnglish().compareTo(english);
            if (searchID < 0)
            {
                previous = current;
                current = current.getLeft();
            }
            else if (searchID > 0)
            {   
                previous = current;
                current = current.getRight();
            }
            else
            {
                return previous;

            }

        }
        return null;
    }

    public void deleteNode(String english)
    {
        Word focusNode = search(english);
        Word parent = findParent(english);
        if(focusNode.getLeft() == null && focusNode.getRight() == null)
        {
            if(focusNode == root){root = null;}
            else if(isLeft){parent.setLeft(null);}
            else{parent.setRight(null);}            
        }
        else if(focusNode.getRight() == null)
        {
            if(focusNode == root){setRoot(focusNode.getLeft());}
            else if(isLeft){parent.setLeft(focusNode.getLeft());}
            else{parent.setRight(focusNode.getLeft());}
        }
        else if(focusNode.getLeft() == null)
        {
            if(focusNode == root){setRoot(focusNode.getRight());}
            else if(isLeft){parent.setLeft(focusNode.getRight());}
            else{parent.setRight(focusNode.getRight());}            
        }
        else
        {
            Word replacement = getReplacement(focusNode);
            if(focusNode == root){setRoot(replacement);}
            else if(isLeft){parent.setLeft(replacement);}
            else{parent.setRight(replacement);}
            replacement.setLeft(focusNode.getLeft());
        }
    }

    public Word getReplacement(Word replacedNode)
    {
        Word rParent = replacedNode;
        Word r = replacedNode;
        Word focusNode = replacedNode.getRight();

        while(focusNode != null)
        {
            rParent = r;
            r = focusNode;
            focusNode = focusNode.getLeft();
        }

        if( r != replacedNode.getRight())
        {
            rParent.setLeft(r.getRight());
            r.setRight(replacedNode.getRight());
        }
        return r;
    }

    public void load()
    {

    }

    public void save(String name)
    {    
        name += ".txt";
        FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        try
        {
            outputStream = new FileOutputStream(name);
            printWriter = new PrintWriter(outputStream);    

            getPreOrder(root);

            printWriter.println(preorderEnglish);
            printWriter.println(preorderGerman);
            printWriter.close(); 
        }    

        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or writing to the file");
        }

        System.out.println("You are no longer writing to a file.");          
    }

    /**
     * search method to find the student id of a student
     */

    public Word search(String english)
    {

        Word current = root;

        while( current != null)
        {

            int searchID = current.getEnglish().compareTo(english);
            if (searchID < 0)
                current = current.getLeft();
            else if (searchID > 0)
                current = current.getRight();
            else
            {
                return current;

            }

        }

        return null;
    }

    /**
     * Method to open a file inorder to be read.
     * 
     * @param String file - filename
     * @return BufferedReader bufferedReader
     */
    public static BufferedReader openFileToRead(String input)
    {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;        

        try
        {
            fileReader = new FileReader(input);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (IOException e)
        {
            System.out.println("An unknown error has occured when opening the file");
        }
        finally{
            return bufferedReader;
        }
    }

    public void readInTranslation()
    {
        BufferedReader bufferedReader = openFileToRead("one.txt"); 
        try
        {
            String readLine = bufferedReader.readLine();
            while (readLine != null)
            {
                String[] list;
                list = readLine.split(" ");
                String english = list[0];
                String german = list[1];
                add(english,german);
                readLine = bufferedReader.readLine();
            }
            System.out.println("Upload complete");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred when attempting to close the file");
        }
    }
}