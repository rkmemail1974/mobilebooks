package com.example.mobilebooks;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableRow.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class VendorsDetails extends Activity {
	SharedPreferences prefs;
	private boolean check;
	private static String flag;
	Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vendors_details);
		prefs = CompleteDetails.applicationContext.getSharedPreferences(
				"com.example.mobilebooks", MODE_WORLD_WRITEABLE);
		check = prefs.getBoolean(Preferences.BUY, false);
		if (check) {
//			cursor = EntryActivity.dbHelper.getVendorsList(
//					CompleteDetails.searchIndex, "Buy");
			flag = "buy";
			System.out.println("Buy");

		} else {
			check = prefs.getBoolean(Preferences.SELL, false);
			if (check) {
//				cursor = EntryActivity.dbHelper.getVendorsList(
//						CompleteDetails.searchIndex, "Sell");
				flag = "sell";
				System.out.println("SELL");

			} else {
//				cursor = EntryActivity.dbHelper.getVendorsList(
//						CompleteDetails.searchIndex, "Rent");
				System.out.println("RENT");
				flag = "rent";
			}
		}
		RelativeLayout tableLayout = (RelativeLayout) findViewById(R.id.tableLayout);
		cursor.moveToFirst();
		int count = cursor.getCount();
		cursor.moveToFirst();
		for (int i = 0; i < count; i++) {
			addTableRow(tableLayout);
		}
	}

	public void addTableRow(View v) {
		TableLayout tl = (TableLayout) findViewById(R.id.vendors);
		TableRow tr = new TableRow(this);
		LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		tr.setLayoutParams(lp);

		TextView first = new TextView(this);
		first.setLayoutParams(lp);
		first.setBackgroundColor(Color.WHITE);
		first.setText(cursor.getString(4));
		first.setPadding(45, 45, 45, 45);
		TextView third = new TextView(this);
		third.setLayoutParams(lp);
		third.setBackgroundColor(Color.WHITE);
		if (flag.contains("buy")) {
			third.setText(cursor.getString(6));

		} else if (flag.contains("sell")) {
			third.setText(cursor.getString(7));

		} else if (flag.contains("rent")) {
			third.setText(cursor.getString(8));

		}
		third.setPadding(45, 45, 45, 45);

		TextView second = new TextView(this);
		second.setLayoutParams(lp);
		second.setBackgroundColor(Color.WHITE);
		second.setText(cursor.getString(5));
		second.setPadding(45, 45, 45, 45);

		TextView fourth = new TextView(this);
		fourth.setLayoutParams(lp);
		fourth.setBackgroundColor(Color.WHITE);
		fourth.setText(cursor.getString(8));
		fourth.setPadding(45, 45, 45, 45);

		tr.addView(first);

		tr.addView(third);
		tr.addView(second);
		tr.addView(fourth);
		tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));
		cursor.moveToNext();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vendors_details, menu);
		return true;
	}

}
