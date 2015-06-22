package com.kaymannsoft.kmaps.gui;


import com.kaymannsoft.kmaps.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OptionKsolveActivity extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	Button selectionAccept;
	RadioGroup selectFormMap;
	TextView backgroundMaps,forInputExpl;
	static int option=2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choosse_form_input);
		initialize();
	}
	public void initialize(){
		option=1;
		selectionAccept=(Button)findViewById(R.id.button1);
		selectFormMap=(RadioGroup)findViewById(R.id.radioGroup1);
		backgroundMaps=(TextView)findViewById(R.id.textView1);
		selectionAccept.setOnClickListener(this);
		backgroundMaps.setOnClickListener(this);
		forInputExpl.setOnClickListener(this);
		selectFormMap.setOnCheckedChangeListener(this);
		backgroundMaps.setText(" Chosse de form of input for minimize the map");
		forInputExpl.setText("For use as input a Logical Equation");
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){	
		case R.id.button1:
			switch(option){
				case 1://Aqui abro la activity Equation
					Intent b=new Intent(OptionKsolveActivity.this,ParamsActivity.class);
					Bundle extra2=new Bundle();
					extra2.putInt("entrada",2);
					b.putExtras(extra2);//Para entrada mapa, 0
										//Para entrada tabla, 1
										//Para entrada funcion, 2
					
					startActivity(b);
					break;
				case 2://Aqui abro la activity MAps Form
					Intent a=new Intent(OptionKsolveActivity.this,ParamsActivity.class);
					Bundle extras=new Bundle();
					extras.putInt("entrada", 0);//Para entrada mapa, 0
												//Para entrada tabla, 1
												//Para entrada funcion, 2
					a.putExtras(extras);
					startActivity(a);
					break;
				case 3://Aqui abro la activity TruthTable
					Intent a1=new Intent(OptionKsolveActivity.this,ParamsActivity.class);
					Bundle extras1=new Bundle();
					extras1.putInt("entrada", 1);//Para entrada mapa, 0
												//Para entrada tabla, 1
												//Para entrada funcion, 2
					a1.putExtras(extras1);
					startActivity(a1);
					break;
			}
			break;
		case R.id.textView1:
			break;
		
	}
		
	}
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		forInputExpl.setText("hola");
		switch(arg1){
			case R.id.radio0:
				option=1;
				forInputExpl.setText("For use as input a Logical Equation");
				break;
			case R.id.radio1:
				option=2;
				forInputExpl.setText("For use as input a Karnough Map");
				break;
			case R.id.radio2:
				option=3;
				forInputExpl.setText("For use as input a Truth Table");
				break;
		}
		
	}
	

}
