import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String,Integer> productStocked = new HashMap();
    private Map<String, Integer> productStockedPrice = new HashMap();


    public Set<String> products(){
        Set<String> product = new HashSet(productStocked.keySet());
        return product;
    }


    public void addProduct(String product, int price, int stock){
       this.productStocked.put(product,stock);
       this.productStockedPrice.put(product,price);
    }

    public int price(String product){
        if(productStockedPrice.get(product) == null){
            return -99;
        } else{
            return productStockedPrice.get(product);
        }
    }

    public int stock(String product){
        if(this.productStocked.get(product) != null){
            return this.productStocked.get(product);
        }else {
            return 0;
        }
    }

    public boolean take(String product){

        if(this.productStocked.get(product) != null){
            int stockLeft = stock(product);
            if(stockLeft != 0){
                this.productStocked.replace(product,stockLeft-1);
                return true;
            }
        }
        return false ;
    }

}
