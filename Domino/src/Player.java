import java.util.ArrayList;

/**
 * Created by BeauKujath on 29/08/2017.
 */
public class Player
{
    private String name;
    private ArrayList<Domino> hand = new ArrayList<Domino>();

    public Player(String name) {
        this.name = name;
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
        System.out.println("(" + hand.size() + "):" + " Pick from boneyard");
    }

    public void setHand(ArrayList<Domino> hand)
    {
        this.hand = hand;
    }

    public void removeDom(int index){
        hand.remove(index);
    }
    public void addDom(Domino dom){
        hand.add(dom);
    }

}
