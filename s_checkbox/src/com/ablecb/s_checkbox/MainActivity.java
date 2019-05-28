package com.ablecb.s_checkbox;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends ActionBarActivity {
	private List<CheckBox> list=new ArrayList();
	CheckBox all=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CheckBox eat=(CheckBox)findViewById(R.id.eat);
		CheckBox sleep=(CheckBox)findViewById(R.id.sleep);
		CheckBox game=(CheckBox)findViewById(R.id.game);
		all=(CheckBox)findViewById(R.id.all);
		list.add(eat);
		list.add(sleep);
		list.add(game);
		
		for(int i=0;i<list.size();i++){
			list.get(i).setOnCheckedChangeListener(new item());
		}
		all.setOnCheckedChangeListener(new allListener());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class allListener implements OnCheckedChangeListener{

		
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			for(int i=0;i<list.size();i++){
				list.get(i).setChecked(isChecked);
			}
			
		}
		
	}
	class item implements OnCheckedChangeListener{

		
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			System.out.println(isChecked);
			if(list.get(0).isChecked()==true&&list.get(1).isChecked()==true&&list.get(2).isChecked()==true){
				all.setChecked(true);
			}else {
				boolean[] isC=new boolean[3];
				for(int i=0;i<list.size();i++){
					isC[i]=list.get(i).isChecked();
				}
				all.setChecked(false);
				for(int i=0;i<list.size();i++){
					list.get(i).setChecked(isC[i]);
				}
			}
			
			
		}
		
	}
}
