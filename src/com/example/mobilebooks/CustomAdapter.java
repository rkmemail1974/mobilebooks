package com.example.mobilebooks;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	String[] message, bookAuthor, price;
	Context context;

	CustomAdapter(String[] message, String[] bookAuthor, String[] price,
			Context context) {
		this.context = context;
		this.bookAuthor = bookAuthor;
		this.message = message;
		 this.price = price;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bookAuthor.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v;
		Handler handler = new Handler();
		v = convertView;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (v == null) {
			v = inflater.inflate(R.layout.listview, null);
			handler.book_name = (TextView) v.findViewById(R.id.book_name);
			handler.book_author = (TextView) v.findViewById(R.id.book_author);
			handler.book_image = (ImageView) v.findViewById(R.id.book_image);
			handler.price = (TextView) v.findViewById(R.id.price);
//			if (price[position].equalsIgnoreCase("") || price[position] == null) {
			
//			}
			try{
			handler.book_author.setText(bookAuthor[position]);
			handler.book_name.setText(message[position]);
			handler.book_image.setImageResource(R.drawable.ic_launcher);
		Log.d("checking price[posiotn in custom adaper", price[position]);
			handler.price.setText( price[position]);
			v.setTag(handler);
		}catch(NullPointerException n)
		{	
			handler.price.setText(" $$");
		}
		}

		else {
			handler = (Handler) v.getTag();
		}
		return v;
	}

	public class Handler {
		TextView book_name, book_author, price;
		ImageView book_image;

	}

}
