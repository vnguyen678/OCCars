package edu.orangecoastcollege.cs273.vnguyen678.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton fiveYearRadioButton;
    private RadioButton fourYearRadioButton;
    private RadioButton threeYearRadioButton;

    private Car currentCar;

    private String monthlyPaymentText;
    private String loanSummaryText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText)findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText)findViewById(R.id.downPaymentEditText);
        fiveYearRadioButton = (RadioButton)findViewById(R.id.fiveYearRadioButton);
        fourYearRadioButton = (RadioButton)findViewById(R.id.fourYearRadioButton);
        threeYearRadioButton = (RadioButton)findViewById(R.id.threeYearRadioButton);
    }

    public  void activateLoanReport(View view)
    {
        double price, downPayment;
        try
        {
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());

        }
        catch (NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }
        int loanTerm;
        if(fiveYearRadioButton.isChecked())
            loanTerm = 5;
        else if(fourYearRadioButton.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        currentCar.setPrice(price);
        currentCar.setDownPayment(downPayment);
        currentCar.setLoanTerm(loanTerm);

        Intent loanSummaryIntent = new Intent(this,LoanSummaryActivity.class);
        loanSummaryIntent.putExtra("MonthyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary", loanSummaryText);
        //start the new activity
        startActivity(loanSummaryIntent);
    }

    private void constructLoanSummaryText()
    {
        monthlyPaymentText = getString(R.string.report_line1) + currentCar.calculateMonthlyPayment();
        loanSummaryText = getString(R.string.report_line2) + currentCar.getPrice();
    }

}
