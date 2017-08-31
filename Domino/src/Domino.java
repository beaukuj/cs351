/**
 * Created by BeauKujath on 29/08/2017.
 */
public class Domino
{
    private Integer sideOne;
    private Integer sideTwo;

    public Domino(Integer sideOne, Integer sideTwo)
    {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }


    public void flip() {
        int temp = sideOne;
        sideOne = sideTwo;
        sideTwo = temp;
    }

    @Override
    public String toString() {
        return "[" + sideOne +
                ", " + sideTwo +
                ']';
    }

}
