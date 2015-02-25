
/* Tic Tac Toe Game for andriod ( SDK Version 4.0+ )
 * Created by Russel Young, started on 9/2/2015
 * Start Game Activity thread
 */

package com.example.myfirstapp;

import java.util.Arrays;
import java.util.Random;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class StartGameActivity extends ActionBarActivity {

	//@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_game);
		
		final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });
		this.game(null);
	}							

	//@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_game, menu);
		return true;
	}

//@Override
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
	
	public void game(View view){
		/* Creates an empty game board
		 * Randomises to determine a starting player
		 * Calls turn() to begin game
		 * Checks for possible winner after 3 turns
		 * Halts game on winner
		 */
				
		int x = 3;
		int[][] board = new int[x][x];
		board[0][0] = 2;
		board[0][1] = 2;
		board[0][2] = 2;
		board[1][0] = 2;
		board[1][1] = 2;
		board[1][2] = 2;
		board[2][0] = 2;
		board[2][1] = 2;
		board[2][2] = 2;
		
		Random rand = new Random();
		int player = rand.nextInt(2);
		turn(player, board);
	}
	
	
	
	void turn(int player, int board[][]) {
		/* player's move placed on game board, currently automated as easy AI vs easy AI 
		 * ( this is simply a random placement every turn )
		 * checks that square is empty, if not chooses another square, keeps track of turns,
		 * updates GUI after move to display the change (currently testing, errors found)
		 * calls winner() after 3 turns to check for a winner
		 * halts game if winner found or if the board is full and no more turns are possible
		 */
			
		Random rand = new Random();
		int positionX = rand.nextInt(3);
		int positionY = rand.nextInt(3);
		int turn = 0;
		int winner = 0;
		
		Button myButton1 = (Button) findViewById(R.id.button1);
		Button myButton2 = (Button) findViewById(R.id.button5);
		Button myButton3 = (Button) findViewById(R.id.button9);
		Button myButton4 = (Button) findViewById(R.id.button4);
		Button myButton5 = (Button) findViewById(R.id.button3);
		Button myButton6 = (Button) findViewById(R.id.button6);
		Button myButton7 = (Button) findViewById(R.id.button7);
		Button myButton8 = (Button) findViewById(R.id.button8);
		Button myButton9 = (Button) findViewById(R.id.button2);
		
		
		while (winner == 0 && turn <9){
			if (board[positionX][positionY] == 2){
				if (player == 0 ){
					board[positionX][positionY] = 0;	
					turn += 1;
					
					//button gui test
					if(positionX == 0 && positionY == 0){
						myButton1.setText("O");
					}
					else if(positionX == 0 && positionY == 1){
						myButton2.setText("O");
					}
					else if(positionX == 0 && positionY == 2){
						myButton3.setText("O");
					}
					else if(positionX == 1 && positionY == 0){
						myButton4.setText("O");
					}
					else if(positionX == 1 && positionY == 1){
						myButton5.setText("O");
					}
					else if(positionX == 1 && positionY == 2){
						myButton6.setText("O");
					}
					else if(positionX == 2 && positionY == 0){
						myButton7.setText("O");
					}
					else if(positionX == 2 && positionY == 1){
						myButton8.setText("O");
						}
					else if(positionX == 2 && positionY == 2){
						myButton9.setText("O");
						}	
					
					if (turn > 1){															
						winner = wincheck(board,player,turn);
					}
					player = 1;
				}
				else{
					board[positionX][positionY] = 1;
					turn += 1;
					
					// button gui test
					if(positionX == 0 && positionY == 0){
						myButton1.setText("X");
					}
					else if(positionX == 0 && positionY == 1){
						myButton2.setText("X");
					}
					else if(positionX == 0 && positionY == 2){
						myButton3.setText("X");
					}
					else if(positionX == 1 && positionY == 0){
						myButton4.setText("X");
					}
					else if(positionX == 1 && positionY == 1){
						myButton5.setText("X");
					}
					else if(positionX == 1 && positionY == 2){
						myButton6.setText("X");
					}
					else if(positionX == 2 && positionY == 0){
						myButton7.setText("X");
					}
					else if(positionX == 2 && positionY == 1){
						myButton8.setText("X");
						}
					else if(positionX == 2 && positionY == 2){
						myButton9.setText("X");
						}	
						
					if (turn > 2){
						winner = wincheck(board,player,turn);								
					}
					player = 0;
				}
			}
			else{
				positionX = rand.nextInt(3);
				positionY = rand.nextInt(3);
			}
			
		/*	try {
			  Thread.sleep(500);
			} catch (InterruptedException ie) {
			    //Handle exception
			}*/	
		}
	}
	
	public static int wincheck (int[][] board, int player, int turn){
		//check for a winner and returns winner status
		
		int winner = 0;
		
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
	
	//	if (winner == 1){
	//	}
		return winner;
		
	}
}
