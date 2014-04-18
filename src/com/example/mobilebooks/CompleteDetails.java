package com.example.mobilebooks;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CompleteDetails extends Activity implements OnClickListener {
	public static String searchIndex;
	TextView heading, bookName, bookPrice, bookEdition, bookAuthor,
			newAvailabel, usedAvailabel;
	ImageView bookImage;
	Button buy, sell, rent;
	private SharedPreferences prefs;
	public static Context applicationContext;
	public static String heading_ ,bookName_ , bookAuthor_ , bookPrice_ ,bookEdition_ ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complete_details);
		searchIndex = getIntent().getStringExtra(BookLists.SEARCH);
		heading = (TextView) findViewById(R.id.heading);
		bookName = (TextView) findViewById(R.id.bookName);
		bookAuthor = (TextView) findViewById(R.id.bookAuthor);
		bookEdition = (TextView) findViewById(R.id.bookEdition);
		bookPrice = (TextView) findViewById(R.id.bookPrice);
		usedAvailabel = (TextView) findViewById(R.id.used_available);
		newAvailabel = (TextView) findViewById(R.id.new_available);

		buy = (Button) findViewById(R.id.buy);

		sell = (Button) findViewById(R.id.sell);

		rent = (Button) findViewById(R.id.rent);
		applicationContext = getApplicationContext();
		prefs = applicationContext.getSharedPreferences(
				"com.example.mobilebooks", MODE_WORLD_WRITEABLE);

//		Cursor allBooks = EntryActivity.dbHelper.getSpecifiedBook(searchIndex);
//		Cursor completeList = EntryActivity.dbHelper
//				.getCompleteDetails(searchIndex);
//		Log.e("all books cursor is adn complete list is respectively ",allBooks.getCount()+ " "+ completeList.getCount());
//
//		allBooks.moveToFirst();
//		completeList.moveToFirst();
//		if (allBooks == null || completeList == null) {
//			Log.e("Seartch 	is ", "  " + searchIndex);
//
//		} else if (completeList.getCount() < 1  ) {
//			Log.e("Seartch 	is ", "  " + searchIndex);
//
//		} else{
//			Log.e("Anser cursor is not null ", "  " + searchIndex);
//
//			allBooks.moveToFirst();
//		completeList.moveToFirst();
		heading.setText(bookName_);
		bookName.setText(bookName_);
		bookAuthor.setText(bookAuthor_);
		bookPrice.setText(bookPrice_);
		//bookPrice.setText(20);

//		Log.d("cursor is not null ", "  " + completeList.getCount());
//		usedAvailabel.setText(completeList.getString(3));

//		newAvailabel.setText(completeList.getString(4));
//		bookEdition.setText("Edition : " + completeList.getString(6));
//		bookPrice.setText("Price : " + completeList.getString(1));
//		// Log.d("cursor is not null ","  "+bookDetails.getString(5));
		// // bookName = cursor.getString(0);
		buy.setOnClickListener(this);
		sell.setOnClickListener(this);
		rent.setOnClickListener(this);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complete_details, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Intent vendorsActivity;
		vendorsActivity = new Intent(CompleteDetails.this, VendorsDetails.class);
		switch (v.getId()) {
		case R.id.buy:
			prefs.edit().putBoolean(Preferences.RENT, false).commit();
			prefs.edit().putBoolean(Preferences.BUY, true).commit();
			prefs.edit().putBoolean(Preferences.SELL, false).commit();
			startActivity(vendorsActivity);
			break;
		case R.id.sell:

			prefs.edit().putBoolean(Preferences.RENT, false).commit();
			prefs.edit().putBoolean(Preferences.BUY, false).commit();
			prefs.edit().putBoolean(Preferences.SELL, true).commit();

			startActivity(vendorsActivity);
			break;
		case R.id.rent:
			prefs.edit().putBoolean(Preferences.RENT, true).commit();
			prefs.edit().putBoolean(Preferences.BUY, false).commit();
			prefs.edit().putBoolean(Preferences.SELL, false).commit();

			startActivity(vendorsActivity);
			break;

		}
	}
	
	
	}
