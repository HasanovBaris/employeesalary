public class Manager implements Employee {
    private final int salary;

    public Manager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {
        System.out.println("Manager has been fired.");
    }

    @Override
    public void onHire() {
        System.out.println("Manager has been hired.");
    }
}
