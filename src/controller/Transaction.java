/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Category;
import database.CrudOperations;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Transaction {
    public static boolean add(String name, int amount, int type, int categoryId, Date date){
//        if (Account.getBalance() < amount){
//            return false;
//        }
        
        Map<String, Object> data = new HashMap<>();
        
        data.put("name", name);
        data.put("amount", amount);
        data.put("type", type);
        data.put("category_id", categoryId);
        
        data.put("user_id", Account.getUser().get("id"));
        data.put("created_at", date);
        
        boolean result = CrudOperations.create("transactions", data);
        
        if (!result){
            System.out.println("Data transaksi gagal ditambahkan");
            return false;
        }
        
        Account.balance(type, amount);
        return true;
    }
    
    public static Map<String, String> get(int transactionId){
        return CrudOperations.read("transactions", "id = " + transactionId).get(0);
    }
    
    public static List<Map<String, String>> getAll(){
        Map<String, String> user = Account.getUser();
        
        List<Map<String, String>> transactions = CrudOperations.read("transactions", "user_id = " + user.get("id"));
        
        for (Map<String, String> transaction : transactions){
            transaction.put("category_name", Category.getName(transaction.get("category_id")));
            transaction.put("type_name", typeName(transaction.get("type")));
        }
        
        return transactions;
    }
    
    public static List<Map<String, String>> getPendapatan(){
        Map<String, String> user = Account.getUser();
        return CrudOperations.read("transactions", "type = 1 AND user_id = " + user.get("id"));
    }
    
    public static List<Map<String, String>> getPengeluaran(){
        Map<String, String> user = Account.getUser();
        return CrudOperations.read("transactions", "type = 2 AND user_id = " + user.get("id"));
    }
    
    public static Map<String, Integer> getTotal(){
        Map<String, Integer> total = new HashMap<>();
        
        int totalPendapatan = 0;
        int totalPengeluaran = 0;
        
        List<Map<String, String>> transactions = getAll();
        
        for(Map<String, String> transaction : transactions){
            if (transaction.get("type").equals("1")){
                totalPendapatan += Integer.parseInt(transaction.get("amount"));
            } else {
                totalPengeluaran += Integer.parseInt(transaction.get("amount"));
            }
        }
        
        total.put("pendapatan", totalPendapatan);
        total.put("pengeluaran", totalPengeluaran);
        
        return total;
    }
    
    public static void update(Map<String, String> data, String id){
        CrudOperations.update("transactions", data, id);
    }
    
    public static void delete(String id){
        CrudOperations.delete("transactions", id);
    }
    
    public static String typeName(String id){
        if (id.equals("1")){
            return "Pendapatan";
        } else {
            return "Pengeluaran";
        }
    }
}
