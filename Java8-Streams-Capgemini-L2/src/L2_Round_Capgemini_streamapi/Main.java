package L2_Round_Capgemini_streamapi;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Employees> employees = new ArrayList<>();
        employees.add(new Employees("ABC" , 25 , "Male" , "HR"));
        employees.add(new Employees("DEF" , 35 , "Female" , "IT"));
        employees.add(new Employees("GHI" , 45 , "Male" , "HR"));
        employees.add(new Employees("XYZ" , 55 , "Female" , "IT"));
        employees.add(new Employees("UVW" , 75 , "Male" , "HR"));

        //1.Using Stream-API [Print distinct Department Names]
        employees.stream().map(Employees::getDepartment).distinct().forEach(System.out::println);
        //Employees::getDepartment --> Method-Referencing
        System.out.println();
        //2.Using Stream-API [Print count of Employees in Each Department]
        Map<String, Long>  empCountByDept =  employees.stream()
                .collect(Collectors.groupingBy(Employees::getDepartment,Collectors.counting()));
        System.out.println(empCountByDept);

    }
}