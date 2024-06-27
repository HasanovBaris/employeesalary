public class Operator implements Employee {
    private final int salary;

    public Operator(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public void onFire() {
        System.out.println("Operator has been fired.");
    }

    @Override
    public void onHire() {
        System.out.println("Operator has been hired.");
    }
}
