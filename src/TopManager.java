public class TopManager implements Employee {
    private final int salary;

    public TopManager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {
        System.out.println("Top Manager has been fired.");
    }

    @Override
    public void onHire() {
        System.out.println("Top Manager has been hired.");
    }
}
