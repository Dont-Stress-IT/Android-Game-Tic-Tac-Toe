# Android-Game-Tic-Tac-Toe
Android App


A Tic Tac Toe game for android OS by Russel Young Commenced on 09/02/2015

Features to be implemented:

UI: Menu (single player, multi player, difficulty setting, about, exit), winner display screen

AI: 3 levels of ability

Game modes: Single player (vs AI), Multiplayer (vs another human)

Error checking

Logging functions

Backwards compatability (aiming for a minimum android SDK 4.0)


****update log 30/03/2015****

Hard AI tested and working

****update log 27/03/2015****

Hard AI complete, needs further testing for assurance.

****update log 6/03/2015****

Medium difficulty AI working

Human can no longer click on occupied square as there turn

****update log 3/03/2015****

Human vs easy AI working update.

Human goes first, then AI. It checks for a winner after every move after the 4th turn ( no win is possible until 5 turns have transpired ).

code OO architecture changes: declaired variables in start game activity fragment instead of inside it's modules and passing them every time.


****update log 12/02/2015****

Code: cleaned up wincheck() method for readability, Winner check complete
      
GUI: "X" and "O" buttons now displaying correctly

OO architecture: moved game code out of onCreate() method

AI: easy AI completed ( choose a random placement each turn )
