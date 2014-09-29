/**
 * Created by nilajapatankar on 9/27/14.
 */
public class ArgentinaInventory {
    int stock;
    int priceOfEachiPod;

    public ArgentinaInventory()
    {
        stock = 100;
        priceOfEachiPod = 50;
    }

    public int GetStockOfiPods() {
        return stock;
    }

    public int GetPriceForOrder(int numberOfiPodsToOrder) {
        return numberOfiPodsToOrder * priceOfEachiPod;
    }

    public void ReduceStockCount(int numberOfiPodsToOrder) {
        stock -= numberOfiPodsToOrder;
    }

    public void RefillStock() {
        stock = 100;
    }
}
