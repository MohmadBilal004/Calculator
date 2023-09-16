package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView resultTv, solutionTv;
    MaterialButton button_C, button_AC, button_open_bracket, button_close_bracket;
    MaterialButton  button_divide,button_multiply,button_add, button_substract, button_dot,button_equal;
    MaterialButton button_8, button_9, button_7, button_6,button_5,button_4,button_3, button_2, button_1, button_0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignId(button_C , R.id.button_C);
        assignId(button_AC , R.id.button_AC);
        assignId(button_open_bracket , R.id.button_open_bracket);
        assignId(button_close_bracket , R.id.button_close_bracket);
        assignId(button_equal , R.id.button_equal);
        assignId(button_dot , R.id.button_dot);
        assignId(button_add , R.id.button_plus);
        assignId(button_substract , R.id.button_subtract);
        assignId(button_multiply , R.id.button_multiply);
        assignId(button_divide , R.id.button_divide);
        assignId(button_0 , R.id.button_0);
        assignId(button_1 , R.id.button_1);
        assignId(button_2 , R.id.button_2);
        assignId(button_3 , R.id.button_3);
        assignId(button_4 , R.id.button_4);
        assignId(button_5 , R.id.button_5);
        assignId(button_6 , R.id.button_6);
        assignId(button_7 , R.id.button_7);
        assignId(button_8 , R.id.button_8);
        assignId(button_9 , R.id.button_9);
    }

    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText =  button.getText().toString();
        String datatoCalculate = solutionTv.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }

        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }
        if(buttonText.equals("C")){
            datatoCalculate = datatoCalculate.substring(0,datatoCalculate.length() -1);
        }else{
            datatoCalculate = datatoCalculate+buttonText;
        }

        solutionTv.setText(buttonText);
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String Result = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return Result;
        } catch (Exception e) {
            return "ERR";
        }
    }
}