/*  
 * Tic Tac Toe Game for andriod ( SDK Version 4.0+ )
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_start_game);
		this.game();
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
	
	public void game(){
		/* Creates an empty game board
		 * Randomises to determine a starting player
		 * Calls turn() to begin game
		 * Checks for possible winner after 3 turns
		 * Halts game on winner
		 */
				
		int x = 3;
		int winner = 0;
		int turn = 0;
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
		int player = rand.nextInt(1);
		
		while (winner == 0 && turn <9){
			turn(player, board, turn, null);
			turn += 1;
			if(player == 1){
				player = 0;
			}
			if (turn > 2){
				winner = wincheck(board,player);								
			}
		}
	}
	
	
	
	 void turn(int player, int board[][], int turn, View z) {
		/* player's move placed on game board, currently automated as easy AI vs easy AI 
		 * ( this is simply a random placement every turn )
		 * checks that square is empty, if not chooses another square,
		 * updates GUI after move to display the change (currently testing, displays all after game finished)
		 */
			
		Random rand = new Random();
		int x = 0;
		int positionX = rand.nextInt(3);
		int positionY = rand.nextInt(3);
		x = turn;
		
		Button myButton1 = (Button) findViewById(R.id.button1);
		Button myButton2 = (Button) findViewById(R.id.button5);
		Button myButton3 = (Button) findViewById(R.id.button9);
		Button myButton4 = (Button) findViewById(R.id.button4);
		Button myButton5 = (Button) findViewById(R.id.button3);
		Button myButton6 = (Button) findViewById(R.id.button6);
		Button myButton7 = (Button) findViewById(R.id.button7);
		Button myButton8 = (Button) findViewById(R.id.button8);
		Button myButton9 = (Button) findViewById(R.id.button2);
		
		
		//easy AI code, set as player 0 for testing
		if(player == 0){
			while(x == turn){
				if (board[positionX][positionY] == 2){
					board[positionX][positionY] = 0;	
					x += 1;
					//new button gui test
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
				}
				else{
					positionX = rand.nextInt(3);
					positionY = rand.nextInt(3);
				}
		}
	}
	else{
		while(x == turn){
				
			//testing human turn placement
			//new button gui test
				
				 switch (z.getId()) {

				    case R.id.button1:
				    	board[0][0] = 1;
						myButton1.setText("X");
						x += 1;
				        break;

				    case R.id.button5:
				    	board[0][1] = 1;
						myButton2.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button9:
				    	board[0][2] = 1;
						myButton3.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button4:
				    	board[1][0] = 1;
						myButton4.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button3:
				    	board[1][1] = 1;
						myButton5.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button6:
				    	board[1][2] = 1;
						myButton6.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button7:
				    	board[2][0] = 1;
						myButton7.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button8:
				    	board[2][1] = 1;
						myButton8.setText("X");
						x += 1;
				        break;
				        
				    case R.id.button2:
				    	board[2][2] = 1;
						myButton9.setText("X");
						x += 1;
				        break;

				    default:
				        break;
				    }
			}
		}
			
		/*	try {
			  Thread.sleep(500);
			} catch (InterruptedException ie) {
			    //Handle exception
			}*/	
	}
	
	public static int wincheck (int[][] board, int player){
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

