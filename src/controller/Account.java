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
public class Account {
    private static Map<String, Object> session = new HashMap<>();
    
    public static boolean register(String email, String full_name, String phone, String password){
        Map<String,  String> data = new HashMap<>();
        data.put("email", email);
        data.put("full_name", full_name);
        data.put("phone", phone);
//        String hashedPassword = encryptPassword(password);
        data.put("password", password);
        
        return CrudOperations.create("users", data);
    }
    
    public static boolean login(String email, String password){
        List<Map<String, String>> data = CrudOperations.read("users", "email = '" + email + "'");
        
        if (data.isEmpty()){
            System.out.println("Email tidak ditemukan!");
            return false;
        }
        
        Map<String, String> user = data.get(0);
        
        if (!password.equals(user.get("password"))){
            System.out.println("Password salah!");
            return false;
        } 
        
        System.out.println("Berhasil login!");
        
        setAttribute("user", user);
        
        return true;
    }
    
    public static void logout() {
        // Hapus status login pengguna dari sesi
        removeAttribute("user");
      }

    public static boolean isLoggedIn() {
        // Cek apakah status login pengguna tersimpan di dalam sesi
        return getAttribute("user") != null;
    }
    
    public static Map<String, String> getUserFromSession(){   
        return (Map<String, String>) getAttribute("user");
    }
    
    public static Map<String, String> getUser(){
        Map<String, String> userLocal = getUserFromSession();
        
        List<Map<String, String>> user = CrudOperations.read("users", "id = " + userLocal.get("id"));
        return user.get(0);
    }
    
    public static int getBalance(){
        return Integer.parseInt(getUser().get("balance"));
    }
    
    public static void balance(int type,int amount){
        Map<String, String> user = getUser();
        
        String id = user.get("id");
        int balance = Integer.parseInt(user.get("balance"));
        
        if (type == 1){
            balance += amount;
        } else {
            balance -= amount;
        }
        
        Map<String, String> data = new HashMap<>();
        data.put("balance", String.valueOf(balance));
        
        CrudOperations.update("users", data, id);
        
        System.out.println("Saldo berhasil di update");
    }
    
    private static void setAttribute(String key, Object value) {
        session.put(key, value);
    }

    private static Object getAttribute(String key) {
        return session.get(key);
    }

    private static void removeAttribute(String key) {
        session.remove(key);
    }
}
