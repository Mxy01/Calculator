package com.example.lenovo.calculator1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public  class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    Button btn_eli, btn_min, btn_div, btn_add, btn_mul, btn_equ;
    TextView tv_input;
    boolean clear_flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_min = (Button) findViewById(R.id.btn_min);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_equ = (Button) findViewById(R.id.btn_equ);
        btn_eli = (Button) findViewById(R.id.btn_eli);
        tv_input = (TextView) findViewById(R.id.tv_input);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_min.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_equ.setOnClickListener(this);
        btn_eli.setOnClickListener(this);

    }
    public void onClick(View view) {
        String str = tv_input.getText().toString();
        switch (view.getId()) {
           case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    tv_input.setText("");
                }
                tv_input.setText(str + ((Button) view).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_min:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    tv_input.getText();
                }
                tv_input.setText(str + " " + ((Button) view).getText() + " ");
                break;
            case R.id.btn_eli:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    tv_input.setText("");
                }
                tv_input.setText("");
                break;
            case R.id.btn_equ:
                getResult();

        }
    }

    private void getResult() {
        double result = 0;
        String exp = tv_input.getText().toString();
        String str1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String str2 = exp.substring(exp.indexOf(" ") + 3);
        //int num1 = Integer.parseInt(str1);
        //int num2 = Integer.parseInt(str2);
        Double num1=Double.parseDouble(str1);
        Double num2=Double.parseDouble(str2);
        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                } else
                    result = num1 / num2;
                tv_input.setText(result + "");
                break;
            default:
                result = 0;
        }
                tv_input.setText(result + " ");
        }
    }




