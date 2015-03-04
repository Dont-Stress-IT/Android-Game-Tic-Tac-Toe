
/* Tic Tac Toe Game for andriod ( SDK Version 4.0+ )
 * Created by Russel Young, started on 9/2/2015
 * Start Game Activity thread
 */

package com.example.myfirstapp;
import java.util.Random;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartGameActivity extends ActionBarActivity implements OnClickListener {

	int x = 0;
	int[][] board = new int[3][3];{
	board[0][0] = 2;
	board[0][1] = 2;
	board[0][2] = 2;
	board[1][0] = 2;
	board[1][1] = 2;
	board[1][2] = 2;
	board[2][0] = 2;
	board[2][1] = 2;
	board[2][2] = 2;
	}
	int winner = 0;
	int turn = 0;
	Random rand = new Random();
	int player = rand.nextInt(2);  //random starting player 
	boolean click = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this); // calling onClick() method
		Button button2 = (Button) findViewById(R.id.button5);
		button2.setOnClickListener(this);
		Button button3 = (Button) findViewById(R.id.button9);
		button3.setOnClickListener(this);
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(this);
		Button button5 = (Button) findViewById(R.id.button3);
		button5.setOnClickListener(this);
		Button button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(this);
		Button button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(this);
		Button button8 = (Button) findViewById(R.id.button8);
		button8.setOnClickListener(this);
		Button button9 = (Button) findViewById(R.id.button2);
		button9.setOnClickListener(this);
		game(null);
	}							

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    public void onClick(View v) {
		/*method to id which button was clicked for human turn placement
		 * places choice in game board array and visually on the button
		 */
		
		Button myButton1 = (Button) findViewById(R.id.button1);
		Button myButton2 = (Button) findViewById(R.id.button5);
		Button myButton3 = (Button) findViewById(R.id.button9);
		Button myButton4 = (Button) findViewById(R.id.button4);
		Button myButton5 = (Button) findViewById(R.id.button3);
		Button myButton6 = (Button) findViewById(R.id.button6);
		Button myButton7 = (Button) findViewById(R.id.button7);
		Button myButton8 = (Button) findViewById(R.id.button8);
		Button myButton9 = (Button) findViewById(R.id.button2);
			
		switch (v.getId()) {
	    case R.id.button1:
	    	board[0][0] = 1;
	    	myButton1.setText("X");
	        break;
	    case R.id.button5:
	    	board[1][0] = 1;
	    	myButton2.setText("X");
	        break;
	    case R.id.button9:
	    	board[2][0] = 1;
	    	myButton3.setText("X");
	        break;
	    case R.id.button4:
	    	board[0][1] = 1;
	    	myButton4.setText("X");
	        break;
	    case R.id.button3:
	    	board[1][1] = 1;
	    	myButton5.setText("X");
	        break;
	    case R.id.button6:
	    	board[2][1] = 1;
	    	myButton6.setText("X");
	        break;
	    case R.id.button7:
	    	board[0][2] = 1;
	    	myButton7.setText("X");
	        break;
	    case R.id.button8:
	    	board[1][2] = 1;
	    	myButton8.setText("X");
	        break;
	    case R.id.button2:
	    	board[2][2] = 1;
	    	myButton9.setText("X");
	        break;
		}
		
		click = true;
		turn += 1;
		
		if (turn > 4){
			wincheck();							
		}
		player = 0;
		game(v);
    }
	
    public void game(View v){
    	/*checks for winner or end of game due to no turns remaining
    	 * If AI go to turn() method to process, if human wait for click
    	 * check for winner with wincheck()
    	 */
    	
    	if (winner == 0 && turn < 9){
			if(player == 0){
				turn();
				turn += 1;
				if (turn > 4){
					wincheck();							
				}
				player = 1;
			}
			else{
				//human turn do nothing, wait for onclick event
			}
    	}
    	else{
    		//game over
    	}
	}
	
	
	void turn() {
		/* currently easy AI code only ( this is simply a random placement every turn )
		 * AI checks that square is empty, if not chooses another square
		 */
			
		int positionX = rand.nextInt(3);
		int positionY = rand.nextInt(3);

		Button myButton1 = (Button) findViewById(R.id.button1);
		Button myButton2 = (Button) findViewById(R.id.button5);
		Button myButton3 = (Button) findViewById(R.id.button9);
		Button myButton4 = (Button) findViewById(R.id.button4);
		Button myButton5 = (Button) findViewById(R.id.button3);
		Button myButton6 = (Button) findViewById(R.id.button6);
		Button myButton7 = (Button) findViewById(R.id.button7);
		Button myButton8 = (Button) findViewById(R.id.button8);
		Button myButton9 = (Button) findViewById(R.id.button2);

				if (player == 0 ){
					while(board[positionX][positionY] != 2){
						positionX = rand.nextInt(3);
						positionY = rand.nextInt(3);
					}
					board[positionX][positionY] = 0;	
					
					if(positionX == 0 && positionY == 0){
						myButton1.setText("O");
					}
					else if(positionX == 1 && positionY == 0){
						myButton2.setText("O");
					}
					else if(positionX == 2 && positionY == 0){
						myButton3.setText("O");
					}
					else if(positionX == 0 && positionY == 1){
						myButton4.setText("O");
					}
					else if(positionX == 1 && positionY == 1){
						myButton5.setText("O");
					}
					else if(positionX == 2 && positionY == 1){
						myButton6.setText("O");
					}
					else if(positionX == 0 && positionY == 2){
						myButton7.setText("O");
					}
					else if(positionX == 1 && positionY == 2){
						myButton8.setText("O");
						}
					else if(positionX == 2 && positionY == 2){
						myButton9.setText("O");
						}	
					click = false;
				}
				else{
						//human or ai
				}
			}
	
	public void wincheck (){
		/*checks for a winner and displays winner
		 */
		Button myButton10 = (Button) findViewById(R.id.button10);
		
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player){
			winner = 1;
		}
		else if(board[0][0] == player && board[1][0] == player && board[2][0] == player){
			winner = 1;
		}
		else if(board[0][1] == player && board[1][1] == player && board[2][1] == player){
			winner = 1;
		}
		else if(board[1][0] == player && board[1][1] == player && board[1][2] == player){
			winner = 1;
		}
		else if(board[2][0] == player && board[2][1] == player && board[2][2] == player){
			winner = 1;
		}
		else if(board[0][2] == player && board[1][2] == player && board[2][2] == player){
			winner = 1;
		}
		else if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
			winner = 1;
		}
		else if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
			winner = 1;
			}
		if(winner == 1){
			if(player == 0){
				myButton10.setText("winner is O");
			}
			else{
				myButton10.setText("winner is X");
			}
		}	
	}	
}
