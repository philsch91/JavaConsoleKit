/*
 * The MIT License
 *
 * Copyright 2019 Philipp Schunker.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.consolekit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.consolekit.model.Credential;


/**
 *
 * @author Philipp Schunker
 */
public class LoginForm {
    
    public Credential show(){
        BufferedReader inputBuffReader = new BufferedReader(new InputStreamReader(System.in));
        String username = "\0";
        
        System.out.print("Username: ");
        try{
            username = inputBuffReader.readLine();
        }catch(IOException ioe){
            System.out.println("Failure: " + ioe.toString() + "\n" + "Please restart the application with CTRL+C");
        }
        
        if(!this.validateLoginInput(username)){
            return null;
        }
        
        String password = "\0";
        
        System.out.print("Password: ");
        try{
            password = inputBuffReader.readLine();
        }catch(IOException ioe){
            System.out.println("Failure: " + ioe.toString() + "\n" + "Please restart the application with CTRL+C");
        }
        
        if(!this.validateLoginInput(password)){
            return null;
        }
        
        Credential cred = new Credential();
        cred.setUsername(username);
        cred.setPassword(password);
        
        return cred;
    }
    
    private String readInput(String inputName){
        BufferedReader inputBuffReader = new BufferedReader(new InputStreamReader(System.in));
        String val = "\0";
        while(true){
            System.out.println(inputName + ": ");
            try{
                val = inputBuffReader.readLine();
            }catch(IOException ioe){
                System.out.println("Failure: " + ioe.toString() + "\n" + "Please restart the application with CTRL+C");
            }
            if(this.validateLoginInput(val)){
               return val; 
            }
            System.out.println("invalid input");
        }
    }
    
    private boolean validateLoginInput(String input){
        input = input.trim();
        if(input.length() == 0){
            return false;
        }
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(input);
        
        return !matcher.find();
    }
}
