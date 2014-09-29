import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select from where you want to order :\n1. Brazil\n2. Argentina");
        int selectedLocation = sc.nextInt();

        if (selectedLocation != 1 && selectedLocation != 2) {
            System.out.println("Your location selection is wrong");
        } else {
            System.out.println("Enter number of iPods you want to order (Multiples of 10):");
            int numberOfiPodsOrdered = sc.nextInt();

            if(numberOfiPodsOrdered > 200 )
            {
                System.out.println("Out of stock");
            } else {
                OnlineShop shop = new OnlineShop();

                System.out.println("Price of your order : " + shop.PlaceOrder(selectedLocation, numberOfiPodsOrdered));
                System.out.println("Stock in Brazil : " + shop.GetStockInBrazil());
                System.out.println("Stock in Argentina : " + shop.GetStockInArgentina());

                shop.RefillStock();

                System.out.println("Stock refilled");
                System.out.println("Stock in Brazil : " + shop.GetStockInBrazil());
                System.out.println("Stock in Argentina : " + shop.GetStockInArgentina());
            }
        }
    }
}
