/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.CrudOperations;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Budget {
    public static boolean add(int categoryId, int total){
        Map<String, Object> data = new HashMap<>();
        
        data.put("category_id", categoryId);
        data.put("total", total);
        
        return CrudOperations.create("budgets", data);
    }
    
    public static List<Map<String, String>> getAll(){
        List<Map<String, String>> budgets = CrudOperations.read("budgets", null);
        List<Map<String, String>> transactions = CrudOperations.read("transactions", null);
        
        budgets.forEach(budget -> {
            int total = 0;
            
            for(Map<String, String> transaction : transactions){
                if (transaction.get("category_id").equals(budget.get("category_id"))){
                    total += Integer.parseInt(transaction.get("amount"));
                }
            }
            
            budget.put("category_name", Category.getName(budget.get("category_id")));
            
            budget.put("used", String.valueOf(total));
        });
        
        return budgets;
    }
    
    public static boolean delete(int categoryId){
        return CrudOperations.delete("budgets", String.valueOf(categoryId));
    }
}
