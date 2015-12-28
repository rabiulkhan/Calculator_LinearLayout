package com.rabiulkhan.calculator_linearlayout;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView display;
    float num, tempNum;
    String operation;
    //ButtonClickListener btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.textView);
        int btnList[] = {
                R.id.button_one,R.id.button_two,R.id.button_three,R.id.button_four,R.id.button_five,R.id.button_six,R.id.button_seven
                ,R.id.button_eight,R.id.button_nine,R.id.button_zero,R.id.button_plus,R.id.button_minus,R.id.button_multiply,R.id.button_division
                ,R.id.button_equal,R.id.button_point,R.id.button_cancel,R.id.button_clear

        };

        for(int id : btnList){
            View v = (View) findViewById(id);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.button_clear :
                            display.setText("0");
                            num = 0;
                            operation = "";
                            break;
                        case R.id.button_cancel :
                            num = num / 10;
                            display.setText(String.valueOf(num));
                            break;
                        case R.id.button_plus :
                            calculation("+");
                            break;
                        case R.id.button_minus :
                            calculation("-");
                            break;
                        case R.id.button_multiply :
                            calculation("*");
                            break;
                        case R.id.button_division :
                            calculation("/");
                            break;
                        case R.id.button_equal :
                            calculateResult();
                            break;
                        default:
                            String numb = ((Button) v).getText().toString();
                            getKeyBoard(numb);
                            break;
                    }
                }
            });
        }
    }

    public void calculation(String str){
        num = Float.parseFloat(display.getText().toString());
        operation = str;
        display.setText("0");
    }

    public void getKeyBoard(String str){
        String disCurrent = display.getText().toString();
        if(disCurrent.equals("0"))
            disCurrent = "";
        disCurrent = disCurrent + str;
        display.setText(disCurrent);
    }

    public void calculateResult(){
        tempNum = Float.parseFloat(display.getText().toString());
        float result = 0;
        if(operation.equals("+")){
            result = num + tempNum;
        }
        if(operation.equals("-")){
            result = num - tempNum;
        }
        if(operation.equals("*")){
            result = num * tempNum;
        }
        if(operation.equals("/")){
            result = num / tempNum;
        }
        display.setText(String.valueOf(result));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
