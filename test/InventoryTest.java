import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 7/28/15.
 */
public class InventoryTest {
    @Test
    public void TestThatStockOfIPodsIsHundredByDefault() {
        //Given
        Inventory inventory = new Inventory(50);

        //Then
        Assert.assertEquals(100, inventory.GetStockOfiPods());
    }

    @Test
    public void TestThatPriceOfTenIPodsFromBrazilIsThousand() {
        //Given
        int numberOfiPodsToOrder = 10;
        Inventory inventory = new Inventory(100);

        //When
        int priceOfOrder = inventory.GetPriceForOrder(numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(1000, priceOfOrder);
    }

    @Test
    public void TestThatPriceOfTenIPodsFromargentinaIsFiveHundred() {
        //Given
        int numberOfiPodsToOrder = 10;
        Inventory inventory = new Inventory(50);

        //When
        int priceOfOrder = inventory.GetPriceForOrder(numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(500, priceOfOrder);
    }

    @Test
    public void TestThatReduceStockReducesCountOfStock() {
        //Given
        Inventory inventory = new Inventory(50);

        //When
        inventory.ReduceStockCount(10);

        //Then
        Assert.assertEquals(90, inventory.GetStockOfiPods());
    }

    @Test
    public void TestThatRefillStockIncreasesStockCountToHundred() {
        //Given
        Inventory inventory = new Inventory(50);

        //When
        inventory.ReduceStockCount(10);
        inventory.RefillStock();

        //Then
        Assert.assertEquals(100, inventory.GetStockOfiPods());
    }
}
