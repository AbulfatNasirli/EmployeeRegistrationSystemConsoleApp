/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.Employee;
import main.Config;

/**
 *
 * @author DELL
 */
public class EmployeeUtil {
    public static Employee fillEmployee() {

        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String department = MenuUtil.requireDepartment();
        Employee emp = new Employee(name, surname, age, department);
        return emp;
    }

    public static void printAllRegisteredEmployee() {
        for (int i = 0; i < Config.employee.length; i++) {
            if (Config.employee == null) {
                return;
            }
            Employee emp = Config.employee[i];
            System.out.println(emp.getName() + " " + emp.getSurname() + " " + emp.getAge() + " " + emp.getDepartment());
        }
    }

    public static void registerEmployee() {

        int count = InputUtil.requireNumber("Nece ishci qeydiyyatdan kecireceksiniz :");
        Config.employee = new Employee[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");

            Config.employee[i] = EmployeeUtil.fillEmployee();
        }
        System.out.println("Registration completed successfully");
        EmployeeUtil.printAllRegisteredEmployee();
    }

    public static void findEmployeeAndPrint() {
        String text = InputUtil.requireText("Axtardiginiz adi daxil edin: meselen name,surname,department");
        Employee[] result = findEmployee(text);
        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i].getFullInfo());
        }
    }

    public static Employee[] findEmployee(String text) {
        int count = 0;
        for (int i = 0; i < Config.employee.length; i++) {
            Employee emp = Config.employee[i];
            if (emp.getName().contains(text) || emp.getSurname().contains(text) || emp.getDepartment().contains(text)) {

                count++;
            }
        }
        Employee[] result = new Employee[count];
        int found = 0;
        for (int i = 0; i < Config.employee.length; i++) {
            Employee emp = Config.employee[i];
            if (emp.getName().contains(text) || emp.getSurname().contains(text) || emp.getDepartment().contains(text)) {
                result[found] = emp;
                found++;

            }

        }
        return result;
    }

    public static void updateEmployeeWithNewObject() {
        EmployeeUtil.printAllRegisteredEmployee();
        int i = InputUtil.requireNumber("Nece ishcide deyisiklik etmek istyirsiz ?");
        Employee emp = EmployeeUtil.fillEmployee();
        Config.employee[i - 1] = emp;
    }

    public static void updateEmployeeWithSameObject() {
        EmployeeUtil.printAllRegisteredEmployee();
        int i = InputUtil.requireNumber("Necenci Adamda Deyisiklik Etmek Isteyirsiniz :");
        Employee selectedEmployee = Config.employee[i - 1];
        String changeParam = InputUtil.requireText("Neleri deyismek isteyirsiniz : meslen name, surname, age");
        if (changeParam.contains("'name'")) {
            selectedEmployee.setName(MenuUtil.requireName());
        }
        if (changeParam.contains("'surname'")) {
            selectedEmployee.setSurname(MenuUtil.requireSurname());
        }
        if (changeParam.contains("'age'")) {
            selectedEmployee.setAge(MenuUtil.requireAge());
        }
        if (changeParam.contains("'department'")) {
            selectedEmployee.setDepartment(MenuUtil.requireDepartment());
        }
    }

    public static void updateEmployeeWithSpilt() {
        EmployeeUtil.printAllRegisteredEmployee();
        int index = InputUtil.requireNumber("Necenci Adamda Deyisiklik Etmek Isteyirsiniz :");
        Employee selectedEmployee = Config.employee[index - 1];
        String changeParam = InputUtil.requireText("Neleri deyismek isteyirsiniz : meslen name,surname,age");
        String[] parameters = changeParam.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];

            if (param.equals("name")) {
                selectedEmployee.setName(MenuUtil.requireName());
            } else if (param.equals("surname")) {
                selectedEmployee.setSurname(MenuUtil.requireSurname());
            } else if (param.equals("age")) {
                selectedEmployee.setAge(MenuUtil.requireAge());
            } else if (param.equals("department")) {
                selectedEmployee.setDepartment(MenuUtil.requireDepartment());
            }
        }
    }
}
