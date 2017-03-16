
/**
 * Menu class main Menu 
 * 
 * @author (Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (10/03/17)
 */
public class Menu
{
    Dictionary myDictionary = new Dictionary();
    private String english;
    private String german;
    
    
    //main method public static void main(String args[])
    public static void main(String args[])
    {
        Menu myMenu = new Menu();
        myMenu.processUserChoices();
    }
   
    /**
    * Used to process the User input in the menu
    */
    public void processUserChoices() 
    {
        System.out.println("Main Menu");
        System.out.println(" ");
        System.out.println("");
        char userChoice = ' ';
        char i  ;

       do{
       
        displayMenu();
        userChoice = Genio.getCharacter();
        //create and instance of the game class
  
        
        
        
        
        
        
        switch (userChoice)
        { 
            
            case 'A':
            case 'a':
             
            
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
            add();
           
            break;
            
            case 'D':
            case 'd':      
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
          
            break;
            
            case 'S':
            case 's':      
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
            search();
            
            break;
            
            
            case 'P':
            case 'p':      
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
            print();
            break;
            
            case 'b':
            case 'B':      
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
            System.out.println("Enter a file name");
            String filename = Genio.getString();
            myDictionary.save(filename);
            break;
                        
            case 'Q':
            case 'q':
            //exits the program
            exit();
            break;  
            
            
            default:
            System.out.println("The choice you have chosen is invalid");
    
        }
        
                    
              
        
                   
        
        
        
     }while( userChoice != 'Q' && userChoice !='q');
    }
       
     /**
     * Displays the main menu 
     */
    public void displayMenu()
    {
        System.out.println(" ");
        System.out.println("please select one of the options below");
        System.out.println("A. Add a word/phrase");
        System.out.println("D. Delete a word/phrase");
        System.out.println("S. To search for a word");
        System.out.println("P. Print a word from the dictionary");
        System.out.println("B. Save");
        System.out.println("Q. Exit");
    }    
    
   
    public void exit()
    {
        System.exit(0);
        
        
    }
    
    public void print()
    {
        myDictionary.print();
    }

    public void add()
    {
        String english;
        String german;
        System.out.println("Input the English word you'd like to add to the dictionary: ");
        english = Genio.getString();

        System.out.println("Input the German word you'd like to add to the dictionary: ");
        german = Genio.getString();

        myDictionary.add(english,german);
        
       // myDictionary.printTree();
       //Genio.getString();

    }
    
   
    
    public void search()
    {
        String input;
        System.out.println("Please type in the English word: ");
        english = Genio.getString();
        myDictionary.search(english);
        System.out.println("The german translation is " + myDictionary.foundGerman());
        
    }
    
}
