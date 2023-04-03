import java.util.Scanner;
public class Hangman {
   
    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        String wordString = randomWord(words);
        char[] word = wordString.toCharArray();
        char[] misses = new char[6];
        int missCounter = 0;
        char[] correctGuesses = new char[word.length];
        for (int i = 0; i < word.length; i++){
            correctGuesses[i] = '-';
        }
        
        //Welcome the user
        System.out.println(gallows[0]);
        System.out.println("\nWelcome to Hangman by Amin Ambike!");
        System.out.println("Each turn you guess a different letter, the object of the game ");
        System.out.println("is to correctly guess a randomly selected word. You get 6 guesses ");
        System.out.println("to guess every correct letter in the word. ");

       while (missCounter < 6){
            printBoard(missCounter, correctGuesses, misses);
            System.out.println("\nGuess: ");
            char guess = scan.next().charAt(0);

            Boolean checkGuess = checkGuess(guess, word);
            if (checkGuess){
                updateBoardCorret(correctGuesses, word, guess);
            }
            else{
                missCounter++;
                updateBoardMiss(missCounter, misses, guess);
            }

            if(word == correctGuesses){
                System.out.println("YOU WIN!");
                System.exit(0);
            }


            
        }
        System.out.println("YOU LOSE!");
        correctGuesses = word;
        printBoard(missCounter, correctGuesses, misses);






    }
    // Returns a random word from array of possible words
    public static String randomWord(String[] words){
        int randomNum = (int)(Math.random()*(words.length+1));
        String randomWord = words[randomNum];
        return randomWord;
    }

    //Checks to see if user guess is valid or invalid
    public static boolean checkGuess(char guess, char[] word){
        for (int i = 0; i < word.length; i++){
            if (guess == word[i]){
                return true;
                
            }
        }
        return false;
    }
    // 
    public static char[] updateBoardCorret(char[] correctGuesses, char[] word, char guess){
        
            for (int i = 0; i < word.length ; i++){
                if (word[i] == guess){
                    correctGuesses[i] = guess;
                }
            }
            return correctGuesses;
       

}
    public static char[] updateBoardMiss(int missCounter, char[] misses, char guess){
        misses[missCounter] = guess;
        return misses;

    }

    public static void printBoard(int missCounter, char[] correctGuesses, char[] misses){
            System.out.println(gallows[missCounter]);
        
            System.out.print("\n\n\nWord: ");
            for (int i = 0; i < correctGuesses.length; i++){
                System.out.print("\t" + correctGuesses[i]);
            }
          
            System.out.print("\n\nMisses:  ");
            System.out.print(misses);
    }
}





