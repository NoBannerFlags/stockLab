import java.util.*;
import java.io.*;
public class Main
{
    
    public static void main(String[] args) throws Exception{
        String fileLoc = "C:\\Users\\Public\\Documents\\GitHub\\stockLab\\StockLab\\Store\\";
        String fileLoc0 = "C:\\Users\\Public\\Documents\\GitHub\\stockLab\\StockLab\\Found_Dates\\";
        Scanner input = new Scanner(new File("QQQ-Prices.txt"));
        Stock stock = new Stock(input.nextLine());
        while(input.hasNextLine()){
            String[] day = input.nextLine().split("\t");
            stock.addDailyPrice(day[0], Double.parseDouble(day[1]));
        }
        
        BufferedWriter bw = null;
        BufferedWriter bw0 = null;
        FileWriter fw = null;
        FileWriter fw0 = null;
        fw = new FileWriter(fileLoc);
        bw = new BufferedWriter(fw);
        bw.write(stock.toString());
        
        
        System.out.println(stock);
        System.out.println("Sum of first 2,000 (not sorted) = "+stock.get2Prices());
        stock.reverseIt();
        System.out.println("Sum of first 2,000 = "+stock.get2Prices());
        bw.write(stock.toString());
        
        bw.flush();        
        input.close();
        bw.close();
        fw.close();
        
        System.out.println("value at 24-Mar-2000: "+stock.findPrice("24-Mar-00"));
        fw0 = new FileWriter(fileLoc0);
        bw0 = new BufferedWriter(fw0);
        bw0.append("Found price at 24-Mar-2000: "+stock.findPrice("24-Mar-00"));
        System.out.println("value at October 7, 2002 7-Oct-2002: "+stock.findPrice("7-Oct-00"));
        //bw0.append();
        bw0.flush();
        bw0.close();
    }
}
