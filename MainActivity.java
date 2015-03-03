/*  
 * Tic Tac Toe Game for andriod ( SDK Version 4.0+ )
 * Created by Russel Young, started on 9/2/2015
 * Main Activity thread
 */



package com.example.myfirstapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
	 public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
        case R.id.search_src_text:
          //  openSearch();     *method not yet created
            return true;
        case R.id.action_settings:
          //  openSettings();   *method not yet created
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
    }
       
    /* Called when the user clicks the Start Game button. Starts a new activity with game code*/
    public void startGame(View view) {
    	
    	// Build the intent
    	  Intent gameIntent = new Intent(this, StartGameActivity.class);
    	  startActivity(gameIntent);
    	  
    	}



}
