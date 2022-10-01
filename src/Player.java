
public class Player extends GameVar {

    //declare player variables
    String name;
    int playerPosition,  countInSquares, choice;
    // countInSquares represent the new position a player counts
    //to after every roll of the dice


    boolean hasStarted = false, hasBiscuit = false,
            hasBigStick = false, skipRolled6;
    //skipRolled6 prevents a player from rolling again
    //if  the player cannot count forward

    //setter and getter methods for variables
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean isSkipRolled6() {
        return skipRolled6;
    }
    public void setSkipRolled6(boolean skipRolled6) {
        this.skipRolled6 = skipRolled6;
    }

    //method to check that player rolled dice and counts forward accordingly
    //position argument in the method represents every dice rolled
    // for which a player will count to move to a new position
    public void IncreasePlayerPosition(int position, String name) {

        gameBoard();

        //variable to indicate player's previous position
        //remember from GameStart(), player starts at position 1
        //if a 6 is rolled.
        int prevPosition= countInSquares;

        //check if the sum of previous position and rolled dice(position argument above)
        //exceeds the size of the game's board i.e. 100 grid squares
        if((prevPosition+position)>getGameBoardSize()) {
            //player cannot move/count if the sum above is greater than the board
            prevPosition=countInSquares; //previous position remains the same
            setCantMove(true);

            //checks if a player rolls a 6 while they cannot count ahead
            if(position==6) {
                //boolean will be used to prevent player from rolling again
                setSkipRolled6(true);
            }
        }else if((prevPosition+position)==getGameBoardSize()) {

            //player wins if condition is true
            prevPosition = countInSquares;
            countInSquares +=position;
            setHasWon(true);
            System.out.println(name+" rolled "+getRolledDice()
                    +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
            System.out.println(name.toUpperCase()+" WINSSSS.\n");

        }
        else {

            prevPosition = countInSquares;
            countInSquares +=position;//player count is increased per dice rolled
            setCantMove(false);
        }


        //while the player has not won the game, player continues to play the game
        //and how the player progresses in the game is checked
        while(!isHasWon()) {
            //check for biscuit and big stick
            //line 85 - 113
            if(countInSquares==getBiscuitPosition()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println("Nice!, "+name+" grabs a snack for the snakes ahead.\n");
                hasBiscuit = true;
                setPlayerPosition(countInSquares);

            }else if(countInSquares==getBigStickPosition()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println("Wow!, stepping stick retrieved.\n");
                hasBigStick=true;
                setPlayerPosition(countInSquares);


            }else if(countInSquares==getBigStickPosition2()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println("Wow!, stepping stick retrieved.\n");
                hasBigStick=true;
                setPlayerPosition(countInSquares);

            }else if(countInSquares==getBiscuitPosition2()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println("Nice!, "+name+" grabs a snack for the snakes ahead.\n");
                hasBiscuit = true;
                setPlayerPosition(countInSquares);

            }//checks for snakes and ladders while playing. lines 115 - 222
            else if(countInSquares==getShort_snake1_head_position()&& !hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                countInSquares = getShort_snake1_tail_position();
                System.out.println("Ouch!, bitten by snake at square ["+
                        getShort_snake1_head_position()+ "] down to square [" +getShort_snake1_tail_position()+"].\n"
                        + "...sorry we ain't got first aid.\n");

                setPlayerPosition(countInSquares);

            }else if(countInSquares==getShort_snake1_head_position()&& hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println(name+ " tips the snake with a biscuit!\nEasy pass for him...\n");
                setPlayerPosition(countInSquares);
                hasBiscuit=false;

            }else if(countInSquares==getShort_snake2_head_position()&& !hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                countInSquares = getShort_snake2_tail_position();
                System.out.println("Ouch!, bitten by snake at square ["+
                        getShort_snake2_head_position()+ "] down to square [" +getShort_snake2_tail_position()+"].\n"
                        + "...sorry we ain't got first aid.\n");
                setPlayerPosition(countInSquares);

            }else if(countInSquares==getShort_snake2_head_position()&& hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println(name+ " tips the snake with a biscuit!\nEasy pass for him...\n");
                setPlayerPosition(countInSquares);
                hasBiscuit=false;

            }else if(countInSquares==getMini_snake_head_position()&& !hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                countInSquares = getMini_snake_tail_position();
                System.out.println("Ouch!, bitten by snake at square ["+
                        getMini_snake_head_position()+ "] down to square [" +getMini_snake_tail_position()+"].\n"
                        + "...sorry we ain't got first aid.\n");

                setPlayerPosition(countInSquares);

            }else if(countInSquares==getMini_snake_head_position()&& hasBiscuit) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println(name+ " tips the snake with a biscuit!\nEasy pass for him...\n");
                setPlayerPosition(countInSquares);
                hasBiscuit=false;
            }
            else if(countInSquares==getShort_ladder_bottom_position()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                if(hasBigStick) {
                    countInSquares = getShort_ladder_top_position();
                    System.out.println("Level up! " +name +" ladders up from square ["+
                            getShort_ladder_bottom_position()+ "] to [" +getShort_ladder_top_position()+"].");
                    System.out.println("Oou, big luck for "+name+"!, gains extra move with BIG-STICK power up!");
                    System.out.println("Moves again from square ["+ getShort_ladder_top_position()
                            +"] to ["+ (getShort_ladder_top_position()+10)+"].\n");
                    setPlayerPosition(countInSquares+=10);
                    hasBigStick=false;
                }else {
                    countInSquares = getShort_ladder_top_position();
                    System.out.println("Level up! " +name +" ladders up from square ["+
                            getShort_ladder_bottom_position()+ "] to [" +getShort_ladder_top_position()+"].\n");
                    setPlayerPosition(countInSquares);
                }
            }
            else if(countInSquares==getMini_ladder_bottom_position()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                if(hasBigStick) {
                    countInSquares = getMini_ladder_top_position();
                    System.out.println("Level up! " +name +" ladders up from square ["+
                            getMini_ladder_bottom_position()+ "] to [" +getMini_ladder_top_position()+"].");
                    System.out.println("Oou, big luck for "+name+"!, gains extra move with BIG-STICK power up!");
                    System.out.println("Moves again from square ["+ getMini_ladder_top_position()
                            +"] to ["+ (getMini_ladder_top_position()+10)+"].\n");
                    setPlayerPosition(countInSquares+=10);
                    hasBigStick=false;
                }else {
                    countInSquares = getMini_ladder_top_position();
                    System.out.println("Level up! " +name +" ladders up from square ["+
                            getMini_ladder_bottom_position()+ "] to [" +getMini_ladder_top_position()+"].\n");
                    setPlayerPosition(countInSquares);
                }
            }
            else if(countInSquares==getLong_ladder_bottom_position()) {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");

                if(hasBigStick) {
                    countInSquares = getLong_ladder_top_position();
                    System.out.println("Level up! " +name +" ladders up from square ["+
                            getLong_ladder_bottom_position()+ "] to [" +getLong_ladder_top_position()+"].");
                    System.out.println("Oou, big luck for "+name+"!, gains extra move with BIG-STICK power up!");
                    System.out.println("Moves again from square ["+ getLong_ladder_top_position()+"] to ["
                            + (getLong_ladder_top_position()+10)+"].\nCatch me if you can!\n");
                    setPlayerPosition(countInSquares+=10);
                    hasBigStick=false;
                }else {
                    countInSquares = getLong_ladder_top_position();
                    System.out.println("Level up!, " +name +" ladders up from square ["+
                            getLong_ladder_bottom_position()+ "] to [" +getLong_ladder_top_position()+"].\n"
                            + "Smooooothhh!\n");
                    setPlayerPosition(countInSquares);
                }

            }else if(isCantMove()){
                System.out.println(name+" rolled "+getRolledDice()
                        +" but still at square [" + prevPosition + "]");
                System.out.println("You going nowhere with that!. Roll a "+(getGameBoardSize()-prevPosition)+"!\n");
                setPlayerPosition(prevPosition);



            }else if(countInSquares==getGameBoardSize()){
                setHasWon(true);
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"]");
                System.out.println(name.toUpperCase()+" WINSSSS.\n");
                break;

            }
            else {
                System.out.println(name+" rolled "+getRolledDice()
                        +" and moved from square ["+prevPosition+ "] to ["+countInSquares+"].\n");
                setPlayerPosition(countInSquares);
            }
            break;
        }

    }

    //method to set square positions of snakes, ladders,
    //biscuits and big stick on the game board
    public void gameBoard() {

        setGameBoardSize(100);
        setPlayerPosition(0);

        setShort_snake1_head_position(36);
        setShort_snake1_tail_position(26);

        setShort_snake2_head_position(70);
        setShort_snake2_tail_position(60);

        setMini_snake_head_position(57);
        setMini_snake_tail_position(33);

        setLong_snake_head_position(88);
        setLong_snake_tail_position(18);

        setShort_ladder_bottom_position(46);
        setShort_ladder_top_position(56);

        setMini_ladder_bottom_position(7);
        setMini_ladder_top_position(27);

        setLong_ladder_bottom_position(30);
        setLong_ladder_top_position(85);

        setBiscuitPosition(39);
        setBigStickPosition(44);

        setBiscuitPosition2(80);
        setBigStickPosition2(4);

    }

    //method checks if player has rolled a 6 or not
    public void GameStart(int startAtPosition1, String name) {
        //player starts at square 1 if a 6 is rolled
        if(startAtPosition1==6) {
            System.out.println("\n"+name+ " rolled a "+
                    startAtPosition1+". "+name+" starts at square [1].\nRoll again");
            countInSquares=1; //player starts count at square 1
            setPlayerPosition(countInSquares);
            hasStarted=true; //player has started the game
        }
        //else player has to roll again
        else {
            System.out.println("\nRoll a 6 to start. "+name+" rolled "+
                    startAtPosition1);
        }
    }
}



