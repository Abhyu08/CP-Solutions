import java.util.*;
import java.lang.*;
import java.io.*;

class TravelAgencies {
    private int regNo;
    private int price;
    private int rating;
    private String agencyName;
    private String pakageType;
    private String location;

    TravelAgencies(int regNo, int price, int rating, String agencyName, String pakageType, String location) {
        this.regNo = regNo;
        this.price = price;
        this.rating = rating;
        this.location = location;
        this.agencyName = agencyName;
        this.pakageType = pakageType;

    }

    // ------------------------------getter and setters of travel agencies.
    void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    void setprice(int price) {
        this.price = price;
    }

    void setrating(int rating) {
        this.rating = rating;
    }

    void setagencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    void setpakageType(String pakageType) {
        this.pakageType = pakageType;
    }

    void setlocation(String location) {
        this.location = location;
    }

    int getRegNo() {
        return regNo;
    }

    int getPrice() {
        return price;
    }

    int getRating() {
        return rating;
    }

    String getAgencyName() {
        return agencyName;
    }

    String getPakageType() {
        return pakageType;
    }

    String getLocation() {
        return location;
    }


}

public class Solution {
    static int findAgencyWithHighestPackagePrice(TravelAgencies[] travelAgencies, String location) {
        int highest_price = 0;
        for (int i = 0; i < travelAgencies.length; i++) {
            if (travelAgencies[i].getLocation().equalsIgnoreCase(location)) {
                if (highest_price < travelAgencies[i].getPrice()) {
                    highest_price = travelAgencies[i].getPrice();
                }
            }
        }
        return highest_price;
    }

    static TravelAgencies[] sortedAgencyDetailsByPckg(TravelAgencies[] travelAgencies, String Pakagetype) {
        int count = 0;
        for (int i = 0; i < travelAgencies.length; i++)
            if (travelAgencies[i].getPakageType().equalsIgnoreCase(Pakagetype))
                count++;
            if(count == 0)
                return null;
        TravelAgencies[] travelagencies = new TravelAgencies[count];
        count = 0;
        for (int i = 0; i < travelAgencies.length; i++) {
            if (travelAgencies[i].getPakageType().equalsIgnoreCase(Pakagetype))
                travelagencies[count++] = travelAgencies[i];
        }
        for (int i = 0; i < travelagencies.length - 1; i++)
            for (int j = i + 1; j < travelagencies.length; j++) {
                if (travelagencies[i].getRating() > travelagencies[j].getRating()) {
                    TravelAgencies temp = travelagencies[i];
                    travelagencies[i] = travelagencies[j];
                    travelagencies[j] = temp;
                }
            }
        return travelagencies;
    }

    public static void main(String[] args) {

        int regNo;
        int price;
        int rating;
        String agencyName;
        String pakageType;
        String location;
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] TA = new TravelAgencies[4];

        for (int i = 0; i < 4; i++) {
            regNo = sc.nextInt();
            sc.nextLine();
            agencyName = sc.nextLine();
            pakageType = sc.nextLine();
            price = sc.nextInt();
            sc.nextLine();
            rating = sc.nextInt();
            sc.nextLine();
            location = sc.nextLine();
            TA[i] = new TravelAgencies(regNo, price, rating, agencyName, pakageType, location);
        }

        String packagetype = sc.nextLine();
        String location_given = sc.nextLine();

        int highest_price = findAgencyWithHighestPackagePrice(TA, location_given);
        if (highest_price != 0)
            System.out.println(highest_price);
        else System.out.println("No agencies in the given location");
        TravelAgencies[] ta = sortedAgencyDetailsByPckg(TA, packagetype);
        if (ta == null)
            System.out.println("No such agencies with the given packageType");
        else for (TravelAgencies Ta : ta)
            System.out.println(Ta.getAgencyName());
    }
}
