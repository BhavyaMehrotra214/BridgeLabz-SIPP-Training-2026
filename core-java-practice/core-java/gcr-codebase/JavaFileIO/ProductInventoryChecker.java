import java.io.*;
public class ProductInventoryChecker {
    public static void main(String[] args)
            throws Exception {
        BufferedReader br =
                new BufferedReader(
                        new FileReader("inventory.txt"));
        String line;
        while((line = br.readLine()) != null){
            String[] data = line.split("-");
            String product = data[0];
            int quantity =
                    Integer.parseInt(data[1]);
            if(quantity == 0){
                System.out.println(
                        product +
                                " is out of stock");
            }
        }

        br.close();
    }
}