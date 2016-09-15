package edu.orangecoastcollege.cs273.vnguyen678.occars;

/**
 * Created by vnguyen678 on 9/15/2016.
 */
public class Car
{
    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    private static final double TAX_RATE = 0.08;

    public Car()
    {
        this.mDownPayment = 0.0;
        this.mLoanTerm = 0;
        this.mPrice = 0.0;
    }
    public double calculateBorrowedAmount()
    {
        return calculateTotalCost() - mDownPayment;
    }

    public double calculateInterestAmount()
    {
        return  mPrice * TAX_RATE * mLoanTerm;
    }

    public double calculateMonthlyPayment()
    {
        return calculateBorrowedAmount() / (mLoanTerm * 12)  * 0/*interest rate*/;
    }

    public  double calculateTaxAmount()
    {
        return mPrice * TAX_RATE;
    }

    public double calculateTotalCost()
    {
        return mPrice + calculateTaxAmount();
    }


    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public double getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int mLoanTerm) {
        this.mLoanTerm = mLoanTerm;
    }

    public double getDownPayment() {
        return mDownPayment;
    }

    public void setDownPayment(double mDownPayment) {
        this.mDownPayment = mDownPayment;
    }
}
