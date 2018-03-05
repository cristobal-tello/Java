/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toful.WebSockets;

/**
 *
 * @author Developer
 */
public class TofulMessage {
    int id;
    String message;
    
    public int getID()
    {
        return this.id;
    }
     
    public String getMessage()
    {
        return this.message;
    }
    
    @Override
    public String toString()
    { 
        return "ID: " + this.id + " Message: " + this.message;
    }
}
