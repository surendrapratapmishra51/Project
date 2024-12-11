package Project;

import java.util.Scanner;

class Guesser{
    int GuesserNum;
    public int GuessNum(){

        Scanner sc = new Scanner(System.in);
        System.out.println(" Guesser Guess your number");
        GuesserNum = sc.nextInt();
        return  GuesserNum;
    }
}

class Player{
    int PlayerNum;
    public int GuessNum(){
//        System.out.println("Guess your number");
        Scanner sc = new Scanner(System.in);
        PlayerNum = sc.nextInt();
        return  PlayerNum;
    }
}

class Umpire {
    int GuesserNum1;
    int PlayerNum1;
    int PlayerNum2;
    int PlayerNum3;

    public void collectionNumFromGuessur() {
        Guesser G = new Guesser();
        GuesserNum1 = G.GuessNum();
    }
    public void collectNumFromPlayer(){

        Player P1 = new Player();
        System.out.println("Player1 guess your number");
        PlayerNum1 = P1.GuessNum();


        Player P2 = new Player();
        System.out.println("Player2 guess your number");
        PlayerNum2 = P2.GuessNum();


        Player P3 = new Player();
        System.out.println("Player3 guess number");
        PlayerNum3 = P3.GuessNum();
    }
    void comapre(){
        if(GuesserNum1 == PlayerNum1){
            if(GuesserNum1 == PlayerNum2 && GuesserNum1 == PlayerNum3){
                System.out.println("All the Player Won the game");
            }
            else if (GuesserNum1 == PlayerNum2) {
                System.out.println("Player 1 and Player 2 won the Game");
            }
            else if (GuesserNum1 == PlayerNum3) {
                System.out.println("Player 1 and Player 3 won the Game");
            }
            else {
                System.out.println("Player 1  won the Game");
            }
        }
        else if (GuesserNum1 == PlayerNum2) {
                if(GuesserNum1 == PlayerNum3){
                    System.out.println("Player 2 and Player 3 won the Game");
                }
                else{
                    System.out.println("Player 2 won the Game");
                }
        } else if (GuesserNum1 == PlayerNum3) {
            System.out.println("Player 3 won the Game");

        }
        else{
            System.out.println(" All Player Lost The Game");
        }
    }
}




public class GusserGame {
    public static void main(String[] args) {
        System.out.println("----start the Game--------");
        Umpire U = new Umpire();
        U.collectionNumFromGuessur();
        U.collectNumFromPlayer();
        U.comapre();
        System.out.println("-----end the Game-------");
    }

}
