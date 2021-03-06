package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

import java.util.ArrayList;

/**
 * This testclass tests the class DrawPile
 */
public class DrawPileTest {
    DrawPile drawPile1 = new DrawPile();

    @Before
    public void setup(){
        DrawPile drawPile = new DrawPile();
    }


    /**
     * This test checks if the length of the pile equals nrOfCards
     */
    @Test
    public void nrOfCards(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
            add(new NumberCard("green",8));
            add(new NumberCard("red",7));
        }};

        drawPile1.addCards(drawPile);

        Assert.assertEquals(drawPile.size(), drawPile1.getNrOfCards());
    }
    /**
     * this test checks if the method isEmpty returns true if drawpile is empty
     */
    @Test
    public void isEmpty(){
        Assert.assertTrue(drawPile1.isEmpty());

        ArrayList<Cards> drawPileToAdd = new ArrayList<>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
        }};

        drawPile1.addCards(drawPileToAdd);
        Assert.assertFalse(drawPile1.isEmpty());
    }

    /**
     * this test checks if addCards() and removeCard() work
     */
    @Test
    public void removeCardWorks(){
        ArrayList<Cards> newCards = new ArrayList<>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
            add(new NumberCard("green",8));
            add(new NumberCard("red",7));
        }};

        drawPile1.addCards(newCards);
        Assert.assertEquals(4, drawPile1.getNrOfCards());

        Cards card = drawPile1.removeCard();

        Cards expected = new NumberCard("blue",5);

        Assert.assertEquals(expected, card);
        Assert.assertEquals(3, drawPile1.getNrOfCards());

    }



    /**
     * This test checks if the pile has same length after shuffling
     */
    @Test
    public void shuffle(){
        ArrayList<Cards> drawPile = new ArrayList<Cards>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
            add(new NumberCard("green",8));
            add(new NumberCard("red",7));
        }};

        drawPile1.addCards(drawPile);
        drawPile1.shuffle();

        Assert.assertEquals(4, drawPile1.getNrOfCards());

    }


    /**
     * this test checks if multiple cards can be removed from pile
     */
    @Test
    public void removeMultipleCards(){
        ArrayList<Cards> drawPile = new ArrayList<>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
            add(new NumberCard("green",8));
            add(new NumberCard("red",7));
        }};

        drawPile1.addCards(drawPile);

        Cards c1 = drawPile1.removeCard();
        Cards c2 = drawPile1.removeCard();
        Cards c3 = drawPile1.removeCard();

        Cards expected = new NumberCard("green",9);

        Assert.assertEquals(1, drawPile1.getNrOfCards());
        Assert.assertEquals(expected, c3);
    }


    /**
     * This test checks if the pile is empty after removing all cards
     */
    @Test
    public void isEmptyRemove(){
        ArrayList<Cards> drawPile = new ArrayList<Cards>() {{
            add(new NumberCard("blue",5));
            add(new NumberCard("blue",9));
            add(new NumberCard("green",8));
            add(new NumberCard("red",7));
        }};

        drawPile1.addCards(drawPile);

        Cards c1 = drawPile1.removeCard();
        Cards c2 = drawPile1.removeCard();
        Cards c3 = drawPile1.removeCard();
        Cards c4 = drawPile1.removeCard();


        Assert.assertEquals(0, drawPile1.getNrOfCards());
        Assert.assertTrue(drawPile1.isEmpty());
    }
}
