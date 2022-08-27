import java.util.*;
//猜數字
//依照提示猜到數字
//每次結束時會詢問是否要繼續
//結束遊戲時會依之前紀錄作出統計
public class work5 {
    public static void main(String[] args) {
        intro();
        Scanner console = new Scanner(System.in);
        int totalGuess = 0;
        int totalGame = 1;
        int minNum = 1;
        totalGuess = game(console);
        minNum = totalGuess;
        char ans = console.next().toLowerCase().charAt(0);
        while(ans == 'y'){
            int newguess = game(console);
            totalGuess += newguess;
            ans = console.next().toLowerCase().charAt(0);
            if(minNum > newguess) {
                minNum = newguess;
            }
            totalGame++;
        }
        outcome(totalGame, totalGuess, minNum);
    }
    public static void  intro(){
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and ");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it.  For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }
    public static int game(Scanner console) {
        int guessTime = 1;
        Random r = new Random();
        System.out.println("");
        System.out.println("I'm thinking of a number between 1 and 100...");
        int guessAns = r.nextInt(100) + 1;
        System.out.print("Your guess? ");
        int myAns = console.nextInt();
        while (guessAns != myAns) {
            if(guessAns < myAns){
                System.out.println("It's lower.");
                guessTime++;
            }
            else if (guessAns > myAns) {
                System.out.println("It's higher.");
                guessTime++;
            }
            System.out.print("Your guess? ");
            myAns = console.nextInt();
        }
        System.out.println("You got it right in " + guessTime +" guesses");
        System.out.print("Do you want to play again? ");
        return guessTime;
    }
    //統計玩的次數及猜的數據
    public static void outcome(int totalGame, int totalGuesses, int bestGame) {
        System.out.println("");
        System.out.println("Overall results:");
        System.out.println("  total games   = " + totalGame);
        System.out.println("  total guesses = " + totalGuesses);
        System.out.println("  guesses/game  = " + (float)Math.round(totalGuesses / totalGame * 100) / 100);
        System.out.println("  best game     = " + bestGame);
    }
}