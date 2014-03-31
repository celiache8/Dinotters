package com.example.squirrelnote;

import android.app.Activity;
import android.os.Bundle;

public class NoteActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.note_main);
	}
}
