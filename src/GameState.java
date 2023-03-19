import java.util.ArrayList;
import java.util.Arrays;

public class GameState {
    public int makeup;
    public int[][] board;
    public ArrayList<Integer[]> spotsToDraw;
    public ArrayList<Integer> players = new ArrayList<Integer>();
    public int winner;
    public GameState(int x){
        spotsToDraw = new ArrayList<Integer[]>();
        board = new int[3][3];
        //computer = 0, player = 1
        makeup = x;
        boardWipe();
        int chosen = (int)(Math.random()*2);
        players.add(chosen);
        if(chosen == 0){
            players.add(1);
        }
        else{
            players.add(0);
        }

        
    }
    //assign each value on the board -1 to begin the game - a.k.a clearing the board
    public void boardWipe(){
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                board[x][y] = -1;
            }
        }
    }
    //return the value of a spot on the wall
    public int returnSpotValue(int x, int y){
        return board[x][y];
    }
    //mark a spot as x (1)
    public void markSpot(int val, int x, int y){
        if(isSpotAvailable(x, y)){
            board[x][y] = val;
            Integer spot[] = {val,x, y};
            spotsToDraw.add(spot);
            cyclePlayers();
        }
    }
    //checks if a spot is available to click - prerequisite to marking a spot
    public boolean isSpotAvailable(int x, int y){
        if(board[x][y] == -1){
            return true;
        }
        return false;
    }
    //return spotsToDraw
    public ArrayList getSpotsToDraw(){
        return spotsToDraw;
    }
    //cycle players
    public void cyclePlayers(){
        int temp = players.get(0);
        players.remove(0);
        players.add(temp);
    }
    //get current player
    public int getCurrentPlayer(){
        return players.get(0);
    }
    //check if the game is over
    public boolean GameOver(){
        if(checkForWin() == 0 || checkForWin() == 1 || checkForWin() == 2){
            return true;
        }
        return false;
    }
    //check for a win
    public int checkForWin(){
        //check for horizontal win
        for(int x = 0; x<3; x++){
            if(board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][0] != -1){
                winner = board[x][0];
                return board[x][0];
            }
        }
        //check for vertical win
        for(int x = 0; x<3; x++){
            if(board[0][x] == board[1][x] && board[1][x] == board[2][x] && board[0][x] != -1){
                winner = board[0][x];
                return board[0][x];
            }
        }
        //check for diagonal win
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != -1){
            winner = board[0][0];
            return board[0][0];
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != -1){
            winner = board[0][2];
            return board[0][2];
        }
        //check for tie
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                if(board[x][y] == -1){
                    return -1;
                }
            }
        }
        winner = 2;
        return 2;
    }
    //get the winner
    public int getWinner(){
        return winner;
    }
    //choose random available spot
    public void chooseRandomSpot(int val){
        int x = (int)(Math.random()*3);
        int y = (int)(Math.random()*3);
        if(isSpotAvailable(x, y)){
            markSpot(val, x, y);
        }
        else{
            chooseRandomSpot(val);
        }
    }
    //get makeup
    public int getMakeup(){
        return makeup;
    }
}
