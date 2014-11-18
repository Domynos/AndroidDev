package com.example.procards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateTemplateCardActivity extends ActionBarActivity {

	ImageView selectedImage;  
	private Integer[] mImageIds = {
			R.drawable.carte1, R.drawable.carte2, R.drawable.carte1
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		selectedImage=(ImageView)findViewById(R.id.imageView1);
		gallery.setSpacing(1);
		gallery.setAdapter(new GalleryImageAdapter(this));

		// clicklistener for Gallery
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				//Toast.makeText(CreateCardActivity.this, "Your selected position = " + position, Toast.LENGTH_SHORT).show();
				// show the selected Image
				selectedImage.setImageResource(mImageIds[position]);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.suivant) {
			Intent myIntent = new Intent(this, CreateFormCardActivity.class);
			startActivity(myIntent);
		}
		return super.onOptionsItemSelected(item);
	}
}
