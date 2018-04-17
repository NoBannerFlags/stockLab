import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws Exception{
        String fileLoc = "C:\\Users\\Kai P\\Documents\\GitHub\\Airshipdown1\\stockLab\\StockLab\\Store\\";
        Scanner input = new Scanner(new File("QQQ-Prices.txt"));
        Stock stock = new Stock(input.nextLine());
        while(input.hasNextLine()){
            String[] day = input.nextLine().split("\t");
            stock.addDailyPrice(day[0], Double.parseDouble(day[1]));
        }
        
        BufferedWriter bw = null;
        FileWriter fw = null;
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
    }
}
