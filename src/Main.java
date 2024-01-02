import ericarnou68.entities.Client;
import ericarnou68.entities.Order;
import ericarnou68.entities.OrderItem;
import ericarnou68.entities.Product;
import ericarnou68.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String clientName = scanner.nextLine();
        System.out.print("e-mail: ");
        String clientEmail = scanner.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirthDate  = sdf.parse(scanner.next());

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        scanner.nextLine();
        String status = scanner.nextLine();
        System.out.print("How many items to this order? ");
        int itemsQuantities = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(LocalDate.now(), OrderStatus.valueOf(status), client);

        for (int i = 0; i < itemsQuantities; i++) {
            System.out.println("Enter #"+ (i+1) +" item data: ");

            System.out.print("Product name: ");
            String productName = scanner.nextLine();
            System.out.print("Product price: ");
            Double productPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(quantity,product);

            order.addItem(orderItem);
        }

        System.out.println(order);


    }
}