import java.util.*;
import java.io.*;
public class Stock{
    private String TSymbol;
    private ArrayList<DailyPrice> prices;
    public Stock(String TSymbol){
        prices = new ArrayList<DailyPrice>();
        this.TSymbol = TSymbol;
    }
    
    public void addDailyPrice(String date, double price){
        prices.add(new DailyPrice(date, price, hashDate(date)));
    }
    
    private int hashDate (String date){
        String[] nums = date.toLowerCase().split("-");   
        int day = Integer.parseInt(nums[0]);
        int month = 0;
        switch(nums[1]){
            case "jan" :
                month = 1;
                break;
            case "feb" :
                month = 2;
                break;
            case "mar" :
                month = 3;
                break;
            case "apr" :
                month = 4;
                break;
            case "may" :
                month = 5;
                break;
            case "jun" :
                month = 6;
                break;
            case "jul" :
                month = 7;
                break;
            case "aug" :
                month = 8;
                break;
            case "sep" :
                month = 9;
                break;
            case "oct" :
                month = 10;
                break;
            case "nov" :
                month = 11;
                break;
            case "dec" :
                month = 12;
                break;
            
        }
        int year = Integer.parseInt(nums[2]);
        if(year == 99){
            year+=1900;
        }
        return 10000 * year + 100 * month + day;
    }
    
    public String toString(){
        String str = "";
        for(DailyPrice price: prices){
            str+="hashDate: "+price.getHash()+"\tDate: "+price.getDate()+"\tPrice: "+price.getPrice()+"\n";
        }
        return str;
    }
}