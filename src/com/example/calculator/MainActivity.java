package com.example.calculator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends FragmentActivity implements OnClickListener {
	
	private Button button_0;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;
	private Button button_8;
	private Button button_9;
	private Button button_clear;
	private Button button_delete;
	private Button button_divide;
	private Button button_multiply;
	private Button button_minus;
	private Button button_plus;
	private Button button_dot;
	private Button button_equals;
	private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.btn_0);
        button_1 = (Button) findViewById(R.id.btn_1);
        button_2 = (Button) findViewById(R.id.btn_2);
        button_3 = (Button) findViewById(R.id.btn_3);
        button_4 = (Button) findViewById(R.id.btn_4);
        button_5 = (Button) findViewById(R.id.btn_5);
        button_6 = (Button) findViewById(R.id.btn_6);
        button_7 = (Button) findViewById(R.id.btn_7);
        button_8 = (Button) findViewById(R.id.btn_8);
        button_9 = (Button) findViewById(R.id.btn_9);
        button_divide = (Button) findViewById(R.id.btn_divide);
        button_multiply = (Button) findViewById(R.id.btn_multiply);
        button_minus = (Button) findViewById(R.id.btn_minus);
        button_plus = (Button) findViewById(R.id.btn_plus);
        button_clear = (Button) findViewById(R.id.btn_clear);
        button_delete = (Button) findViewById(R.id.btn_delete);
        button_dot = (Button) findViewById(R.id.btn_dot);
        button_equals = (Button) findViewById(R.id.btn_equals);
        editText = (EditText) findViewById(R.id.editText1);
        
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        button_plus.setOnClickListener(this);
        button_minus.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_dot.setOnClickListener(this);
        button_equals.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		String s = editText.getText().toString();
		if (view == button_clear) {
			s = "";
		} else if (view == button_delete) {
			s = s.length() == 0 ? s : s.substring(0, s.length()-1);
		} else if (view == button_equals) {
			int index = -1;
			for (String ss : new String[] { "x", "/", "+", "-" }) {
				int tmpIndex = s.indexOf(ss);
				if (tmpIndex != -1) {
					index = tmpIndex;
					break;
				}
			}
			if (index != -1) {
				String outputFormat = "%.2f";
				try {
					double x = Double.parseDouble(s.substring(0, index));
					double y = Double.parseDouble(s.substring(index+1));
					switch (s.charAt(index)) {
						case 'x': 
							s = String.format(outputFormat, x * y);
							break;
						case '/':
							s = String.format(outputFormat, x / y);
							break;
						case '+':
							s = String.format(outputFormat, x + y);
							break;
						case '-':
							s = String.format(outputFormat, x - y);
							break;
						default: break;
					}
				} catch (Exception e) {
					s = "我只会算两个数的运算，这题我不会";
				}
			}
		} else {
			s += ((Button) view).getText() + "";
		}
		editText.setText(s);
	}

}
