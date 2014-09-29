import org.junit.Assert;
import org.junit.Test;

public class OnlineShopTest {
    @Test
    public void TestThatInventoryReturnsCorrectPriceWhenOrderIsPlacedToBrazilForTenIPods(){
        //Given
        int numberOfiPodsToOrder = 10;
        int selectedLocation = 1;
        OnlineShop onlineShop = new OnlineShop();

        //When
        int price = onlineShop.PlaceOrder(selectedLocation,numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(900,price);
    }

    @Test
    public void TestThatInventoryReturnsCorrectPriceWhenOrderIsPlacedToArgentinaForTenIPods(){
        //Given
        int numberOfiPodsToOrder = 10;
        int selectedLocation = 2;
        OnlineShop onlineShop = new OnlineShop();

        //When
        int price = onlineShop.PlaceOrder(selectedLocation,numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(500,price);
    }

    @Test
    public void TestThatInventoryReturnsCorrectPriceWhenOrderIsPlacedToArgentinaForMoreThanHundredIPods(){
        //Given
        int numberOfiPodsToOrder = 120;
        int selectedLocation = 2;
        OnlineShop onlineShop = new OnlineShop();

        //When
        int price = onlineShop.PlaceOrder(selectedLocation,numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(7800,price);
    }

    @Test
    public void TestThatInventoryStocksAreReturnedByGetStock(){
        //Given
        OnlineShop onlineShop = new OnlineShop();

        //When
        int stockInBrazil = onlineShop.GetStockInBrazil();
        int stockInArgentina = onlineShop.GetStockInArgentina();

        //Then
        Assert.assertEquals(100,stockInBrazil);
        Assert.assertEquals(100,stockInArgentina);
    }
}