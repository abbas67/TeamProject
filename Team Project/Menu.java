
/**
 * Menu class main Menu 
 * 
 * @author (Chris Macleman, Adam Harmston, Peter Short, Abbas Lawal) 
 * @version (10/03/17)
 */
public class Menu
{
    Dictionary myDictionary = new Dictionary();
    
    
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
   
            
            break;
            
            
            case 'P':
            case 'p':      
            System.out.println("Please press Enter to continue");
            Genio.getString();
            System.out.print('\u000C');
            print();
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
        System.out.println("Q. Exit");
    }    
    
   
    public void exit()
    {
        System.exit(0);
        
        
    }
    
    public void print()
    {
        
    }

    
    
}