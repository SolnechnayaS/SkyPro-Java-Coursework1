import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Main {
    private static void printAllEmployees(Employee[] Employees) {
        for (Employee employee : Employees) {
            System.out.println(employee);
        }
    }

    private static void printAllEmployeesDep(Employee[] Employees) {
        for (Employee employee : Employees) {
            System.out.println(employee.getId() + "\t" + employee.getFullName() + "\t" + employee.getSalary());
        }
    }

    private static void printAllEmployeesFullName(Employee[] Employees) {
        for (Employee employee : Employees) {
            System.out.println(employee.getFullName());
        }
    }

    private static double returnSumMonthSalaryAll(Employee[] Employees) {
        double sumSalaryAll = 0;
        for (Employee employee : Employees) {
            sumSalaryAll = employee.getSalary() + sumSalaryAll;
        }
        return sumSalaryAll;
    }

    private static double returnAverageSumMonthSalary(Employee[] Employees) {
        double sumSalaryAll = 0;
        for (Employee employee : Employees) {
            sumSalaryAll = employee.getSalary() + sumSalaryAll;
        }
        return sumSalaryAll / Employees.length;
    }

    private static void printMinSalaryEmpl(Employee[] Employees) {
        double salaryMin = Employees[0].getSalary();
        int indexEmpl = 0;
        for (int i = 0; i < Employees.length; i++) {
            if (Employees[i].getSalary() < salaryMin) {
                salaryMin = Employees[i].getSalary();
                indexEmpl = i;
            }
        }
        System.out.println("Сотрудник с мимнимальной месячной зарплатой: " + Employees[indexEmpl].getFullName() + " = " + salaryMin);
    }

    private static void printSalaryUpLevel(Employee[] Employees, int level) {
        System.out.println("Сотрудники, получающие зарплату свыше " + level + " рублей в месяц:");
        for (Employee employee : Employees) {
            if (employee.getSalary() >= level) {
                System.out.println(employee.getId() + "\t" + employee.getFullName() + "\t" + employee.getSalary());
            }
        }
    }

    private static void printSalaryDownLevel(Employee[] Employees, int level) {
        System.out.println("Сотрудники, получающие зарплату менее " + level + " рублей в месяц:");
        for (Employee employee : Employees) {
            if (employee.getSalary() < level) {
                System.out.println(employee.getId() + "\t" + employee.getFullName() + "\t" + employee.getSalary());
            }
        }
    }

    private static void printMaxSalaryEmpl(Employee[] Employees) {
        double salaryMax = Employees[0].getSalary();
        int indexEmpl = 0;
        for (int i = 0; i < Employees.length; i++) {
            if (Employees[i].getSalary() > salaryMax) {
                salaryMax = Employees[i].getSalary();
                indexEmpl = i;
            }
        }
        System.out.println("Сотрудник с максимальной месячной зарплатой: " + Employees[indexEmpl].getFullName() + " = " + salaryMax);
    }

    private static void addJournalEmployees(Employee[] Employees, Employee employee) {
        Employees[employee.getId() - 1] = employee;
    }


    public static void setIndexSalary(Employee[] Employees, double index) {
        double salaryIndexation = index / 100 + 1;
        for (Employee employee : Employees) {
            employee.setSalary(employee.getSalary() * salaryIndexation);
        }
    }

    public static Employee[] createListDepartment(Employee[] Employees, int department) {
        int countDepartment = 0;
        for (Employee employee : Employees) {
            if (employee.getDepartment() == department) {
                countDepartment++;
            }
        }
        Employee[] ListDepartment = new Employee[countDepartment];
        int countListDepartment = 0;
        for (Employee employee : Employees) {
            if (employee.getDepartment() == department) {
                ListDepartment[countListDepartment] = employee;
                countListDepartment++;
            }
        }
        return ListDepartment;
    }

    public static void main(String[] args) {
        Employee Sotr1 = new Employee("Ivan", "Ivanovich", "Nichebrodov", 1, 10000);
        Employee Sotr2 = new Employee("Petr", "Ivanovich", "Petrov", 4, 20000);
        Employee Sotr3 = new Employee("Maria", "Ivanovna", "Fixikova", 2, 2000);
        Employee Sotr4 = new Employee("Olga", "Leonidovna", "Ivanova", 2, 20000);
        Employee Sotr5 = new Employee("Leonid", "Borisovich", "Nikolaev", 1, 10000);
        Employee Sotr6 = new Employee("Nikol", "Andreevna", "Petrova", 4, 30000);
        Employee Sotr7 = new Employee("Andrey", "Nikolaevich", "Olgin", 2, 30000);
        Employee Sotr8 = new Employee("Fixik", "Marievich", "Ivanochvilli", 1, 40000);
        Employee Sotr9 = new Employee("Boris", "Petrovich", "Leonidov", 1, 10000);
        Employee Sotr10 = new Employee("Inga", "Ivanovna", "Zaiceva", 4, 20000);

        Employee[] Employees = new Employee[Employee.getCountEmpl()];
        addJournalEmployees(Employees, Sotr1);
        addJournalEmployees(Employees, Sotr2);
        addJournalEmployees(Employees, Sotr3);
        addJournalEmployees(Employees, Sotr4);
        addJournalEmployees(Employees, Sotr5);
        addJournalEmployees(Employees, Sotr6);
        addJournalEmployees(Employees, Sotr7);
        addJournalEmployees(Employees, Sotr8);
        addJournalEmployees(Employees, Sotr9);
        addJournalEmployees(Employees, Sotr10);

        System.out.println("Базовая сложность:\n");
        System.out.println("8. Создать статические методы, которые будут взаимодействовать с массивом и предоставлять результат:");
        System.out.println(
                "    1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).");
        printAllEmployees(Employees);

        System.out.println("Внесем изменения через сеттеры и повторим вывод:");
        Sotr1.setDepartment(2);
        Sotr3.setLastName("Koroleva");
        Sotr5.setSalary(15000);
        Sotr8.setFirstName("Fire");
        printAllEmployees(Employees);

        System.out.println("\n" +
                "    2. Посчитать сумму затрат на зарплаты всех сотрудников в месяц.");
        System.out.println(returnSumMonthSalaryAll(Employees));

        System.out.println("\n" +
                "    3. Найти сотрудника с минимальной зарплатой.");
        printMinSalaryEmpl(Employees);

        System.out.println("\n" +
                "    4. Найти сотрудника с максимальной зарплатой.");
        printMaxSalaryEmpl(Employees);

        System.out.println("\n" +
                "    5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).");
        System.out.println(returnAverageSumMonthSalary(Employees));

        System.out.println("\n" +
                "    6. Получить Ф. И. О. всех сотрудников (вывести в консоль).");
        printAllEmployeesFullName(Employees);

        System.out.println("\n\nПовышенная сложность:\n" +
                "Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).");

        double indexSalary = 10; //индекс изменения заработной платы
        System.out.println("Зарплата всех сотрудников проиндексирована на " + indexSalary + "%. Вывод результата после индексации:");
        setIndexSalary(Employees, indexSalary);
        printAllEmployees(Employees);

        System.out.println("\nПолучить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):");
        int department = 2;
        Employee[] listDepartment = createListDepartment(Employees, department);
        double indexSalaryDep = -13;
        System.out.println("5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.\n" +
                "Отдел номер " + department +
                " работал плохо, руководство приняло решение снизить заработную плату всему отделу на " + indexSalaryDep + "%.");
        setIndexSalary(listDepartment, indexSalaryDep);
        System.out.println("\nРезультаты после индексации зарплаты отдела №" + department + ": ");
        System.out.println(
                "    1. Сотрудник с минимальной зарплатой в отделе:");
        printMinSalaryEmpl(listDepartment);
        System.out.println("\n" +
                "    2. Сотрудник с максимальной зарплатой в отделе:");
        printMaxSalaryEmpl(listDepartment);
        System.out.println("\n" +
                "    3. Сумма затрат на зарплату по отделу.\n" + returnSumMonthSalaryAll(listDepartment));
        System.out.println("\n" +
                "    4. Средняя зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).\n" + returnAverageSumMonthSalary(listDepartment));
        System.out.println("\n" +
                "    6. Напечатать всех сотрудников отдела (все данные, кроме отдела): ");
        printAllEmployeesDep(listDepartment);

        System.out.println("\n" +
                "Еще раз смотрим на табель после всех изменений");
        printAllEmployees(Employees);

        System.out.println("\n3. Получить в качестве параметра число и найти:");
        int level = 20000;
        System.out.println("\n" +
                "    1. Всех сотрудников с зарплатой меньше " + level + " (вывести id, Ф. И. О. и зарплатой в консоль).");
        printSalaryDownLevel(Employees, level);
        System.out.println("\n" +
                "    2. Всех сотрудников с зарплатой больше (или равно)  " + level + "  (вывести id, Ф. И. О. и зарплатой в консоль).");
        printSalaryUpLevel(Employees, level);
    }
}