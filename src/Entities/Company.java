package Entities;

public class Company extends TaxPayer{

    private Integer numberOfEmployees;

    public Company() {};

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int numberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public Double tax() {
        if(numberOfEmployees > 10) {
            return getAnualIncome() * 0.14;
        } else {
            return getAnualIncome() * 0.16;
        }
    }
}
