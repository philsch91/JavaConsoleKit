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

/**
 *
 * @author Philipp Schunker
 */
public class TextBox {
    
    private String title = "";
    private TextBoxInputType type = TextBoxInputType.TEXT;
    
    public TextBox(String title){
        this.title = title;
    }
    
    public TextBox(String title, TextBoxInputType type){
        this.title = title;
        this.type = type;
    }
    
    public String show(){
        System.out.print(this.title + ": ");
        String input = "";
        input = this.readLine();
        if(this.type == TextBoxInputType.NUMBER){
            try{
                int i = Integer.parseInt(input);
                input = Integer.toString(i);
            }catch(NumberFormatException ne){
                System.out.println("Input must be a number");
                input = this.show();
            }
        }
        return input;
    }
    
    private String readLine(){
        String value = "\0";
        BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
        try{
            value = breader.readLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return "";
        }
        return value.trim();
    }
}
