import java.util.Scanner;

public class GameLogic  {

    //player object p
    Player p=new Player();
    int faildToRollSix=0, playerNewPosition;
    boolean hasStarted = false, hasWon=p.isHasWon();

    //scanner to take user input
    Scanner input = new Scanner(System.in);

    //method to check game flow with a player argument
    public void playGame(Player player) {
        player.gameBoard();// player plays on the game board
        int newRoll =((int) (Math.random()*6+1));//random roll dice
        int six=0;
        //checks if player as started the game or not
        if(!player.hasStarted) {

            player.choice = input.nextInt();//input to roll dice
            if(player.choice==1 ) {
                newRoll =((int) (Math.random()*6+1));
                player.setRolledDice(newRoll);
                if(!player.hasStarted) {
                    //check if player has rolled a 6 and start
                    if(player.getRolledDice()==6) {
                        if(faildToRollSix>=7) {
                            System.out.println("Argh! finally");
                        }else if(faildToRollSix<1) {
                            System.out.println("Ou, that was fast!");
                        }
                        //player starts at square 1 for rolling their first 6 to start counting
                        player.GameStart(player.getRolledDice(), player.getName());
                        hasStarted = true;
                        //player is allowed to roll again after starting at position 1

                        System.out.println("1.Roll");
                        player.choice = input.nextInt();

                        if(player.choice==1) {
                            newRoll =((int) (Math.random()*6+1));
                            player.setRolledDice(newRoll);

                            //player keeps rolling if a 6 is rolled
                            while(player.getRolledDice()==6) {
                                six+=1;
                                //acknowledge player is having a 6 luck
                                if(six==3) {
                                    System.out.println(player.getName()+" can't stop 6'ing!");
                                    six=0;
                                }
                                System.out.println(player.getRolledDice()+ " rolled!");
                                player.setPlayerPosition(player.getRolledDice());
                                player.IncreasePlayerPosition(player.getPlayerPosition(),player.getName());
                                playerNewPosition= player.getPlayerPosition();

                                //display player rolled 6, so he rolls again
                                System.out.println(player.getName()+" rolled a 6!, go again!");
                                System.out.println("Roll dice?\n1.Yes");
                                player.choice = input.nextInt();
                                if(player.choice==1)
                                {newRoll =((int) (Math.random()*6+1));
                                    player.setRolledDice(newRoll);}
                                break;
                            }
                            //player did not roll a 6, game continues
                            System.out.println(newRoll+ " rolled!");
                            player.setPlayerPosition(newRoll);
                            player.setRolledDice(newRoll);
                            player.IncreasePlayerPosition(player.getPlayerPosition(),player.getName());
                            playerNewPosition= player.getPlayerPosition();}


                    }
                    //player has not rolled a 6 to start at position 1
                    else {player.hasStarted=false;
                        faildToRollSix+=1;
                        if(faildToRollSix==7) {
                            //acknowledge player is having a tough time rolling a 6
                            System.out.println("You've been cursed or something...");
                        }else if(faildToRollSix==12) {
                            System.out.println("You definelty been cursed...");
                        }
                        //print info to player
                        System.out.println(player.getRolledDice()+" rolled. Roll a 6 to start!");
                    }
                }//player has rolled his first 6 to start the game
                else {
                    player.hasStarted=true;
                    System.out.println(newRoll+ " rolled!");
                    player.setPlayerPosition(newRoll);
                    player.setRolledDice(newRoll);
                    player.IncreasePlayerPosition(player.getPlayerPosition(),player.getName());
                    playerNewPosition= player.getPlayerPosition();
                }
            }else {System.out.println("...no roll");}//player did not enter 1 to roll dice
        }
        //player has already rolled 6 and has started playing
        else {
            player.choice = input.nextInt();
            if(player.choice==1) {
                newRoll =((int) (Math.random()*6+1));
                player.setRolledDice(newRoll);

                //initially set skip 6 to false
                player.setSkipRolled6(false);

                //player has rolled a 6 will playing
                while(player.getRolledDice()==6) {
                    six+=1;
                    //acknowledge player is having a 6 luck
                    if(six==3) {
                        System.out.println(player.getName()+" can't stop 6'ing!");
                        six=0;
                    }
                    //if a player rolls a 6 and can move
                    //the player is allowed to roll again.
                    System.out.println(player.getRolledDice()+ " rolled!");
                    player.setPlayerPosition(player.getRolledDice());
                    player.IncreasePlayerPosition(player.getPlayerPosition(),player.getName());
                    playerNewPosition= player.getPlayerPosition();
                    //in case player rolls a 6 and wins he does not have to roll again
                    if(player.isHasWon()) {
                        break;
                    }
                    //if a player rolls a 6 and cannot move
                    //the player is not allowed to roll again.
                    else if(player.isSkipRolled6()) {
                        System.out.println(newRoll+ "!, ...but its no good here. Can't roll again pal :(");
                        break;
                    }//player is allowed to roll again
                    else {
                        System.out.println(player.getName()+" rolled a 6!, go again!");
                        System.out.println("Roll dice?\n1.Yes");
                        player.choice = input.nextInt();
                        if(player.choice==1) {
                            newRoll =((int) (Math.random()*6+1));
                            player.setRolledDice(newRoll);
                        }
                    }
                }
                if (player.isSkipRolled6()) {
                    //do nothing
                }else {
                    //player roll a number other than 6 while playing
                    System.out.println(player.getRolledDice()+ " rolled!");
                    player.setPlayerPosition(player.getRolledDice());
                    player.setRolledDice(newRoll);
                    player.IncreasePlayerPosition(player.getPlayerPosition(),player.getName());
                    playerNewPosition= player.getPlayerPosition();

                }
            }
        }
    }
    //check if player has won
    public boolean hasPlayerWon(Player playerHasWon) {
        return playerHasWon.isHasWon();
    }



}
