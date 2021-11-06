import java.util.Arrays;
import java.util.Scanner;
public class Solution
{

    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        Item[] itms = new Item[4];
        for(int i=0;i<4;i++){
            int itemId = sc.nextInt();
            sc.nextLine();
            String itemName = sc.nextLine();
            String itemType = sc.nextLine();
            double itemPrice = sc.nextDouble();
            itms[i] = new Item(itemId,itemName,itemType,itemPrice);
        }
        sc.nextLine();
        String type = sc.nextLine();
        String name = sc.nextLine();
        int res = findAvgItemPriceByType(itms,type);
        if(res!=0) {
            System.out.println(res);
        }else{
            System.out.println("There are no items with given type");
        }
        Item[] obj = searchItemByName(itms,name);
        if(obj != null) {
            int[] arr = new int[obj.length];
            int a=0;
            for (Item item : obj) {
                arr[a++] = item.getItemId();
            }
            Arrays.sort(arr);
            for(int i=0;i<a;i++){
                System.out.println(arr[i]);
            }
        }else{
            System.out.println("There are no items with the given name");
        }
    }
    public static int findAvgItemPriceByType(Item[] items, String type1){
        double avg=0;
        int count=0;
        double price=0;
        for(int i=0;i<4;i++){
            if(items[i].getItemType().equalsIgnoreCase(type1)){
                price+=items[i].getItemPrice();
                count+=1;
            }
        }
        avg = price/count;
        return (int)avg;
    }
    public static Item[] searchItemByName(Item[] items, String Name1){
        int count=0,k=0;
        for(int i=0;i<4;i++){
            if(items[i].getItemName().equalsIgnoreCase(Name1)){
                count++;
            }
        }
        if(count>0) {
            Item[] obj = new Item[count];
            for(int i=0;i<4;i++){
                if(items[i].getItemName().equalsIgnoreCase(Name1)){
                    obj[k++] = items[i];
                }
            }
            return obj;
        }else {
            return null;
        }
    }
}

class Item{
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    int itemId;
    String itemName;
    String itemType;
    double itemPrice;
    public Item(int itemId, String itemName, String itemType, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
    }
}