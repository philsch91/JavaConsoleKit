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
import java.util.List;

/**
 *
 * @author Philipp Schunker
 */
public class SelectionMenu {
    
    private String title = "";
    private List<Object> options = new ArrayList<>();
    
    public SelectionMenu(){}

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        //TODO: check if type of all entries in list is the same via Reflection
        this.options = options;
    }
    
    public void addOption(Object object){
        this.options.add(object);
    }
    
    public Object show(){
        if(this.title == ""){
            String objectType = this.options.get(0).getClass().getSimpleName();
            this.setTitle("Select " + objectType + ":");
        }
        System.out.println("\n" + this.getTitle());
        for (int i = 0;i < this.getTitle().length();i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        
        int j = 1;
        for (Object o: this.options) {
            System.out.println(Integer.toString(j) + ")\t" + o.toString());
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
                System.out.println("Failure: " + ioe.toString() + "\n"+
                        "Please restart the application with CTRL+C");
            }
            if (val.length() > 0) {
                int inputNumber = Character.getNumericValue(val.charAt(0));
                //if(inputNumber==-1 && Character.toLowerCase(val.charAt(0))=='q'){return 0;}
                for (int k = 0; k < this.options.size(); k++) {
                    if ((k + 1) == inputNumber) {
                        //return inputNumber;
                        return this.options.get(inputNumber - 1);
                    }
                }
            }
            System.out.println("Invalid input");
        }
    }
}
