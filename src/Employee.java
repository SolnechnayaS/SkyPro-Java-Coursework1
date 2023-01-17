public class Employee {
    public static int countEmpl = 0;
    private int id;
    private String firstName;
    private String secondName;
    private String lastName;
    private int department;
    private double salary;

    public static int getCountEmpl() {
        return countEmpl;
    }

    @Override
    public String toString() {
        return "Id: " + id + '\t'+
                "Отдел: " + department + '\t'+
                lastName + ' '+
                firstName + ' ' +
                secondName + '\t' +
                " = " + salary;
    }

    public int getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + secondName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static void setCountEmpl(int countEmpl) {
        Employee.countEmpl = countEmpl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String firstName, String secondName, String lastName, int department, double salary) {
        countEmpl++;
        this.id = getCountEmpl();
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

    }


}
