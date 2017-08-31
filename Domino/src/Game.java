/**
 * Created by BeauKujath on 29/08/2017.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    public static final int TILES = 7;
    private  Player player1;
    private Player player2;
    private ArrayList<Domino> pieces = new ArrayList<Domino>();
    private ArrayList<Domino> boneyard = new ArrayList<Domino>();
    private boolean isOver = false;
    private ArrayList<Domino> top = new ArrayList<Domino>();
    private ArrayList<Domino> bottom = new ArrayList<Domino>();


    public Game()
    {
        createPieces();
        Collections.shuffle(pieces);
        printDoms(pieces);
        fillBoneyard();
        ArrayList<Domino> hand1 = fillHand(TILES * 2);
        ArrayList<Domino> hand2 = fillHand(TILES * 3);
        this.player1 = new Player("some_guy", hand1) ;
        this.player2 = new Player("other_guy",hand2 );

    }

    public Player getPlayer1()
    {
        return player1;
    }

    public void createPieces()
    {
        int rowCount = 0;
        while (rowCount < TILES){
            for (int i = 0; i <= rowCount; i ++){
                Domino dom = new Domino(i, rowCount);
                pieces.add(dom);
            }
            rowCount ++;
        }
        Domino lastDom = new Domino(6,6);
        pieces.add(lastDom);

    }

    public void fillBoneyard()
    {
        for (int j = 0; j < (TILES * 2) + 1; j ++){
            Domino dommer = pieces.get(j);
            boneyard.add(dommer);
        }
    }

    public ArrayList<Domino> fillHand(int start)
    {
        ArrayList<Domino> someHand = new ArrayList<Domino>();

        for (int k = start; k < start + TILES; k++){
            Domino someDom = pieces.get(k);
            someHand.add(someDom);
        }

        return someHand;

    }


    public void printDoms(ArrayList<Domino> someDoms)
    {
        for (int j = 0; j < someDoms.size(); j ++ ){
            System.out.println("dom at index (" + j +") is : " + someDoms.get(j));
        }
    }

    public void placeDomino(Domino dommy, int row, int side)
    {
        if (side == 0) {
            if (row == 1){
                top.add(dommy);
            }
            if (row == 2){
                bottom.add(dommy);
            }
        } else {
            if (row == 1){
                top.add(0, dommy);
            }
            if (row == 2){
                bottom.add(0, dommy);
            }
        }

    }

    public void printBoard()
    {
        System.out.println("\n\n\n**************************************\n");;
        for (int j = 0; j < top.size(); j ++){
            System.out.print(top.get(j).toString());
        }
        System.out.println("\n");
        for (int k = 0; k < bottom.size(); k ++){
            System.out.print(bottom.get(k).toString());
        }
        System.out.println("\n\n**************************************\n\n\n");;
    }



    public Player getPlayer2()
    {
        return player2;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public boolean isOver() {

        return isOver;
    }
}
