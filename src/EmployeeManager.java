import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EmployeeManager {

    private final HashMap<Integer,Employee> employees;

    public EmployeeManager(HashMap<Integer, Employee> employees) {
        this.employees = employees;
    }

    public  void addEmployee() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj imie pracownika:");
        String firstName = reader.readLine();

        System.out.println("Podaj nazwisko pracownika:");
        String lastName = reader.readLine();

        System.out.println("Podaj stanowisko pracownika:");
        String position = reader.readLine();

        System.out.println("Podaj zarobki pracownika:");
        int salary = Integer.parseInt(reader.readLine());

        Employee newEmplyee = new Employee(firstName,lastName,position,salary);
        employees.put(newEmplyee.getEmployeeID(), newEmplyee);



    }
    public void removeEmployee(Employee employee){
        if(employees.containsKey(employee.getEmployeeID()))
            employees.remove(employee.getEmployeeID());
        else
            System.out.println("Pracownik o takim ID nie istnieje");
    }

    public void updateEmployee(int employeeID) throws IOException {

        if (employees.containsKey(employeeID)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Podaj nowe stanowisko pracownika:");
            String newPosition = reader.readLine();

            System.out.println("Podaj nowe zarobki pracownika:");
            int newSalary = Integer.parseInt(reader.readLine());

            Employee employee = employees.get(employeeID);
            employee.setSalary(newSalary);
            employee.setPosition(newPosition);

        }else {
            System.out.println("Nie znaleziono pracownika o danym ID");
        }

    }
    public Employee searchEmployeeByID(int employeeID) {
        if(employees.containsKey(employeeID)){
            return employees.get(employeeID);
        }
        else
            System.out.println("Nie znaleziono pracownika o danym ID");
           return null;
    }
    public void listAllEmployees(){
        ArrayList<Employee> employeeList = new ArrayList<>(employees.values());
        for (Employee employee: employeeList
             ) {
            System.out.println(employee);
        }
    }
    public HashSet<Employee> searchEmployeesByLastName(String lastName){
         HashSet<Employee> employeeList = new HashSet<>(employees.values());
        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext())
        {
            Employee employee = employeeIterator.next();
            if(!employee.getLastName().equals(lastName))
                employeeIterator.remove();
        }
        return employeeList;
    }


}
