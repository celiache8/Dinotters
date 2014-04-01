package com.example.squirrelnote;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class ChecklistActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.list_main);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	  switch (item.getItemId())
	  {
	  case android.R.id.home:
		  NavUtils.navigateUpFromSameTask(this);
		  return true;
	  default:
		  return super.onOptionsItemSelected(item);
	  }
	}
}
