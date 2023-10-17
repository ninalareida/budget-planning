package budgetPlanning;

import java.util.List;

public class HandleData {

	private String month;
	private int day;
	private Boolean expenses;
	private double value;

	public HandleData() {

	}

	public HandleData(String month, int day, Boolean expenses, double value) {
		super();
		this.month = month;
		this.day = day;
		this.expenses = expenses;
		this.value = value;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Boolean getExpenses() {
		return expenses;
	}

	public void setExpenses(Boolean expenses) {
		this.expenses = expenses;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public List showFullData() {
		Data data = new Data();
		DataContainer myObject = data.gson.fromJson(data.jsonString, DataContainer.class);
		List<HandleData> dataList = myObject.getData();
		for (HandleData item : dataList) {
			System.out.println("Month: " + item.getMonth());
			System.out.println("Day: " + item.getDay());
			System.out.println("Expenses: " + item.getExpenses());
			System.out.println("Value: " + item.getValue());
			System.out.println();
		}
		return dataList;
	}

	public List getSumOfBalanceOfMonth() {
		String balance;
		double income = 0;
		double expenses = 0;
		double incomePlus = 0;
		double expensesPlus = 0;
		
		Data data = new Data();
		DataContainer myObject = data.gson.fromJson(data.jsonString, DataContainer.class);
		List<HandleData> dataList = myObject.getData();
		for (HandleData item : dataList) {
			if (item.getExpenses() == true) {
				System.out.println("TRUUEEEE");
				System.out.println(item.getExpenses());
				System.out.println(item.getValue());
				incomePlus = item.getValue();
				
				income = income + incomePlus;
			}
			
			if (item.getExpenses() == false) {
				System.out.println("-------------FALSEEEEEE");
				System.out.println(item.getExpenses());
				System.out.println(item.getValue());
				expensesPlus = item.getValue();
				
				expenses = expenses + expensesPlus;
			}
			

		}
		System.out.println("Income: " + income);
		System.out.println("Expenses: " + expenses);
		return dataList;

	}
}
