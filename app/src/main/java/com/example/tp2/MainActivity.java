package com.example.tp2;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText val1;
    EditText val2;
    RadioGroup radioGroup;
    TextView somme;
    Button calcul;
    String selectedButton;
    LinearLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1=findViewById(R.id.editTextText3);
        val2=findViewById(R.id.editTextText4);
        layout=findViewById(R.id.linearLayout);
        radioGroup=findViewById(R.id.radioGroup);
        somme=findViewById(R.id.textView);
        calcul=findViewById(R.id.button);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton= findViewById(checkedId);
                if (radioButton!=null) {
                    selectedButton=radioButton.getText().toString();
                }
            }
        });
        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((val1==null) || (val2==null)) {
                    somme.setText("Please add numbers !");
                } else if (selectedButton.equals("+")) {
                    Double val11=Double.parseDouble(val1.getText().toString());
                    Double val22=Double.parseDouble(val2.getText().toString());
                    Double result=val11+val22;
                    somme.setText(String.valueOf(result));
                } else if (selectedButton.equals("-")) {
                    Double val11=Double.parseDouble(val1.getText().toString());
                    Double val22=Double.parseDouble(val2.getText().toString());
                    Double result=val11-val22;
                    somme.setText(String.valueOf(result));
                } else if (selectedButton.equals("*")) {
                    Double val11=Double.parseDouble(val1.getText().toString());
                    Double val22=Double.parseDouble(val2.getText().toString());
                    Double result=val11*val22;
                    somme.setText(String.valueOf(result));
                } else if (selectedButton.equals("/")) {
                    Double val11=Double.parseDouble(val1.getText().toString());
                    Double val22=Double.parseDouble(val2.getText().toString());
                    Double result=val11/val22;
                    somme.setText(String.valueOf(result));
                }

            }
        });
    }
}
