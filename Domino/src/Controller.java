/**
 * Created by BeauKujath on 29/08/2017.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller
{

    public static void takeTurn(Game game, Player currentPlayer)
    {
        int chosen = chooseDom(currentPlayer);
        while (chosen == -1){
            chosen = chooseDom(currentPlayer);
        }
        Domino chosenOne;
        if (chosen == currentPlayer.getHand().size()){
            System.out.println("picking from boneyard");
            chosenOne = game.drawFromYard();
            currentPlayer.addDom(chosenOne);
            System.out.println("You chose: " + chosenOne.toString());
            currentPlayer.printHand();
        } else {
            chosenOne = currentPlayer.getHand().get(chosen);
            currentPlayer.removeDom(chosen);
            System.out.println("You chose: " + chosenOne.toString());
        }


        int row = getRow();
        while (row == -1)
        {
            row = getRow();
        }
        System.out.println("You chose row number: " + row);

        int flipped = shouldFlip(chosenOne);
        while (flipped == -1)
        {
            flipped = shouldFlip(chosenOne);
        }

        int side = whichSide();
        while (side == -1 ){
            side = whichSide();
        }

        game.placeDomino(chosenOne, row, side);

        System.out.println("\n\n\n\n");
        System.out.println("board after move: ");
        game.printBoard();
        game.switchPlayer();
    }

    public static int chooseDom(Player currentPlayer) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Pick from your hand " + currentPlayer.getName() + ":");
        currentPlayer.printHand();
        int result = -1;

        try {
            int num = reader.nextInt();
            if (num > currentPlayer.getHand().size() || num < 0)
            {
                System.out.println("Sorry not a valid dominooo.");
            } else {
                result = num;
            }
        } catch (InputMismatchException ex){
            System.out.println("Invalid domino chosen. ");
        }
        return result;
    }

    public static int getRow()
    {
        System.out.println("Which row do you want to play at? (1 or 2)");
        Scanner reader = new Scanner(System.in);
        int row = -1;
        try
        {
            row = reader.nextInt();
            if (row != 1 && row != 2)
            {
                System.out.println("Sorry not a row num.");
                row = -1;
            }

        } catch (InputMismatchException ex)
        {
            System.out.println("Invalid row input.");
        }

        return row;
    }

    public static int shouldFlip(Domino dom)
    {
        System.out.println("Would you like to flip the domino?  ");
        System.out.println("y/n ?");
        int status = -1;
        Scanner reader = new Scanner(System.in);
        char answer;
        try
        {
            answer = reader.next().charAt(0);
            if (answer != 'y' && answer != 'n')
            {
                System.out.println("Sorry invalid answer number.");
            } else
            {
                if (answer == 'y')
                {
                    dom.flip();
                    System.out.println("Domino is now: " + dom.toString());
                }
                status = 1;
            }
        } catch (InputMismatchException ex)
        {
            System.out.println("Sorry not a valid answer.");
        }
        return status;
    }

    public static int whichSide(){

        Scanner reader = new Scanner(System.in);
        System.out.println("Which side would you like to place on? (l/r)");

        int result = -1;
        try {
            char side = reader.next().charAt(0);
            if (side != 'l' && side != 'r') {
                System.out.println("Sorry not a valid size char. ");
            } else {
                if (side == 'l') {
                    result = 1;
                } else {
                    result = 0;
                }
            }

        } catch (InputMismatchException ex){
            System.out.println("Sorry not a valid side.");
        }

        return result;
    }




    public static void main(String[] args)
    {
        Player firstPlayer = new Player("first_guy");
        Player secondPlayer = new Player("second_guy");
        Game game = new Game(firstPlayer, secondPlayer);
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        System.out.println("Game has started");
        System.out.println("Player 1 name: " + player1.getName());
        System.out.println("Player 2 name: " + player2.getName());
        System.out.println("\n\n\n\n");

        while (game.isOver() == false)
        {
            takeTurn(game, game.getCurrent());
        }

    }


}
