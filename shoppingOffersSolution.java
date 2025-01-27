import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class shoppingOffersSolution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> memo = new HashMap<>();
        return helper(price, special, needs, memo);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<List<Integer>, Integer> memo) {
        
        if(memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int local_min = directPurchase(price, needs);

        for(int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<>();

            for(int j = 0; j < needs.size(); j++) {
                if(needs.get(j) < offer.get(j)) {
                    temp = null;
                    break;
                }

                temp.add(needs.get(j) - offer.get(j));
            }
            
            if(temp != null)
            local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, memo));
        }

        memo.put(needs, local_min);
        return local_min;
    }

    public int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;

        for(int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}