/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import util.InputUtil;
import util.MenuUtil;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        
        int menu;
        while (true) {
            menu = InputUtil.requireNumber(
                    " What do you want to do ? "
                    + "\n1. Register Employee"
                    + "\n2. Show All Employee"
                    + "\n3. Find Employee"
                    + "\n4. Update Employee "
                    + "\n5. Exit");

            MenuUtil.processMenu(menu);
        }
    }
}
