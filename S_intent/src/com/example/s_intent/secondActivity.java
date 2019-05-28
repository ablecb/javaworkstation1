package com.example.s_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.second);
		TextView text=(TextView)findViewById(R.id.text);
		Intent intent=getIntent();
		int age=intent.getIntExtra("package com.example.s_intent.Age", -1);
		String name=intent.getStringExtra("package com.example.s_intent.Name");
		text.setText(age+":"+name);
	}
}
