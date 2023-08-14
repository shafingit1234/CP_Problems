package CP_Practice;

import java.util.Scanner;

public class Cost_Benefit_Analysis {
	public static double NPV(double cashFlow, double discountRate, int timePeriod) {
		return cashFlow / Math.pow(1 + discountRate, timePeriod);
	}

	public static double costratio(double totalCost, double totalBenefits) {
		return totalBenefits / totalCost;
	}

	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		double initial_investment , discountRate;
		int projectDuration;
		
		System.out.println("Enter the initial investment");
		initial_investment = sc.nextDouble();
		System.out.println("Enter the discount Rate");
		discountRate = sc.nextDouble();
		
		System.out.println("Enter the project duration");
		projectDuration = sc.nextInt();
		
		double totalBenefits =0.0;
		for (int i = 1; i <= projectDuration; i++) {
	        double cashFlow;
	        System.out.println("Enter cash flow for year " + i + " : ");
	        cashFlow = sc.nextDouble();

	        double npv = NPV(cashFlow, discountRate, i);
	        totalBenefits += npv;
	        System.out.println("NPV for year " + i + " : " + npv);
	      
	    }
	    double costRatio = costratio(initial_investment, totalBenefits);
	    System.out.println("Total Benefits over " + projectDuration + " Years: "+ totalBenefits);



	}
}
