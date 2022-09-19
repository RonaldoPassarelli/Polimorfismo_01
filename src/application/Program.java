package application;

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
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List <Product> list = new ArrayList<>();
		System.out.print("Enter the number of products:");
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++){
			System.out.println("Product #" + i + "data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char r = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name:");
			String name = sc.nextLine();
			System.out.print("Price:");
			double price = sc.nextDouble();
			if(r == 'i'){
				System.out.print("Customs fee:");
				double cF = sc.nextDouble();
				Product pImp = new ImportedProduct(name, price, cF);
				list.add(pImp);
			}
			else if(r == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY):");
				sc.nextLine();
				String mD = sc.nextLine();
				LocalDate manufactureDate = LocalDate.parse(mD, fmt1);
				Product pUsed = new UsedProduct(name, price, manufactureDate);
				list.add(pUsed);
			}
		
			else {
				Product pD = new Product(name, price);
				list.add(pD);
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product p: list) {
		System.out.println(p.priceTag());
		}

		sc.close();
	}
}
