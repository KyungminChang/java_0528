import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class Inventory {
    private HashMap<Integer, Item> items;
    private int itemCounter;

    public Inventory() {
        items = new HashMap<>();
        itemCounter = 1;
    }

    public void addItem(String name, double price, int quantity) {
        items.put(itemCounter, new Item(name, price, quantity));
        System.out.println("Item " + itemCounter + " has been added to the inventory.");
        itemCounter++;
    }

    public void removeItem(int itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            System.out.println("Item " + itemId + " has been removed from the inventory.");
        } else {
            System.out.println("Item " + itemId + " does not exist in the inventory.");
        }
    }

    public void updateItem(int itemId, double price, int quantity) {
        if (items.containsKey(itemId)) {
            Item item = items.get(itemId);
            item.setPrice(price);
            item.setQuantity(quantity);
            System.out.println("Item " + itemId + " has been updated.");
        } else {
            System.out.println("Item " + itemId + " does not exist in the inventory.");
        }
    }

    public void updateStock(int itemId, int quantityChange) {
        if (items.containsKey(itemId)) {
            Item item = items.get(itemId);
            item.setQuantity(item.getQuantity() + quantityChange);
            System.out.println("Item " + itemId + " stock has been updated.");
        } else {
            System.out.println("Item " + itemId + " does not exist in the inventory.");
        }
    }

    public void viewInventory() {
        if (items.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            for (int id : items.keySet()) {
                System.out.println("ID: " + id + ", " + items.get(id));
            }
        }
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        
        System.out.print("Enter userId: ");
        String userId = scanner.nextLine();

        if (!userId.equals("admin")) {
            System.out.println("Access denied. Only admin can access this menu.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. 상품 등록");
            System.out.println("2. 상품 삭제");
            System.out.println("3. 상품 업데이트");
            System.out.println("4. 재고 관리");
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("상품 명: ");
                    String name = scanner.nextLine();
                    System.out.print("가격: ");
                    double price = scanner.nextDouble();
                    System.out.print("수량: ");
                    int quantity = scanner.nextInt();
                    inventory.addItem(name, price, quantity);
                    break;
                case 2:
                    System.out.print("삭제할 상품 번호: ");
                    int removeId = scanner.nextInt();
                    inventory.removeItem(removeId);
                    break;
                case 3:
                    System.out.print("업데이트할 상품 번호: ");
                    int updateId = scanner.nextInt();
                    System.out.print("가격: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("수량: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateItem(updateId, newPrice, newQuantity);
                    break;
                case 4:
                	System.out.println(inventory);
                    System.out.print("재고 추가할 상품 번호: ");
                    int stockId = scanner.nextInt();
                    System.out.print("추가할 갯수: ");
                    int addQuantity = scanner.nextInt();
                    inventory.updateStock(stockId, addQuantity);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}