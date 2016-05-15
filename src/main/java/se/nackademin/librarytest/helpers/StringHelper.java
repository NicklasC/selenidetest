/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.helpers;

import java.util.UUID;

/**
 *
 * @author nicklas
 */
public class StringHelper {
    
    public static String randomString(){
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
