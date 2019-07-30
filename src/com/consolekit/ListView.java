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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Philipp Schunker
 */
public class ListView {
    
    private String title = "";
    private List<Object> items = new ArrayList<>();
    
    public ListView(){
        //this.items = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        if(items.size() <= 1){
            return;
        }
        
        String type = items.get(0).getClass().getSimpleName();
        for(Object o : items){
            if(!o.getClass().getSimpleName().equals(type)){
                return;
            }
        }
        
        this.items = items;
    }
    
    public void addItem(Object item){
        if(this.items.size()>1){
            Class type = items.get(0).getClass();
            if(item.getClass() != type){
                return;
            }
        }
        this.items.add(item);
    }
    
    public void show(){
        //Field[] fields = this.items.get(0).getClass().getDeclaredFields();
        if(this.getTitle().equals("")){
            title = "";
            //String objectType = this.getItems().get(0).getClass().getSimpleName();
            //this.setTitle("Select " + objectType + ":");
            /*
            for(Field f : fields){
                title = title + f.getName() + "|";
            }*/
        }
        System.out.println("\n" + this.getTitle());
        for(int i = 0;i<this.getTitle().length();i++){
            System.out.print("-");
        }
        System.out.println("\n");
        
        int j = 1;
        for(Object o: this.items){
            //System.out.println(Integer.toString(j)+")\t"+o.toString());
            Field[] fields = o.getClass().getDeclaredFields();
            //HashMap<String,String> objFields = mapObjectFieldsToHashMap(o);
            for(Field f : fields){
                //f = o.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                String fieldName = f.getName();
                String value = null;
                try {
                    if(f.get(o) == null){
                        value = null;
                    }else if(f.getType().isAssignableFrom(String.class)){
                        value = (String)f.get(o);
                    }else if(f.getType().isAssignableFrom(Integer.class)){
                        Integer v = (Integer)f.get(o);
                        value = v.toString();
                    }else if(f.getType().isAssignableFrom(Long.class)){
                        Long v = (Long)f.get(o);
                        value = v.toString();
                    }else if(f.getType().isAssignableFrom(Double.class)){
                        Double v = f.getDouble(o);
                        value = v.toString();
                    }else if(f.getType().isAssignableFrom(double.class)){
                        double v = f.getDouble(o);
                        value = Double.toString(v);
                    }else if(f.getType().isAssignableFrom(int.class)){
                        int v = f.getInt(o);
                        value = Integer.toString(v);
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    value = null;
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                    value = null;
                }                
                
                //System.out.println(Integer.toString(j)+")\t"+fieldName + ":" + value);
                if(value != null){
                    fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    System.out.println(fieldName + ": " + value);
                }
            }
            /*
            for(Map.Entry<String, String> kvp : objFields.entrySet()){
                System.out.println(kvp.getKey() + ": " + kvp.getValue());
            }*/
            j++;
            System.out.println("\n");
        }
        System.out.println("\n");
    }
    
    private HashMap mapObjectFieldsToHashMap(Object o){
        HashMap<String,String> objectFields = new HashMap<String,String>();
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field f : fields){
            //f = o.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            String fieldName = f.getName();
            
            String value = null;
            try {
                if(f.get(0) == null){
                    value = null;
                }else if(f.getType().isAssignableFrom(String.class)){
                    value = (String)f.get(o);
                }else if(f.getType().isAssignableFrom(Integer.class)){
                    Integer v = (Integer)f.get(o);
                    value = v.toString();
                }else if(f.getType().isAssignableFrom(Long.class)){
                    Long v = (Long)f.get(o);
                    value = v.toString();
                }else if(f.getType().isAssignableFrom(Double.class)){
                    Double v = f.getDouble(o);
                    value = v.toString();
                }else if(f.getType().isAssignableFrom(double.class)){
                    double v = f.getDouble(o);
                    value = Double.toString(v);
                }else if(f.getType().isAssignableFrom(int.class)){
                    int v = f.getInt(o);
                    value = Integer.toString(v);
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                value = null;
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ListView.class.getName()).log(Level.SEVERE, null, ex);
                value = null;
            }
            
            objectFields.put(fieldName, value);
        }
        
        return objectFields;
    }
}
