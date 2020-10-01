# rock-paper-scissors
rock paper scissors game

This is a very simple application which consist in simplified version of the rock scissors paper game.

Validation criteria follows: 
There will be 2 kinds of players, one should always choose randomly, the other should always choose rock.
- The program will be a web, using a java Rest API and a frontend view using javascript
- “Play Round” button that will play an automatic round
- Field showing the number of rounds played by that user so far.
- Table showing the rounds played, with 3 columns: what 1st player chose, what second chose, and the result of the round (that could be player 1 wins, player 2 wins or draw)
- There will be a button: “Restart game” that will set round count for that user to 0 and also clean the table.
- Include a econd simple view with the next information:
    - total rounds played
    - total Wins for first players
    - total Wins for second players
    - total draws
  - These totals should consider all the rounds of all the games played by all users. (even if we clicked in “Restart button”, these games should be considered as well)

- Keep the information needed in memory. 

# Project Description
There are two folders (Backend and Frontend) for the front and the back. The front was made with react and is very simple. The backend was made with java8 and spring boot. A bit more effort was put in the backend in order to build a complete API because all game rules (business logic) lives here.

The backend has two projects (both modules of the same parent):
rock-paper-scissors-core: By the time being only dto's to exchange with consumers of the API.
rock-paper-scissors-server: implementation of the API.

For the frontend... just execute "npm start" and go to http://localhost:3000 and you will see the app (Do not forget to cross fingers)
For the backend...you can run the project as a spring boot project (the runner is on rock-paper-scissors-server) or run via command line as any java jar.
