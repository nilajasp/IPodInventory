public class OnlineShop {
    private Inventory brazilInventory;
    private Inventory argentinaInventory;

    public OnlineShop()
    {
        brazilInventory = new Inventory(100);
        argentinaInventory = new Inventory(50);
    }

    public int PlaceOrder(int selectedLocation,int numberOfiPodsToOrder){
        return GetBestPrice(selectedLocation,numberOfiPodsToOrder);
    }

    public int GetStockInBrazil()
    {
        return brazilInventory.GetStockOfiPods();
    }

    public int GetStockInArgentina()
    {
        return argentinaInventory.GetStockOfiPods();
    }

    private int GetBestPrice(int selectedLocation,int numberOfiPodsToOrder){
        if(numberOfiPodsToOrder < 100) {
            int priceOfOrderFromBrazil = brazilInventory.GetPriceForOrder(numberOfiPodsToOrder);
            int priceOfOrderFromArgentina = argentinaInventory.GetPriceForOrder(numberOfiPodsToOrder);

            int shippingCharges = CalculateShippingCharges(numberOfiPodsToOrder);
            if (selectedLocation == 1) {
                priceOfOrderFromArgentina += shippingCharges;
            } else if (selectedLocation == 2) {
                priceOfOrderFromBrazil += shippingCharges;
            }

            if(priceOfOrderFromArgentina > priceOfOrderFromBrazil)
            {
                DispatchOrderFromBrazil(numberOfiPodsToOrder);
                return priceOfOrderFromBrazil;
            } else
            {
                DispatchOrderFromArgentina(numberOfiPodsToOrder);
                return priceOfOrderFromArgentina;
            }
        } else
        {
            int remainingIPods = numberOfiPodsToOrder - 100;
            int priceForFirstHundredIPods = 0;
            int priceForRemainingIPods = 0;
            int shippingChargesForRemainingIPods = CalculateShippingCharges(remainingIPods);
            if (selectedLocation == 1) {
                priceForFirstHundredIPods = brazilInventory.GetPriceForOrder(100);
                priceForRemainingIPods = argentinaInventory.GetPriceForOrder(remainingIPods);
                DispatchOrderFromBrazil(100);
                DispatchOrderFromBrazil(remainingIPods);
            } else if (selectedLocation == 2) {
                priceForFirstHundredIPods = argentinaInventory.GetPriceForOrder(100);
                priceForRemainingIPods = brazilInventory.GetPriceForOrder(remainingIPods);
                DispatchOrderFromBrazil(remainingIPods);
                DispatchOrderFromArgentina(100);
            }
            return priceForFirstHundredIPods + priceForRemainingIPods + shippingChargesForRemainingIPods;
        }
    }

    private void DispatchOrderFromArgentina(int numberOfiPodsToOrder) {
        argentinaInventory.ReduceStockCount(numberOfiPodsToOrder);
    }

    private void DispatchOrderFromBrazil(int numberOfiPodsToOrder) {
        brazilInventory.ReduceStockCount(numberOfiPodsToOrder);
    }

    private int CalculateShippingCharges(int numberOfiPodsToOrder) {
        return (int)Math.ceil(numberOfiPodsToOrder/10.0)*400;
    }

    public void RefillStock() {
        brazilInventory.RefillStock();
        argentinaInventory.RefillStock();
    }
}
