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
package com.schunker.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Philipp Schunker
 */
public class Menu {
    
    private String title = "";
    private ArrayList<String> entries = new ArrayList<String>();
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the entries
     */
    public ArrayList<String> getEntries() {
        return entries;
    }

    /**
     * @param entries the entries to set
     */
    public void setEntries(ArrayList<String> entries) {
        this.entries = entries;
    }
    
    public Menu(){}
    
    public int insert(String text){
        //this.getEntries().add(text);
        this.entries.add(text);
        return getEntries().size();
    }
    
    public int remove(int index){
        //this.getEntries().remove(index);
        this.entries.remove(index);
        return getEntries().size();
    }
    
    public int show(){
        System.out.println("\n" + this.getTitle());
        for (int i = 0;i < this.getTitle().length();i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        
        int j = 1;
        for (String s : getEntries()) {
            System.out.println(Integer.toString(j) + ")\t" + s);
            j++;
        }
        System.out.println("\n");
        BufferedReader inputBuffReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String val = "\0";
            System.out.print("> ");
            
            try {
                val = inputBuffReader.readLine();
            } catch (IOException ioe) {
                System.out.println("Failure: " + ioe.toString() + "\n" +
                        "Please restart the application with CTRL+C");
            }
            if (val.length() > 0) {
                int inputNumber = Character.getNumericValue(val.charAt(0));
                //if(inputNumber==-1 && Character.toLowerCase(val.charAt(0))=='q'){return 0;}
                for (int k=0;k < getEntries().size();k++) {
                    if ((k+1) == inputNumber) {
                        return inputNumber;
                    }
                }
            }
            System.out.println("Invalid input");
        }
    }
    
}
