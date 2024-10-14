import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();

        int die1 = 0;
        int die2 = 0;
        int roll = 0;
        int point = 0;
        String playAgainYN = "";
        boolean done = false;

        do {
            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            roll = die1 + die2;
            System.out.println("Dice roll is: " + die1 + " and " + die2);
            System.out.println("-----------------------------------");
            System.out.println("Total = " + roll);

            if (roll == 7 || roll == 11)
            {
                System.out.println("You got a natural you win!");
            }
            else if (roll == 2 || roll == 3 || roll == 12)
            {
                System.out.println("You crapped out, try again!");
            }
            else
            {
                point = die1 + die2;
                System.out.println("Point: " + point + ", keep trying for the point!");
                do {
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    roll = die1 + die2;
                    System.out.println("Next roll was: " + die1 + " and " + die2 + ", total = " + roll);
                    if (roll == point)
                    {
                        System.out.println("You got the point, you win!");
                        continue;
                    }
                    else if (roll == 7)
                    {
                        System.out.println("You crapped out, try again!");
                        continue;
                    }
                    else
                    {
                        System.out.println("You didn't get the point nor crapped out, try again!");
                    }

                }while (!(roll == point || roll == 7));
            }

            System.out.println("Do you want to play again?: [YN]");
            if (in.hasNext()) {
                playAgainYN = in.nextLine();
                if (playAgainYN.equalsIgnoreCase("y"))
                {
                    done = false;
                }
                else {
                    done = true;
                }
            }
        }while (!done);
    }
}
