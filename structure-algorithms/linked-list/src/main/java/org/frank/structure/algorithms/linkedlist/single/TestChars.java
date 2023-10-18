package org.frank.structure.algorithms.linkedlist.single;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestChars {

    @Nullable 
    public Character getWinner(CharacterField[][] chars) {
        List<String> strings = new ArrayList<>();
        boolean isLineWin = lineWin(chars,strings);
        if(isLineWin){
            String sign = strings.get(0);
            char[] cArray = sign.toCharArray();
            return cArray[0];
        }
        removeTempList(strings);
        String str = columnWin(chars);
        if(!str.equals(" ")){           
            char[] cArray = str.toCharArray();
            return cArray[0];
        }
        boolean isCrossWin = crossWin(chars, strings);
        if(isCrossWin){
            String sign = strings.get(0);
            char[] cArray = sign.toCharArray();
            return cArray[0];
        }
        return null;
    }
    
    public boolean lineWin(CharacterField[][] chars, List<String> strings){
        for(CharacterField[] lines: chars){            
            for(CharacterField field: lines){
                strings.add(field.getSign());
            }
            if(isWin(strings)){
                return true;
            }
            removeTempList(strings);
        }
        return false;
    }

    public String columnWin(CharacterField[][] chars){
        for(int i = 0; i< chars.length; i++){
            String tempString = "";
            for(int j = 0; j<chars.length; j++){
                String sign = chars[j][i].getSign();
                if(j == 0){
                    tempString = sign;
                    continue;
                }
                if(!tempString.equals(sign)){
                    return " ";
                }
                if(j == chars.length -1){
                    return sign;
                }
            }
            
        }
        return " ";        
    }
    
    public boolean crossWin(CharacterField[][] chars,List<String> strings){        
        for(int i = 0; i<chars.length;i++){
            String sign = chars[i][i].getSign();
            strings.add(sign);            
        }
        if(isWin(strings)){
            return true;
        }
        removeTempList(strings);
        for(int i = chars.length-1; i<0;i--){
            String sign = chars[i][i].getSign();
            strings.add(sign);
        }
        if(isWin(strings)){
            return true;
        }
        return false;
    }
    
    private boolean isWin(List<String> strings){
        if(strings.get(0).equals("X")){
            return !(strings.contains("O") || strings.contains(" "));
        }
        if(strings.get(0).equals("O")){
            return !(strings.contains("X") || strings.contains(" "));
        }
        return false;
    }
    
    private void removeTempList(List<String> strings){
        Iterator<String> iter = strings.iterator();
        while(iter.hasNext()){
            iter.remove();
        }
    }
}
