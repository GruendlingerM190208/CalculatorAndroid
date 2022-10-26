package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculator.arithmeticutils.PostFixCalculator;
import com.example.calculator.arithmeticutils.PostFixConverter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<Button> buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b0 = findViewById(R.id.button0);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b9 = findViewById(R.id.button9);
        Button klAu = findViewById(R.id.klammerAuf);
        Button klZu = findViewById(R.id.klammerZu);
        Button bPunkt = findViewById(R.id.buttonKomma);
        Button bClear = findViewById(R.id.buttonClear);
        Button bGleich = findViewById(R.id.buttonCalc);
        Button bDiv = findViewById(R.id.buttonDiv);
        Button bMul = findViewById(R.id.buttonMul);
        Button bSub = findViewById(R.id.buttonSub);
        Button bAdd = findViewById(R.id.buttonAdd);
        buttons.add(b0);
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);
        buttons.add(klAu);
        buttons.add(klZu);
        buttons.add(bPunkt);
        buttons.add(bClear);
        buttons.add(bGleich);
        buttons.add(bDiv);
        buttons.add(bMul);
        buttons.add(bSub);
        buttons.add(bAdd);

        for (Button b : buttons) {
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button b = findViewById(view.getId());
        TextView textView_Output = findViewById(R.id.textView_Output);
        if (b.getText().equals("CLEAR")) {
            textView_Output.setText("");
        } else if (b.getText().equals("=")) {
            PostFixConverter postFixCalculator = new PostFixConverter(textView_Output.getText().toString());
            String infix = textView_Output.getText().toString();
            String postfix = postFixCalculator.getPostfixExpression();
            System.out.println(infix);
            System.out.println(postfix);
            textView_Output.setText(new PostFixCalculator(postfix).getResult().toString());
        } else {
            textView_Output.append(b.getText());
        }
    }
}