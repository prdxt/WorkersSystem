import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Dominik Jajko");


        HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
        EmployeeManager employeeManager = new EmployeeManager(employeeHashMap);



        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            System.out.println("1.Dodaj pracownika");
            System.out.println("2.Usuń pracownika");
            System.out.println("3.Zaktualizuj dane o pracowniku");
            System.out.println("4.Wyświetl liste wszystkich pracownikow");
            System.out.println("5.Wyszukaj pracownika po nazwisku");
            System.out.println("Inna wartosc zakonczy program");
            int input = Integer.parseInt(bufferedReader.readLine());
            switch (input){
                case 1:
                    employeeManager.addEmployee();
                    break;
                case 2:
                {
                    int id = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.removeEmployee(employeeManager.searchEmployeeByID(id));
                    break;
                }
                case 3:
                {
                    System.out.println("Podaj ID pracownika, którego chcesz zaaktualizować:");
                    int employeeID = Integer.parseInt(bufferedReader.readLine());
                    employeeManager.updateEmployee(employeeID);
                    break;

                }
                case 4:
                {
                    employeeManager.listAllEmployees();
                    break;
                }
                case 5:
                {
                    System.out.println("Podaj nazwisko pracownika którego chcesz wyszukać: ");
                    String lastName = bufferedReader.readLine();
                    HashSet<Employee> employeeHashSet = employeeManager.searchEmployeesByLastName(lastName);
                    for (Employee employee: employeeHashSet
                         ) {
                        System.out.println(employee);
                    }
                    break;

                }
                default:
                    System.exit(0);
            }
        }
    }
}


//do testu//