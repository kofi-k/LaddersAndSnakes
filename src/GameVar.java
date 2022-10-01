
//abstract class that contains game board variables
public abstract class GameVar {

    // variables for snakes, ladders, biscuits and big sticks on the board
    int
            short_snake1_head_position, short_snake2_head_position, mini_snake_head_position, long_snake_head_position,
            short_snake1_tail_position, short_snake2_tail_position, mini_snake_tail_position, long_snake_tail_position,
            short_ladder_bottom_position, mini_ladder_bottom_position, long_ladder_bottom_position,
            short_ladder_top_position, mini_ladder_top_position, long_ladder_top_position,
            rolledDice, gameBoardSize, biscuitPosition, bigStickPosition,biscuitPosition2, bigStickPosition2;

    boolean cantMove, hasWon;

    //setters and getters of the variables
    public boolean isCantMove() {
        return cantMove;
    }
    public void setCantMove(boolean cantMove) {
        this.cantMove = cantMove;
    }
    public boolean isHasWon() {
        return hasWon;
    }
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
    public int getShort_snake1_head_position() {
        return short_snake1_head_position;
    }
    public void setShort_snake1_head_position(int short_snake1_head_position) {
        this.short_snake1_head_position = short_snake1_head_position;
    }
    public int getShort_snake2_head_position() {
        return short_snake2_head_position;
    }
    public void setShort_snake2_head_position(int short_snake2_head_position) {
        this.short_snake2_head_position = short_snake2_head_position;
    }
    public int getMini_snake_head_position() {
        return mini_snake_head_position;
    }
    public void setMini_snake_head_position(int mini_snake_head_position) {
        this.mini_snake_head_position = mini_snake_head_position;
    }
    public int getLong_snake_head_position() {
        return long_snake_head_position;
    }
    public void setLong_snake_head_position(int long_snake_head_position) {
        this.long_snake_head_position = long_snake_head_position;
    }
    public int getShort_snake1_tail_position() {
        return short_snake1_tail_position;
    }
    public void setShort_snake1_tail_position(int short_snake1_tail_position) {
        this.short_snake1_tail_position = short_snake1_tail_position;
    }
    public int getShort_snake2_tail_position() {
        return short_snake2_tail_position;
    }
    public void setShort_snake2_tail_position(int short_snake2_tail_position) {
        this.short_snake2_tail_position = short_snake2_tail_position;
    }
    public int getMini_snake_tail_position() {
        return mini_snake_tail_position;
    }
    public void setMini_snake_tail_position(int mini_snake_tail_position) {
        this.mini_snake_tail_position = mini_snake_tail_position;
    }
    public int getLong_snake_tail_position() {
        return long_snake_tail_position;
    }
    public void setLong_snake_tail_position(int long_snake_tail_position) {
        this.long_snake_tail_position = long_snake_tail_position;
    }

    public int getShort_ladder_bottom_position() {
        return short_ladder_bottom_position;
    }
    public void setShort_ladder_bottom_position(int short_ladder_bottom_position) {
        this.short_ladder_bottom_position = short_ladder_bottom_position;
    }
    public int getMini_ladder_bottom_position() {
        return mini_ladder_bottom_position;
    }
    public void setMini_ladder_bottom_position(int mini_ladder_bottom_position) {
        this.mini_ladder_bottom_position = mini_ladder_bottom_position;
    }
    public int getLong_ladder_bottom_position() {
        return long_ladder_bottom_position;
    }
    public void setLong_ladder_bottom_position(int long_ladder_bottom_position) {
        this.long_ladder_bottom_position = long_ladder_bottom_position;
    }
    public int getShort_ladder_top_position() {
        return short_ladder_top_position;
    }
    public void setShort_ladder_top_position(int short_ladder_top_position) {
        this.short_ladder_top_position = short_ladder_top_position;
    }
    public int getMini_ladder_top_position() {
        return mini_ladder_top_position;
    }
    public void setMini_ladder_top_position(int mini_ladder_top_position) {
        this.mini_ladder_top_position = mini_ladder_top_position;
    }
    public int getLong_ladder_top_position() {
        return long_ladder_top_position;
    }
    public void setLong_ladder_top_position(int long_ladder_top_position) {
        this.long_ladder_top_position = long_ladder_top_position;
    }
    public int getRolledDice() {
        return rolledDice;
    }
    public void setRolledDice(int rolledDice) {
        this.rolledDice = rolledDice;
    }

    public int getGameBoardSize() {
        return gameBoardSize;
    }
    public void setGameBoardSize(int gameBoardSize) {
        this.gameBoardSize = gameBoardSize;
    }

    public int getBiscuitPosition() {
        return biscuitPosition;
    }
    public void setBiscuitPosition(int biscuitPosition) {
        this.biscuitPosition = biscuitPosition;
    }
    public int getBigStickPosition() {
        return bigStickPosition;
    }
    public void setBigStickPosition(int bigStickPosition) {
        this.bigStickPosition = bigStickPosition;
    }

    public int getBiscuitPosition2() {
        return biscuitPosition2;
    }
    public void setBiscuitPosition2(int biscuitPosition2) {
        this.biscuitPosition2 = biscuitPosition2;
    }
    public int getBigStickPosition2() {
        return bigStickPosition2;
    }
    public void setBigStickPosition2(int bigStickPosition2) {
        this.bigStickPosition2 = bigStickPosition2;
    }

    //abstract method to keep a player moving
    public abstract void IncreasePlayerPosition(int position, String name);

}
