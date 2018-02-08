import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Hand implements Comparable<Hand>{

    private List<Card> cardInHand = new ArrayList();

    public void add(Card card){
        this.cardInHand.add(card);
    }

    public void print(){
        for(Card card: this.cardInHand){
            System.out.println(card);
        }
    }

    public void sort(){
        int size = this.cardInHand.size();
        Card swap;

        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
               if(this.cardInHand.get(i).compareTo(this.cardInHand.get(j)) > 0){
                  swap = this.cardInHand.get(j);
                  this.cardInHand.set(j,this.cardInHand.get(i));
                  this.cardInHand.set(i,swap);
               }
            }
        }
    }

    public void sortAgainstSuit(){
        this.sort();
        int size = this.cardInHand.size();
        Card swap;
        SortAgainstSuitAndValue suit = new SortAgainstSuitAndValue();
        for(int i = 0; i < size; i++ ){
            for(int j = i+1; j < size; j++){
                if(suit.compare(this.cardInHand.get(i), this.cardInHand.get(j)) > 0){
                    swap = this.cardInHand.get(j);
                    this.cardInHand.set(j,this.cardInHand.get(i));
                    this.cardInHand.set(i,swap);
                }
            }
        }
    }

    public int compareTo(Hand hand){
        int sum1 = 0;
        int sum2 = 0;

        hand.sort();
        this.sort();

        for(int i = 0 ; i < this.cardInHand.size(); i++){
            Card card = this.cardInHand.get(i);
           sum1 += card.getValue();
        }
        for(int i = 0 ; i < hand.cardInHand.size(); i++){
            Card card = hand.cardInHand.get(i);
            sum2 += card.getValue();
        }

        return sum1 - sum2;

    }
}
