import java.util.ArrayList;

/**
 * Created by BeauKujath on 29/08/2017.
 */
public class Player
{
    private String name;
    private ArrayList<Domino> hand = new ArrayList<Domino>();

    public Player(String name, ArrayList<Domino> hand1) {
        this.name = name;
        this.hand = hand1;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Domino> getHand() {
        return hand;
    }

    public void printHand() {
        for (int i = 0; i < hand.size(); i ++){
            System.out.println("(" + i + "): " + hand.get(i).toString());
        }
    }

    public void removeDom(int index){
        hand.remove(index);
    }
}
