/**
 * Created by BeauKujath on 29/08/2017.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller
{

    public static void takeTurn(Game game, Player currentPlayer)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Pick from your hand " + currentPlayer.getName() + ":");
        currentPlayer.printHand();
        int n = -1;
        try {
            n = reader.nextInt();
        } catch (InputMismatchException ex){
            System.out.println("Invalid number.");
        }

        if (n > currentPlayer.getHand().size() || n < 0)
        {
            System.out.println("Sorry not a valid dominooo.");
        } else
        {
            Domino chosenOne = currentPlayer.getHand().get(n);
            currentPlayer.removeDom(n);
            System.out.println("You chose: " + chosenOne.toString());
            System.out.println("Which row do you want to play at? (1 or 2)");
            int row = -1;
            try {
                row = reader.nextInt();
            } catch (InputMismatchException ex){
                System.out.println("Invalid row input.");
            }

            if (row != 1 && row != 2)
            {
                System.out.println("Sorry not a row. ");
            } else
            {
                System.out.println("You chose row number: " + row);
                System.out.println("Would you like to flip the domino?  ");
                System.out.println("y/n ?");
                char answer = reader.next().charAt(0);

                if (answer != 'y' && answer != 'n')
                {
                    System.out.println("Sorry invalid answer");
                } else
                {
                    if (answer == 'y')
                    {
                        System.out.println("dom before flip: " + chosenOne.toString());
                        chosenOne.flip();
                        System.out.println("dom after flip: " + chosenOne.toString());
                    }
                    System.out.println("Which side would you like to place on? (l/r)");
                    char side = reader.next().charAt(0);
                    if (side != 'r' && side != 'l')
                    {
                        System.out.println("Error not a proper side");
                    } else
                    {
                        if (side == 'r')
                        {
                            game.placeDomino(chosenOne, row, 0);
                        } else
                        {
                            game.placeDomino(chosenOne, row, 1);
                        }
                    }

                    System.out.println("\n\n\n\n");
                    System.out.println("board after move: ");
                    game.printBoard();
                }
            }
        }
    }


    public static void main(String[] args)
    {

        Game game = new Game();
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        Player currentPlayer = player1;

        System.out.println("Game has started");
        System.out.println("Player 1 name: " + player1.getName());
        System.out.println("Player 2 name: " + player2.getName());
        System.out.println("\n\n\n\n");

        while (game.isOver() == false)
        {
            takeTurn(game, currentPlayer);
            if (currentPlayer == player1)
            {
                currentPlayer = player2;
            } else
            {
                currentPlayer = player1;
            }

        }

    }


}
