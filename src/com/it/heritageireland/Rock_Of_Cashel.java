package com.it.heritageireland;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

public class Rock_Of_Cashel extends Activity{
	
	DatabaseHelper  databaseHelper;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rock);
		Button share = (Button) findViewById(R.id.share);
		share.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Adare.Share(Rock_Of_Cashel.this, "Rock Of Cashel","St. Patrick Rock");	
				
			}
			
		});
		Button directions = (Button) findViewById(R.id.directions);
        directions.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	WebView web;
            	web = new WebViewHelper().webview(Rock_Of_Cashel.this);
                // specify the URL we want to load
                web.loadUrl("http://maps.google.com/maps?saddr=Current%20Location&daddr=52.5201906, -7.8899549");
                setContentView(web);
             }
        });
			//	52.5201906 -7.8899549
        
        Button Fav = (Button) findViewById(R.id.add);
        Fav.setOnClickListener(new OnClickListener() {
        	
            public void onClick(View agrs) {
            	String Rock_Of_Cashel = "Rock_Of_Cashel";
            	// Below is the adding to the db code
            	databaseHelper = new DatabaseHelper(Rock_Of_Cashel.this, null,null, 1);
            	Products product = new Products(Rock_Of_Cashel.toString());
            	databaseHelper.addProduct(product);
            	new AlertDialog.Builder( Rock_Of_Cashel.this )
                .setIcon(R.drawable.favs)
                .setTitle( "Added to Favourites" )
                .setPositiveButton( "Awsome!!!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d( "AlertDialog", "Positive" );
                    }
           
                } )
                
                .show();
            
             }
        });
        
        
	}
}