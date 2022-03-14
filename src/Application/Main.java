package Application;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scan.nextInt();

        for(int i=1; i<=n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");

            char ch = scan.next().toLowerCase().charAt(0);
            scan.nextLine();

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Annual income: ");
            double income = scan.nextDouble();

            if(ch == 'i') {
                System.out.print("Health expenditures: ");
                double health = scan.nextDouble();
                list.add(new Individual(name, income, health));
            } else {
                System.out.print("Number of employees: ");
                int number = scan.nextInt();
                list.add(new Company(name, income, number));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        double totalTax = 0;
        for(TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName() + String.format(": $%.2f", taxPayer.tax()));
            totalTax += taxPayer.tax();
        }
        System.out.printf("TOTAL TAXES: $ %.2f", totalTax);

        scan.close();
    }
}
