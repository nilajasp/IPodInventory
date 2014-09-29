import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 9/27/14.
 */
public class BrazilInventoryTest {
    @Test
    public void TestThatStockOfIPodsIsHundredByDefault()
    {
        //Given
        BrazilInventory brazilInventory = new BrazilInventory();

        //Then
        Assert.assertEquals(100,brazilInventory.GetStockOfiPods());
    }

    @Test
    public void TestThatPriceOfTenIPodsFromBrazilIsThousand()
    {
        //Given
        int numberOfiPodsToOrder = 10;
        BrazilInventory brazilInventory = new BrazilInventory();

        //When
        int priceOfOrder = brazilInventory.GetPriceForOrder(numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(1000,priceOfOrder);
    }

    @Test
    public void TestThatReduceStockReducesCountOfStock()
    {
        //Given
        BrazilInventory brazilInventory = new BrazilInventory();

        //When
        brazilInventory.ReduceStockCount(10);

        //Then
        Assert.assertEquals(90,brazilInventory.GetStockOfiPods());
    }

    @Test
    public void TestThatRefillStockIncreasesStockCountToHundred()
    {
        //Given
        BrazilInventory brazilInventory = new BrazilInventory();

        //When
        brazilInventory.ReduceStockCount(10);
        brazilInventory.RefillStock();

        //Then
        Assert.assertEquals(100,brazilInventory.GetStockOfiPods());
    }
}
