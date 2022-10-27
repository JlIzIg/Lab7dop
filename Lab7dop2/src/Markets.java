import java.io.Serializable;
import java.util.ArrayList;

public class Markets implements Serializable {
    private static final long serialVersionUD = 1L;

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }

    ArrayList<Market> markets;

    /**
     * метод возвращающий количество товаров проданных данным продавцом и количество типов
     **/
    public int[] getInfoNumberOfSellingProducts(String salesman) {
        int N = 0;
        int quantity = 0;
        for (int i = 0; i < this.markets.size(); i++) {
            if (this.markets.get(i).getSalesman().equals(salesman)) {
                quantity += this.markets.get(i).getQuantity();
                N++;
            }
        }
        int[] arr = {quantity, N};
        return arr;
    }

    public void add(Market market) {
        markets.add(market);
    }

    /**
     * Метод возвращающий список проданных товаров данным продавцом
     **/
    public ArrayList<Market> getSoldProducts(String salesman) {
        int size = getInfoNumberOfSellingProducts(salesman)[1];
        ArrayList<Market> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < this.markets.size(); j++) {
                if (this.markets.get(j).getSalesman().equals(salesman)) {
                    arr.add(markets.get(j));
                    i++;
                }
            }
        }
        return arr;
    }

    /**
     * Метод выводящий информацию о самом дорогом товаре, проданным данным продавцом
     **/
    public String getExpensiveProd(String salesman) {
        ArrayList<Market> arr = getSoldProducts(salesman);
        arr.sort(Market.byPrice);
        String str = "\n " + arr.get(0).toString();
        return str;
    }


}
