/*  
 * Tic Tac Toe Game for andriod ( SDK Version 4.0+ )
 * Created by Russel Young, started on 9/2/2015
 * Main Activity thread
 */



package com.example.myfirstapp;

import java.util.List;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


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
    
    /* Called when the user clicks the Send button and displays the inputed text as a new activity.
     * Used for testing purposes, will be removed.
     * */
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    /* Called when the user clicks the Start Game button. Starts a new blank activity */
    public void startGame(View view) {
    	
    	// Build the intent
    	  Intent gameIntent = new Intent(this, StartGameActivity.class);
    	  startActivity(gameIntent);
    	  
    	}

    /* Called when the user clicks the Internet button, checks for connection status and directs
     * to http://dontstressit.com.au
     * Used for testing purposes, will be removed.
     *  */
	public void internet(View veiw){
		
		// Build the intent
		Uri webpage = Uri.parse("http://dontstressit.com.au");
		Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
		
		// Verify it resolves
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
		boolean isIntentSafe = activities.size() > 0;
		
		// Start an activity if it's safe
		if (isIntentSafe) {
		    startActivity(webIntent);
		}

		
	}

}
