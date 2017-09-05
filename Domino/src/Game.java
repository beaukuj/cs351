/**
 * Created by BeauKujath on 29/08/2017.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    public static final int TILES = 7;
    private Player player1;
    private Player player2;
    private ArrayList<Domino> pieces = new ArrayList<Domino>();
    private ArrayList<Domino> boneyard = new ArrayList<Domino>();
    private ArrayList<Domino> top = new ArrayList<Domino>();
    private ArrayList<Domino> bottom = new ArrayList<Domino>();
    private Player current;
    private boolean isOver = false;

    public Game(Player player1, Player player2)
    {
        createPieces();
        Collections.shuffle(pieces);
        fillBoneyard();
        this.player1 = player1;
        this.player2 = player2;
        this.current = player1;
        player1.setHand(fillHand(TILES * 2));
        player2.setHand(fillHand(TILES * 3));
    }

    public Player getPlayer1()
    {
        return player1;
    }

    public Player getPlayer2()
    {
        return player2;
    }

    public void setOver(boolean over)
    {
        isOver = over;
    }

    public void createPieces()
    {
        int rowCount = 0;
        while (rowCount < TILES)
        {
            for (int i = 0; i <= rowCount; i++)
            {
                Domino dom = new Domino(i, rowCount);
                pieces.add(dom);
            }
            rowCount++;
        }
        Domino lastDom = new Domino(6, 6);
        pieces.add(lastDom);

    }

    public void fillBoneyard()
    {
        for (int j = 0; j < (TILES * 2) + 1; j++)
        {
            Domino dommer = pieces.get(j);
            boneyard.add(dommer);
        }
    }

    public ArrayList<Domino> fillHand(int start)
    {
        ArrayList<Domino> someHand = new ArrayList<Domino>();

        for (int k = start; k < start + TILES; k++)
        {
            Domino someDom = pieces.get(k);
            someHand.add(someDom);
        }

        return someHand;

    }


    public void printDoms(ArrayList<Domino> someDoms)
    {
        for (int j = 0; j < someDoms.size(); j++)
        {
            System.out.println("dom at index (" + j + ") is : " + someDoms.get(j));
        }
    }

    public void placeDomino(Domino dommy, int row, int side)
    {
        if (side == 0)
        {
            if (row == 1)
            {
                top.add(dommy);
            }
            if (row == 2)
            {
                bottom.add(dommy);
            }
        } else
        {
            if (row == 1)
            {
                top.add(0, dommy);
            }
            if (row == 2)
            {
                bottom.add(0, dommy);
            }
        }

    }

    public void printBoard()
    {
        System.out.println("\n\n\n**************************************\n");
        ;
        for (int j = 0; j < top.size(); j++)
        {
            System.out.print(top.get(j).toString());
        }
        System.out.print("\n");
        for (int k = 0; k < bottom.size(); k++)
        {
            if (k == 0){
                System.out.print("   ");
            }
            System.out.print(bottom.get(k).toString());
        }
        System.out.println("\n\n**************************************\n\n\n");
        ;
    }


    public boolean isOver()
    {

        return isOver;
    }

    public Player getCurrent()
    {
        return current;
    }

    public Domino drawFromYard()
    {
        Domino found = boneyard.get(boneyard.size() - 1);
        boneyard.remove(boneyard.size() - 1);
        return found;
    }


    public void switchPlayer()
    {
        if (current == player1)
        {
            current = player2;
        } else
        {
            current = player1;
        }
    }
}
