package com.example.mobilebooks;
import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;
import android.content.res.Configuration;

public class MyApplication extends Application {
	private static MyApplication singleton;
	
	public MyApplication getInstance() {
		return singleton;
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
 
	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
		Parse.initialize(this, "fjASsIzZ2fMgGbd2DPrhrUInl0UbJqUn4F82AaVq", "LelxOUQIyqtgoqxaCnoyY7XEEUnbBtg8NW7QzpYK");
		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "bar");
		testObject.saveInBackground();

	}
 
	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
 
	@Override
	public void onTerminate() {
		super.onTerminate();
	}
 
}
