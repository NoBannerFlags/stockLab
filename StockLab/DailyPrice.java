 


public class DailyPrice{
    private final int hashDate;
    private final double price;
    private final String date;
    public DailyPrice(String date, double price, int hashDate){
        this.hashDate = hashDate;
        this.price = price;
        this.date = date;
    }
    
    public int getHash(){
        return hashDate;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getDate(){
        return date;
    }
    
    public String toString(){
        return hashDate+": "+price;
    }
}
