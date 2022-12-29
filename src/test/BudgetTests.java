/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import controller.*;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class BudgetTests {
    public static void main(String[] args) {
        get();
    }
    
    public static void create(){
        Budget.add(2, 500000);
    }
    
    public static void get(){
        List<Map<String, String>> data = Budget.getAll();
        System.out.println(data);
    }
}
