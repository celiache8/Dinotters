package com.example.squirrelnote;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.addMenuItem:
				showDialog();
				break;
		}
		return true;
	}
	// After the add button is pressed,
	// allow user to choose either adding a note or a list
	// use a dialog

	public void showDialog(){
		final CharSequence[] items = {"Checklist", "Note"};
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a type");
		builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ListView listView = ((AlertDialog)dialog).getListView();
				int itemPosition = listView.getCheckedItemPosition();
				
				if(itemPosition == 0){
					Intent intentCheck = new Intent(MainActivity.this, ChecklistActivity.class);
					MainActivity.this.startActivity(intentCheck);
					Log.i("Content "," CheckList Layout ");
				}else {
					Intent intentNote = new Intent(MainActivity.this, NoteActivity.class);
					MainActivity.this.startActivity(intentNote);
					Log.i("Content "," Note Layout ");
				}
				
			}
		});
		
		builder.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				/*
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
				*/
				
			}
		});
    	builder.show();
	}
}
