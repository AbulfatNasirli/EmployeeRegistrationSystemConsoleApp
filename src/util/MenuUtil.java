/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author DELL
 */
public class MenuUtil {
     public static void processMenu(int selectMenu){
        switch (selectMenu) {
                case 1:
                    EmployeeUtil.registerEmployee();
                    break;
                case 2:
                    EmployeeUtil.printAllRegisteredEmployee();
                    break;
                case 3:
                    EmployeeUtil.findEmployeeAndPrint();
                    break;
                case 4:
                    EmployeeUtil.updateEmployeeWithNewObject();
                    break;
                case 5:
                    System.exit(0);
                default:
                    break;
            }
    }
    public static String requireName(){
        return InputUtil.requireText("Enter Name");
    }
    public static String requireSurname(){
        return InputUtil.requireText("Enter Surname");
    }
    public static int requireAge(){
        return InputUtil.requireNumber("Enter Age");
    }
    public static String requireDepartment(){
        return InputUtil.requireText("Enter Department");
    }
}
