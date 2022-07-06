package com.astrosia.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText editnum1;
    EditText editnum2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editnum1 = (EditText) findViewById(R.id.editTextNumberDecimal);
        editnum2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        result = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        result.setVisibility(View.INVISIBLE);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Operators, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                btnx(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });





    }
    void btnx(int position)
    {


            btn.setOnClickListener(new View.OnClickListener() {


                public void onClick(View v) {
                    if(editnum1.getText().toString().isEmpty()||editnum2.getText().toString().isEmpty())
                    { result.setText("Number Fields Can Not be Empty");}
                    else {
                        result.setVisibility(View.VISIBLE);
                        String value = editnum1.getText().toString();
                        String value2 = editnum2.getText().toString();
                        double a = Double.parseDouble(value);
                        double b = Double.parseDouble(value2);


                        if (position == 0) {
                            double r = a + b;
                            result.setText(String.format("Answer= %.2f", r));
                        }
                        if (position == 1) {
                            double r = a - b;
                            result.setText(String.format("Answer= %.2f", r));
                        }
                        if (position == 2) {
                            double r = a * b;
                            result.setText(String.format("Answer= %.2f", r));
                        }
                        if (position == 3) {
                            double r = a / b;
                            result.setText(String.format("Answer= %.2f", r));
                        }
                    }


                }
            });

    }
}




