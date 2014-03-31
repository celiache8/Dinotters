package com.example.squirrelnote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
	//Notes table and columns
	public static final String TABLE_NOTES = "notesTable";
	public static final String NOTE_ID = "_id";
	public static final String NOTE_TYPE = "noteType";
	
	//Notes items table and columns
	public static final String TABLE_NOTE_ITEMS = "noteItemsTable";
	public static final String NOTE_PARENT_ID = "noteParentID";
	public static final String NOTE_TITLE = "noteTitle";
	public static final String NOTE_DATA = "noteData";
	
	//Check list items table and columns
	public static final String TABLE_CHECKLIST_ITEMS = "checklistItemsTable";
	public static final String CHECKLIST_PARENT_ID = "checklistParentID";
	public static final String CHECKLIST_TITLE = "checklistTitle";
	public static final String CHECKLIST_ITEM_DATA = "checklistData";
	public static final String CHECKLIST_ITEM_CHECKED = "isChecked";
	
	private static final String DATABASE_NAME = "notes.db";
	private static final int DATABASE_VERSION = 1;
	
	//Table creation SQL statements
	private static final String NOTES_TABLE_CREATE = "create table "
			+ TABLE_NOTES + "(" + NOTE_ID
			+ " integer primary key autoincrement, " + NOTE_TYPE
			+ " integer not null);";
	
	private static final String NOTE_ITEMS_TABLE_CREATE = "create table "
			+ TABLE_NOTE_ITEMS + "(" 
			+ NOTE_PARENT_ID + " integer, " 
			+ NOTE_DATA + " text not null, "
			+ NOTE_TITLE + " text not null, "
			+ "foreign key (noteParentID) references notesTable(_id));"; 
	
	private static final String CHECKLIST_ITEMS_TABLE_CREATE = "create table "
			+ TABLE_CHECKLIST_ITEMS + "("
			+ CHECKLIST_PARENT_ID + " integer, "
			+ CHECKLIST_TITLE + " text not null, "
			+ CHECKLIST_ITEM_DATA + " text not null, "
			+ CHECKLIST_ITEM_CHECKED + " integer not null, "
			+ "foreign key (checklistParentID) references notesTable(_id));";
	
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(NOTES_TABLE_CREATE);
		database.execSQL(NOTE_ITEMS_TABLE_CREATE);
		database.execSQL(CHECKLIST_ITEMS_TABLE_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + NOTES_TABLE_CREATE);
		db.execSQL("DROP TABLE IF EXISTS " + NOTE_ITEMS_TABLE_CREATE);
		db.execSQL("DROP TABLE IF EXISTS " + CHECKLIST_ITEMS_TABLE_CREATE);
		
		onCreate(db);
	}
}
