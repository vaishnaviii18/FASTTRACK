import java.util.Random;
import java.util.Scanner;

class Player {
    private int pos = 0;

    public int getPos() {
        return pos;
    }

    public void setPos(int p) {
        pos = p;
    }
}
class SnakeLadderGame {

    private Random rand = new Random();
    private Scanner sc = new Scanner(System.in);    public int rollDice() {
        return rand.nextInt(6) + 1;   // using + operator
    }

  
    public int checkPosition(int next) {

       
        if (next == 3) next = 22;
        if (next == 15) next = 44;
        if (next == 40) next = 84;

        if (next == 70) next = 30;
        if (next == 90) next = 50;
        if (next == 99) next = 10;

        return next;
    }

    public void playTurn(Player p) {

        System.out.print("\nPress 1 to roll dice: ");
        int in = sc.nextInt();

        if (in != 1) {       
            System.out.println("Invalid! Press 1 only.");
            return;
        }

        int dice = rollDice();
        System.out.println("Dice: " + dice);

        int next = p.getPos() + dice; 

        if (next > 100) {    
            System.out.println("Need exact number to reach 100!");
            return;
        }

        next = checkPosition(next);     
        p.setPos(next);                 
        System.out.println("Current Position: " + p.getPos());
    }
}

public class SnakeLadderOOP {

    public static void main(String[] args) {

        Player player = new Player();
        SnakeLadderGame game = new SnakeLadderGame();

        System.out.println("=== Snake and Ladder (OOP + Operators) ===");

        while (player.getPos() < 100) {   
            game.playTurn(player);
        }

        System.out.println("\n You reached 100! You Win!");
    }
}
