/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.CrudOperations;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Category {
    public static List<Map<String, String>> getAll(){
        return CrudOperations.read("categories", null);
    }
    
    public static String getName(String id){
        Map<String, String> category = CrudOperations.read("categories", "id = " + id).get(0);
        return category.get("name");
    }
}
