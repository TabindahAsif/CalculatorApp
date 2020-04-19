package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Addbtn;
    Button Clearbtn;
    Button Equalbtn;
    Button Mltiplybtn;
    TextView ScreenResult;
    Button Subtractionbtn;
    Button dividebtn;
    Button dot;
    Button eight;
    Button five;
    Button four;
    Button nine;
    Button one;
    Button seven;
    Button six;
    Button three;
    Button two;
    Button zero;

    class BtnController implements OnClickListener {
        BtnController() {
        }

        public void onClick(View v) {
            try {
                String toAppend=ScreenResult.getText().toString();
                switch (v.getId()) {
                    case R.id.Addbtn:
                        toAppend += "+";
                        break;
                    case R.id.Dividebtn:
                        toAppend += "/";
                        break;
                    case R.id.Dot:
                        toAppend += ".";
                        break;
                    case R.id.Eight:
                        toAppend += "8";
                        break;
                    case R.id.Five:
                        toAppend += "5";
                        break;
                    case R.id.Four:
                        toAppend += "4";
                        break;
                    case R.id.Multiplybtn:
                        toAppend += "*";
                        break;
                    case R.id.Nine:
                        toAppend += "9";
                        break;
                    case R.id.One:
                        toAppend += "1";
                        break;
                    case R.id.Seven:
                        toAppend += "7";
                        break;
                    case R.id.Six:
                        toAppend += "6";
                        break;
                    case R.id.Subtractionbtn:
                        toAppend += "-";
                        break;
                    case R.id.Three:
                        toAppend += "3";
                        break;
                    case R.id.Two:
                        toAppend += "2";
                        break;
                    case R.id.zerobtn:
                        toAppend += "0";
                        break;
                }
                ScreenResult.setText(toAppend);
            } catch (Exception e) {

            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        BtnController btnC = new BtnController();
        this.ScreenResult = findViewById(R.id.ScreenResult);
        this.one = (Button) findViewById(R.id.One);
        this.one.setOnClickListener(btnC);
        this.two = (Button) findViewById(R.id.Two);
        this.two.setOnClickListener(btnC);
        this.three = (Button) findViewById(R.id.Three);
        this.three.setOnClickListener(btnC);
        this.four = (Button) findViewById(R.id.Four);
        this.four.setOnClickListener(btnC);
        this.five = (Button) findViewById(R.id.Five);
        this.five.setOnClickListener(btnC);
        this.six = (Button) findViewById(R.id.Six);
        this.six.setOnClickListener(btnC);
        this.seven = (Button) findViewById(R.id.Seven);
        this.seven.setOnClickListener(btnC);
        this.eight = (Button) findViewById(R.id.Eight);
        this.eight.setOnClickListener(btnC);
        this.nine = (Button) findViewById(R.id.Nine);
        this.nine.setOnClickListener(btnC);
        this.zero = (Button) findViewById(R.id.zerobtn);
        this.zero.setOnClickListener(btnC);
        this.dot = (Button) findViewById(R.id.Dot);
        this.dot.setOnClickListener(btnC);
        this.Mltiplybtn = (Button) findViewById(R.id.Multiplybtn);
        this.Mltiplybtn.setOnClickListener(btnC);
        this.Addbtn = (Button) findViewById(R.id.Addbtn);
        this.Addbtn.setOnClickListener(btnC);
        this.Subtractionbtn = (Button) findViewById(R.id.Subtractionbtn);
        this.Subtractionbtn.setOnClickListener(btnC);
        this.dividebtn = (Button) findViewById(R.id.Dividebtn);
        this.dividebtn.setOnClickListener(btnC);
        this.Clearbtn = (Button) findViewById(R.id.Clear);
        this.Clearbtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ScreenResult.setText("");
            }
        });
        this.Equalbtn = (Button) findViewById(R.id.Equalbtn);
        this.Equalbtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String expression = "";
                expression += ScreenResult.getText();
                String[] values = expression.split("[\\+\\-\\*\\/]");
                Double res = 0d;
                Double val1 = Double.parseDouble(values[0]);
                Double val2 = Double.parseDouble(values[1]);
                if (expression.indexOf('+') != -1) {
                    res = val1 + val2;
                } else if (expression.indexOf('-') != -1) {
                    res = val1 - val2;
                } else if (expression.indexOf('*') != -1) {
                    res = val1 * val2;
                } else if (expression.indexOf('/') != -1) {
                    res = val1 / val2;
                }
                String result = "";
                result += expression;
                result += "\n=";
                result += res.toString();
                ScreenResult.setText(result);
            }
        });
    }
}
