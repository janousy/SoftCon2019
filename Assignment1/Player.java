import java.util.Objects;
import java.util.Scanner;

public class Player {

    static int id = 0;
    public String name;
    public int playerid;
    public int position;

    //constructor
    public Player(String playerName) {
        this.position = 1; //are square id starting at 0?
        this.name = playerName;
        this.playerid = id;
        id += 1;
    }

    public void updatePosition(int moveNumber, Square[] squares) {
        this.position = this.position + moveNumber;
        if(squares[this.position-1] instanceof Snake) {
            System.out.println("Your encountered a snake");
            //this.position = squares[this.position].getEnd();
        }
    }

    public void takeTurn(Square[] squares) {
        System.out.println("It is your turn, "+this.name+"!");
        System.out.println("Right now, you're on square "+this.position);
        System.out.println("Press ENTER to roll the die");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int dieNumber = Die.roll();
        System.out.println("The die is showing "+dieNumber);
        this.updatePosition(dieNumber, squares);
        System.out.println("Your new Position: "+this.position);
        System.out.println("--------------Next Player-----------------\n");
    }
}
