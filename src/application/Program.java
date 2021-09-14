package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<>();

		System.out.print("Enter the number of tax payers");
		int taxPayers = sc.nextInt();

		for (int i = 1; i <= taxPayers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c)?");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				pessoas.add(new PessoaFisica(name, anualIncome, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				pessoas.add(new PessoaJuridica(name, anualIncome, numberOfEmployees));
			}
		}

		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getName() + ": $" + String.format("%.2f", pessoa.calculaValordoImposto()));
			sum += pessoa.calculaValordoImposto();
		}
		System.out.println("Total taxes: $" + String.format("%.2f", sum));

		sc.close();

	}
}
