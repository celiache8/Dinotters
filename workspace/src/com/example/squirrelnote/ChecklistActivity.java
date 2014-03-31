package com.example.squirrelnote;

import android.app.ListActivity;
import android.os.Bundle;

public class ChecklistActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.list_main);
	}
}
