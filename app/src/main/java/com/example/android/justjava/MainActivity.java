package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edittext_name;
    CheckBox checkbox_wipped_cream , checkbox_chocolate ;
    TextView quantity_tv , price_tv;
    Button  btn_minus , btn_plus , btn_submit;
    boolean addWipped , addChocolate;
    int numberOfCoffes = 1;
    int basePrice = 5;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_submit:
                displayQuantitiy(numberOfCoffes);
                displayPrice(numberOfCoffes);
                break;

            case R.id.btn_plus:
                if(numberOfCoffes < 100){
                    numberOfCoffes ++;
                    displayQuantitiy(numberOfCoffes);
                    displayPrice(-1);
                }
                break;

            case R.id.btn_minus :
                if(numberOfCoffes > 1){
                    numberOfCoffes --;
                    displayQuantitiy(numberOfCoffes);
                    displayPrice(-1);
                }
                break;
        }
    }





    public void displayQuantitiy(int number){
        quantity_tv.setText("" + number);
    }




    public void displayPrice(int number){
        //  price_tv.setText(NumberFormat.getCurrencyInstance().format(number));
        if (number == -1){
            price_tv.setText("");
        }else{
                basePrice = 5;
                addWipped = checkbox_wipped_cream.isChecked();
                addChocolate = checkbox_chocolate.isChecked();
                name = edittext_name.getText().toString();
                if(name.length() == 0){
                    name = "Guest";
                }
                if(addWipped){
                    basePrice ++;
                }
                if(addChocolate){
                    basePrice += 2;
                }

                price_tv.setText("Name: " +  name +
                                 "\nAdded Wipped Cream: " + addWipped +
                                 "\nAdded Chocolate: " + addChocolate +
                                 "\nQuantity: " + number +
                                 "\nTotal Price: $ " + basePrice *  number +
                                 "\nThank You!");
        }
    }



    public void initViews(){
        quantity_tv = (TextView)findViewById(R.id.quantity_tv);
        price_tv = (TextView)findViewById(R.id.price_tv);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_submit = (Button)findViewById(R.id.btn_submit);
        edittext_name = (EditText)findViewById(R.id.edittext_name);
        checkbox_wipped_cream = (CheckBox)findViewById(R.id.checkbox_wipped_cream);
        checkbox_chocolate = (CheckBox)findViewById(R.id.checkbox_chocolate);

        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }




}
