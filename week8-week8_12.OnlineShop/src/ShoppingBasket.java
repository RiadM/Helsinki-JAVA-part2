import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> purchased = new HashMap();

    public ShoppingBasket(){

    }
    public void add(String product, int price){
        //Send the reference to the object in the Map to a new object
        Purchase object = this.purchased.get(product);
        if(object != null){
            //If the object exist we call the method to increase the amount and since it's a ref type it act directly
          object.increaseAmount();
        }else {
            this.purchased.putIfAbsent(product, new Purchase(product, 1, price));
        }
    }

    public int price(){
        int price = 0;
        for(Purchase stuffs: this.purchased.values()){
            price += stuffs.price();
        }
        return price;
    }

    public void print(){
        for(Purchase stuffs: this.purchased.values()){
            System.out.println(stuffs);
        }
    }

}
