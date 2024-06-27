import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Company {
    private final List<Employee> employees = new ArrayList<>();

    public void hire(Employee employee) {
        employees.add(employee);
        employee.onHire();
    }

    public void hireAll(List<Employee> employeesList) {
        for (Employee employee : employeesList) {
            hire(employee);
        }
    }

    public void fire(int count) {
        for (int i = 0; i < count; i++) {
            if (!employees.isEmpty()) {
                Employee employee = employees.remove(employees.size() - 1);
                employee.onFire();
            }
        }
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o2.getMonthSalary(), o1.getMonthSalary());
            }
        });
        return employees.subList(0, Math.min(count, employees.size()));
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });
        return employees.subList(0, Math.min(count, employees.size()));
    }

    public static void main(String[] args) {
        Company company = new Company();
        Random random = new Random();

        // 200 Operator əlavə olunur
        for (int i = 0; i < 200; i++) {
            company.hire(new Operator(random.nextInt(1000) + 1000));
        }

        // 50 Manager əlavə olunur
        for (int i = 0; i < 50; i++) {
            company.hire(new Manager(random.nextInt(2000) + 2000));
        }

        // 10 Top Manager əlavə olunur
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager(random.nextInt(3000) + 3000));
        }

        // 50% işçiləri ixtisar etmək
        company.fire((company.employees.size() / 2));

        // Ən çox maaş alanlar
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(10);
        System.out.println("Top Salary Staff:");
        for (Employee employee : topSalaryStaff) {
            System.out.println(employee.getMonthSalary());
        }

        // Ən az maaş alanlar
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(10);
        System.out.println("Lowest Salary Staff:");
        for (Employee employee : lowestSalaryStaff) {
            System.out.println(employee.getMonthSalary());
        }
    }
}
