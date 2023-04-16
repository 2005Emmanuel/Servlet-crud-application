/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet.crud.application;

/**
 *
 * @author user
 */
public class crud_DB_utils {
   private int  id;
   private String title;
   private  String description;
    
   public int getid(){
       return id;
   }
   
   public void setid(int id){
       this.id = id;
   }
    public String get_title(){
        return title;
    }
    
    public void set_title(String title){
        this.title = title;
    }
    
    public String get_description(){
        return description;
    }
    
    public void set_description(String description){
        this.description = description;
    }
}
