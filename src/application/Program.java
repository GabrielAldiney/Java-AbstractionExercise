package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		List<TaxPayer> list = new ArrayList<>();
		
		for(int i=0; i < n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.println("Individual or company (i/c)?");
			char ch = sc.next().charAt(0);
			if(ch == 'i') {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Anual Income: ");
				Double anualIncome = sc.nextDouble();
				System.out.println("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.println("Name: ");
				String name = sc.next();
				System.out.println("Anual Income: ");
				Double anualIncome = sc.nextDouble();
				System.out.println("Number of employees: ");
				int numberOfEmplyees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmplyees));
			}
		}
		
		System.out.println("");
		System.out.println("TAXES PAID: ");
		
		Double sum = 0.0;
		for(TaxPayer tp: list) {
			System.out.println(tp.toString());
			sum += tp.tax();
		}
		
		System.out.println("");
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		
		
		
		
		
		
		
		
		sc.close();

	}

}
