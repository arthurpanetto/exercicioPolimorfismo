package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Entre com o numero de produtos: ");
        int n = scan.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("Produto #"+i);
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char ch = scan.next().charAt(0);
            System.out.print("Nome: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Preço: ");
            Double price = scan.nextDouble();
            if(ch == 'c'){
                list.add(new Product(name, price));
            }
            else if(ch == 'u'){
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(scan.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name, price, date));
            }
            else{
                System.out.print("Taxa de importação: ");
                Double customsFee = scan.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
		System.out.println("ETIQUETAS DE PRECO:");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }
        scan.close();
    }
}
