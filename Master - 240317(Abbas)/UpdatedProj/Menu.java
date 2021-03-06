import java.io.IOException;
import java.io.BufferedReader;
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

    public Menu()
    {
        myDictionary.readInTranslation();
    }
    
    /**
     * Used to process the User input in the menu
     */
    public void processUserChoices() 
    {
        //clearScreen();
        System.out.println("Main Menu");
        System.out.println("");
        System.out.println("");
        char userChoice = ' ';
        do{

            displayMenu();
            userChoice = Genio.getCharacter();
            //clearScreen();
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
                
                System.out.println("Please enter the word you wish to delete");
                String d = Genio.getString();
                myDictionary.deleteNode(d);
                break;
                
                case 'S':
                case 's':      
                System.out.println("Please press Enter to continue");
                Genio.getString();
                System.out.print('\u000C');
                
                System.out.println("Please enter the word you wish to translate");
                String s = Genio.getString();
                search(s);

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
            pause();
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

    public void search(String id)
    {
        String tran = "";
        id = id.toLowerCase();
        String[] list = id.split(" ");
        for(int i=0;i<list.length;i++)
        {
            Word word = myDictionary.search(list[i]);
            String g = word.getGerman();
            if(g == null){tran = tran + " " + list[i];}
            else{tran = tran + " " + g;}
        }
        System.out.print(tran + " ");
    }

    public void translateFile()
    {
        
        String read;
        System.out.println("What file would you like to translate");
        read = Genio.getString();
        BufferedReader br = myDictionary.openFileToRead(read);

        try{
            String nextLine = br.readLine();
            while(nextLine !=null)
            {
                String[] Res = nextLine.split("[\\p{Punct}\\s]+");
                for (String s:Res){
                    search(s);
                }
                System.out.println("");
                nextLine = br.readLine();
            }

        }
        catch(IOException e){}
    }

    public void time()
    {
        long startTime = System.currentTimeMillis();

        myDictionary.readInTranslation();

        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    public void pause()
    {
        System.out.println();
        System.out.println("Please press Enter to continue");
        Genio.getString();
        clearScreen();
    }

    /**
     * Method to clear screen in command prompt
     * 
     * @param No Parameters
     * @return none
     */
    public void clearScreen()
    {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}