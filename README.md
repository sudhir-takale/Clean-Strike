## Problem Statement

A new game in carrom-board called Clean Strike is played by 2 players with multiple turns. A
turn has a player attempting to strike a coin with the striker. Players alternate in taking turns.
The game is described as follows: <br>

● There are 9 black coins, a red coin and a striker on the carrom-board<br>
● Strike - When a player pockets a coin he/she wins a point<br>
● Multi-strike - When a player pockets more than one coin he/she wins 2 points. All, but 2
coins, that were pocketed, get back on to the carrom-board<br>
● Red strike - When a player pockets red coin he/she wins 3 points. If other coins are
pocketed along with red coin in the same turn, other coins get back on to the
carrom-board<br>
● Striker strike - When a player pockets the striker he/she loses a point<br>
● Defunct coin - When a coin is thrown out of the carrom-board, due to a strike, the player
loses 2 points, and the coin goes out of play<br>
● When a player does not pocket a coin for 3 successive turns he/she loses a point<br>
● When a player fouls 3 times (a foul is a turn where a player loses, at least, 1 point),
he/she loses an additional point<br>
● A game is won by the first player to have won at least 5 points, in total, and, at least, 3
points more than the opponent<br>
● When the coins are exhausted on the board, if the highest scorer is not leading by, at
least, 3 points or does not have a minimum of 5 points, the game is considered a draw<br>

Write a program that takes in the outcome of each turn as input and outputs the result of the
game as and when applicable along with necessary statistics that supports the result. Please
find sample input and output below:<br>

Assumptions:

- carom board don't exist without players.

### Design Pattern used :

- Used State Design Pattern to change the state of carom board according to Strike .

## Domain:

### Model:

- Entity
    - CaromBoard
        - id
        - blackCoinsCount
        - redCoinsCount
        - Striker
    - Player
        - id
        - FoulStrikeManager
        - pointsCount

- ValueObject
    - FoulStrikeManager - it will manage the foul strikes operation

- Service:
    - WinnerEvaluator - it is domain service which return string of winner player or draw match
    - CaromBoardState(interface) - has method like applyStrike() which will according to the strike it will call the
      class method will implements this interface
    - StrikeProcesses
        - StrikeProcessor implements CarromBoardState interface
            - applyStrike(CaromBoard, Player)

### Controller

- PlayerController - to helps to manage player operations
    - createPlayer
    - getPlayer

- CaromController - Manages everything related with carom Operations
    - createCaromBoard - it crates carom Board
    - getCaromBoard(id)     - it will get carom with id from repository
    - getWinnerOfTheGame()  - to start the game

### Services -

- PlayerService
    - createPlayer - create a player
    - getPlayer()   - get a player from repository
    - generateARandomNumber()  - generate a random number which used inside the domain service

- CaromService
    - createCarom()   - create a new carom
    - getCarom()      - get Carom from the repository
    - getWinner()     - to start the game and it will the domain service and pass the carom board

### Repository:

- PlayerRepository - helps to store the players
- CaromRepository - it stores the carom board, it may have multiple carom board

## Flow

- create player (at least we required two players to start with game)
- create carom board
- getCaromBoard from repository
    - assign players to carom board to start game
- create strikes classes which will used in domain service
- call the getWinner method to start the game of caromService class
- internally it will call to domain service to evaluate the winner and we pass carom board
- to get the random number it will call to player service to get random number
- finally it will perform processing and give the winner of game

### Approach

- createAPlayerController
    - createPlayers()
    - getPlayers()
- createPlayerService
    - createANewPlayer
    - call repository to store player
    - create a randomNumberGenerator method which generates random numbers used by domain service
- createPlayerRepository
    - store the player
- createCaromController
    - call the carom service to store the
- createACaromService
    - create a carom board
    - get the carom board
- createCaromRepository
    - stores the carom board

- Domain Service
    - create the strike classes
    - create a domain service as WinnerEvaluator which perform operation and returns the winner
    - get the random number from player Service class
  