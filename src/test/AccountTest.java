/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import controller.*;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author User
 */
public class AccountTest {
    public static void main(String[] args) {
        login();
    }
    
    public static void register(){
        Account.register("test1@mail.com", "test1", "08123", "123");
    } 
    
    public static void login(){
        System.out.println(Account.isLoggedIn());
        Account.login("test1@mail.com", "123");
        System.out.println(Account.isLoggedIn());
        System.out.println(Account.getUser());
        System.out.println(new Date().getTime());
    }
}
