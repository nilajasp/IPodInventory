/**
 * Created by nilajapatankar on 7/28/15.
 */
public class Inventory {
    int stock;
    int priceOfEachiPod;

    public Inventory(int priceOfEachiPod) {
        stock = 100;
        this.priceOfEachiPod = priceOfEachiPod;
    }

    int GetStockOfiPods() {
        return stock;
    }
    int GetPriceForOrder(int numberOfiPodsToOrder) {
        return numberOfiPodsToOrder * priceOfEachiPod;
    }
    void ReduceStockCount(int numberOfiPodsToOrder) {
        stock -= numberOfiPodsToOrder;
    }


    public void RefillStock() {
        stock = 100;
    }
}
