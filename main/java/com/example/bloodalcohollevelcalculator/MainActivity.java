package com.example.bloodalcohollevelcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner alcoholChoice, genderByBirth, weight;
    String text,gender, weightStr, hoursStr;
    int genderNumber=0;
    double alcoholContent=0.0;
    public EditText hours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//drinks
        alcoholChoice = findViewById(R.id.numberOfDrinks);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numberOfDrinks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alcoholChoice.setAdapter(adapter);
        alcoholChoice.setOnItemSelectedListener(this);
        text = alcoholChoice.getSelectedItem().toString();

//gender
        genderByBirth = findViewById(R.id.genderByBirth);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource( this, R.array.genderByBirth, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderByBirth.setAdapter(adapter2);
        genderByBirth.setOnItemSelectedListener(this);
        gender = genderByBirth.getSelectedItem().toString();
       // if (gender.equals("Male"))
         //   genderNumber=1;
        //else if(gender.equals("Female"))
          //  genderNumber=2;
        //else
          //  genderNumber=1;


//        weight
        weight = findViewById(R.id.weight);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource( this, R.array.weight, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weight.setAdapter(adapter3);
       weight.setOnItemSelectedListener(this);
        weightStr = weight.getSelectedItem().toString();

        //hours
        hours = (EditText) findViewById(R.id.editText2);


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //text is number of drinks
                text = alcoholChoice.getSelectedItem().toString();
                gender = genderByBirth.getSelectedItem().toString();
                weightStr = weight.getSelectedItem().toString();


           // }
        //});


        int textNum = Integer.parseInt(text);
       // int genderNum = Integer.parseInt(gender);
                String genderNum = gender;
       // int weightNum = Integer.parseInt(weightStr);

        //New code try
            int weightNumber=0;
           switch (weightStr)
           {
               case "100 - 120":
                   weightNumber=0;
                 break;

               case "120.1 - 140":
                   weightNumber=1;
                   break;

               case "140.1 - 160":
                   weightNumber=2;
                   break;

               case "160.1 - 180":
                   weightNumber=3;
                   break;

               case "180.1 - 200":
                   weightNumber=4;
                   break;

               case "200.1 - 220":
                   weightNumber=5;
                   break;

               case "220.1 - 240":
                   weightNumber=6;
                    break;
               case ">240":
                   weightNumber=7;
                   break;

           }





                //ends new code try


        int hoursNum=Integer.parseInt(hours.getText().toString());



        // Nik's code

       // int x;

                //Declare multidimensional array for both men an women
                double[][] maleBAC = {
                        {.00, .00, .00, .00, .00, .00, .00, .00,},
                        {.04, .03, .03, .02, .02, .02, .02, .02,},
                        {.08, .06, .05, .05, .04, .04, .03, .03},
                        {.11, .09, .08, .07, .06, .06, .05, .05},
                        {.15, .12, .11, .09, .08, .08, .07, .06},
                        {.19, .16, .13, .12, .11, .09, .09, .08},
                        {.23, .19, .16, .14, .13, .11, .10, .09},
                        {.26, .22, .19, .16, .15, .13, .12, .11},
                        {.30, .25, .21, .19, .17, .15, .14, .13},
                        {.34, .28, .24, .21, .19, .17, .15, .14},
                        {.38, .31, .27, .23, .21, .19, .17, .16}
                };

                double[][] femaleBAC = {
                        {.00, .00, .00, .00, .00, .00, .00, .00,},
                        {.05, .04, .03, .03, .03, .02, .02, .02,},
                        {.09, .08, .07, .06, .05, .05, .04, .04},
                        {.14, .11, .10, .09, .08, .07, .06, .06},
                        {.18, .15, .13, .11, .10, .09, .08, .08},
                        {.23, .19, .16, .14, .13, .11, .10, .09},
                        {.27, .23, .19, .17, .15, .14, .12, .11},
                        {.32, .27, .23, .20, .18, .16, .14, .13},
                        {.36, .30, .26, .23, .20, .18, .17, .15},
                        {.41, .34, .29, .26, .23, .20, .19, .17},
                        {.45, .38, .32, .28, .25, .23, .21, .19}
                };




                //If else statements for body weight and column number
               /* if (weightNum >= 100 && weightNum < 120)
                {
                    x = 0;
                }
                else if (weightNum >= 120 && weightNum< 140)
                {
                    x = 1;
                }
                else if (weightNum >= 140 && weightNum < 160)
                {
                    x = 2;
                }
                else if (weightNum >= 160 && weightNum < 180)
                {
                    x = 3;
                }
                else if (weightNum >= 180 && weightNum < 200)
                {
                    x = 4;
                }
                else if (weightNum >= 200 && weightNum < 220)
                {
                    x = 5;
                }
                else if (weightNum >= 220 && weightNum < 240)
                {
                    x = 6;
                }
                else if (weightNum >= 240)
                {
                    x = 7;
                }
                else
                {
                    x = 0;
                }
*/
                //Calculate BAC based on gender and time since consumption
                if (genderNum.equals("Male"))
                {

                   alcoholContent= (maleBAC[textNum][weightNumber] - (0.015*hoursNum));

                }
                else if (genderNum.equals("Female"))
                {

                    alcoholContent=(femaleBAC[textNum][weightNumber] - (0.015*hoursNum));
                }

                TextView textView = findViewById(R.id.result);
                textView.setText("Your BAC is " + alcoholContent);

            }
        });
        //end nik's code

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //String selectedGender= parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
