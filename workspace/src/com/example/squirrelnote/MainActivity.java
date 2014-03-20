package com.example.squirrelnote;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	// After the add button is pressed,
	// allow user to choose either adding a note or a list
	// use a dialog

	public void showDialog(View v){
		final CharSequence[] items = {"CheckList", "Note"};
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a type");
		builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {}
		});
		
		builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				if("Checklist".equals(items[which]))
				{
					Intent intentCheck = new Intent(MainActivity.this, ListActivity.class);
					MainActivity.this.startActivity(intentCheck);
					Log.i("Content "," CheckList Layout ");
				}
				else if("Note".equals(items[which]))
				{
					Intent intentNote = new Intent(MainActivity.this, NoteActivity.class);
					MainActivity.this.startActivity(intentNote);
					Log.i("Content "," Note Layout ");
				}
				
				
			}
		});
    	builder.show();
	}
}
