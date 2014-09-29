import org.junit.Assert;
import org.junit.Test;

public class ArgentinaInventoryTest {
    @Test
    public void TestThatStockOfIPodsIsHundredByDefault()
    {
        //Given
        ArgentinaInventory argentinaInventory = new ArgentinaInventory();

        //Then
        Assert.assertEquals(100, argentinaInventory.GetStockOfiPods());
    }

    @Test
    public void TestThatPriceOfTenIPodsFromBrazilIsThousand()
    {
        //Given
        int numberOfiPodsToOrder = 10;
        ArgentinaInventory argentinaInventory = new ArgentinaInventory();

        //When
        int priceOfOrder = argentinaInventory.GetPriceForOrder(numberOfiPodsToOrder);

        //Then
        Assert.assertEquals(500,priceOfOrder);
    }

    public void TestThatReduceStockReducesCountOfStock()
    {
        //Given
        ArgentinaInventory argentinaInventory = new ArgentinaInventory();

        //When
        argentinaInventory.ReduceStockCount(10);

        //Then
        Assert.assertEquals(90,argentinaInventory.GetStockOfiPods());
    }

    @Test
    public void TestThatRefillStockIncreasesStockCountToHundred()
    {
        //Given
        ArgentinaInventory argentinaInventory = new ArgentinaInventory();

        //When
        argentinaInventory.ReduceStockCount(10);
        argentinaInventory.RefillStock();

        //Then
        Assert.assertEquals(100,argentinaInventory.GetStockOfiPods());
    }
}
