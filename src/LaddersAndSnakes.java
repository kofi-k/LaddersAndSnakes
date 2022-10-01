import java.util.Scanner;
import java.io.*;

public class LaddersAndSnakes {

    //variables to represent player positions on the  grid
    static int setPositionOnGrid1,setPositionOnGrid2,setPositionOnGrid3;
    static char init, init2, init3;
    static int x;
    //setter and getter methods of the variables
    public static int getSetPositionOnGrid1() {
        return setPositionOnGrid1;
    }
    public static char getInit2() {
        return init2;
    }
    public static void setInit2(char init2) {
        LaddersAndSnakes.init2 = init2;
    }
    public static char getInit3() {
        return init3;
    }
    public static void setInit3(char init3) {
        LaddersAndSnakes.init3 = init3;
    }
    public static void setSetPositionOnGrid1(int setPositionOnGrid1) {
        LaddersAndSnakes.setPositionOnGrid1 = setPositionOnGrid1;
    }
    public static char getInit() {
        return init;
    }
    public static void setInit(char init) {
        LaddersAndSnakes.init = init;
    }
    public static int getSetPositionOnGrid2() {
        return setPositionOnGrid2;
    }
    public static void setSetPositionOnGrid2(int setPositionOnGrid2) {
        LaddersAndSnakes.setPositionOnGrid2 = setPositionOnGrid2;
    }
    public static int getSetPositionOnGrid3() {
        return setPositionOnGrid3;
    }
    public static void setSetPositionOnGrid3(int setPositionOnGrid3) {
        LaddersAndSnakes.setPositionOnGrid3 = setPositionOnGrid3;
    }

    public static void main(String[] args) {
        //player objects
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();

        //game logic for each player of the game
        GameLogic player1 = new GameLogic();
        GameLogic player2 = new GameLogic();
        GameLogic player3 = new GameLogic();

        //scanner to capture inputs from player(s)
        Scanner input = new Scanner(System.in);
        System.out.println();
        for(int a=0;a<25;a++) {System.out.print("**");}
        //welcome player to game and display options
        System.out.println("\n\tWelcome to Snakes and Ladders Game");
        for(int a=0;a<25;a++) {System.out.print("**");}
        System.out.println("\n\t1. Select number of players [1-3]\n\t2. Quit");
        System.out.print("\nChoice:\t");
        int options = input.nextInt();

        if(options==1) { //opted to play game -- label P1
            //take number of players
            System.out.print("Number of players:\t");
            options = input.nextInt();

            if (options==1) {
                //take name of single player
                System.out.print("\nEnter name:\t");
                p1.setName(input.next());

                //keep the game playing until player wins --main loop1
                while(true) {
                    System.out.println("\nRoll dice?\n1.Yes");
                    player1.playGame(p1);
                    //while the player has started the game and player has not won
                    if(p1.hasStarted &&! player1.hasPlayerWon(p1)) {
                        setSetPositionOnGrid1(player1.playerNewPosition);
                        setInit(NameInitial(p1.getName()));
                        ShowGrid();//shows player movement on the grid
                    }else if(player1.hasPlayerWon(p1)){
                        for(int a=0;a<25;a++) {System.out.print("**");}
                        System.out.println("\nGame Over!!!");
                        break; //game ends
                    }
                }//end of main loop1
            }//end of option 1 selected to play as single player
            else if(options==2) {
                //take names of players --2
                System.out.print("\nEnter name for player one:\t");
                p1.setName(input.next());
                System.out.print("Enter name for player two:\t");
                p2.setName(input.next());

                //extract initials of players to be printed on grid
                setInit(NameInitial(p1.getName()));
                setInit2(NameInitial(p2.getName()));

                System.out.println("\nStart Game?\n1.Yes\t2.No");

                int start = input.nextInt();
                if(start==1) { //body of game starts for 2 players
                    System.out.println();
                    System.out.println(p1.getName() +" goes first..");//player 1 rolls first
                    System.out.println("Roll dice?\n1.Yes");

                    //keep the game playing until a player wins --main loop2
                    while(true) {
                        player1.playGame(p1);

                        //set player positions on the grid
                        setSetPositionOnGrid1(player1.playerNewPosition);
                        setSetPositionOnGrid2(player2.playerNewPosition);

                        //game continues if player1 has not won --label 2a
                        if(!player1.hasPlayerWon(p1)) {
                            while(p1.hasStarted) {

                                //checks if a player1 lands on the same square as player2 and kicks player2 out of the game
                                if(player2.hasStarted && player1.playerNewPosition==player2.playerNewPosition) {
                                    System.out.println(p1.getName()+" kicks "+p2.getName()+ " out!");
                                    p2.hasStarted=false;
                                    player2.faildToRollSix=0;
                                    player2.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);

                                }
                                //player does not land on same grid position of other player
                                else {
                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                }
                                break;
                            }
                            //player2 rolls next
                            System.out.println("\n\n"+p2.getName()+"'s turn to roll.\n1.Roll");//player2 gets to roll
                            player2.playGame(p2);

                        }//end of label 2a
                        //player1 has won and game is over if main condition (label 2a) is false
                        else {
                            //player 2 did not get to start before player 1 won, flawless win
                            if(!p2.hasStarted) {System.out.println("FLAWLESS VICTORY\n");}
                            for(int a=0;a<25;a++) {System.out.print("**");}
                            System.out.println("\nGame Over!!!");//game over
                            break;}

                        //game continues if player2 has not won --label 2b
                        if(!player2.hasPlayerWon(p2)) {
                            while(p2.hasStarted) {
                                //set player positions on the grid
                                setSetPositionOnGrid1(player1.playerNewPosition);
                                setSetPositionOnGrid2(player2.playerNewPosition);

                                //checks if a player2 lands on the same square as player1 and kicks player1 out of the game
                                if(player1.hasStarted && player2.hasStarted && player2.playerNewPosition==player1.playerNewPosition) {
                                    System.out.println(p2.getName()+" kicks "+p1.getName()+ " out!");
                                    p1.hasStarted=false;
                                    player1.faildToRollSix=0;
                                    player1.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);

                                }
                                //player does not land on same grid position of other player
                                else {
                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                }
                                break;
                            }
                            //player1 rolls next
                            System.out.println("\n\n"+p1.getName()+"'s turn to roll.\n1.Roll");
                        }//end of label 2b
                        //player1 has won and game is over if main condition (label 2b) is false
                        else {
                            //player 1 did not get to start before player 2 won, flawless win
                            if(!p1.hasStarted) {System.out.println("FLAWLESS VICTORY\n");}
                            for(int a=0;a<25;a++) {System.out.print("**");}
                            System.out.println("\nGame Over!!!");
                            break;}
                    }//end of main loop2

                }//end of body of game starts for 2 players

                //player did not select 1 to start the game
                else {System.out.println("Not started...");}

            }//end of option 2 selected to play two players

            else if(options==3) {//option 3 to play three players
                //take names of players --3
                System.out.print("\nEnter name for player one:\t");
                p1.setName(input.next());
                System.out.print("Enter name for player two:\t");
                p2.setName(input.next());
                System.out.print("Enter name for player three:\t");
                p3.setName(input.next());

                //extract initials of players to be printed on grid
                setInit(NameInitial(p1.getName()));
                setInit2(NameInitial(p2.getName()));
                setInit3(NameInitial(p3.getName()));

                System.out.println("\nStart Game?\n1.Yes\t2.No");
                int start = input.nextInt();

                if(start==1) {// body of game starts for 3 players
                    System.out.println();
                    System.out.println(p1.getName() +" goes first..");
                    System.out.println("Roll dice?\n1.Yes");

                    //keep the game playing until a player wins --main loop3
                    while(true) {
                        player1.playGame(p1);
                        //game continues if either of player1 and player 3 has not won game --label 3a
                        if (!player1.hasPlayerWon(p1)&&!player3.hasPlayerWon(p3)) {
                            while(p1.hasStarted) {
                                //set player positions on the grid
                                setSetPositionOnGrid1(player1.playerNewPosition);
                                setSetPositionOnGrid2(player2.playerNewPosition);
                                setSetPositionOnGrid3(player3.playerNewPosition);

                                //checks if a player1 lands on the same square as player2 and kicks player2 out of the game
                                if(player1.playerNewPosition==player2.playerNewPosition) {
                                    System.out.println(p1.getName()+" kicks "+p2.getName()+ " out!");
                                    p2.hasStarted=false;
                                    player2.faildToRollSix=0;
                                    player2.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();

                                    break;
                                }
                                //checks if a player1 lands on the same square as player3 and kicks player3 out of the game
                                else if(player1.playerNewPosition==player3.playerNewPosition) {
                                    System.out.println(p1.getName()+" kicks "+p3.getName()+ " out!");
                                    p3.hasStarted=false;
                                    player3.faildToRollSix=0;
                                    player3.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                                //player1 does not land on same grid position of other players
                                else {
                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                            }
                            //player 2 rolls next
                            System.out.println("\n\n"+p2.getName()+"'s turn to roll.\n1.Roll");
                            player2.playGame(p2);
                        }//end of label 3a
                        //player1 has won and game is over if main condition (label 3a) is false
                        else {for(int a=0;a<25;a++) {System.out.print("**");}
                            System.out.println("\nGame Over!!!");break;}

                        //game continues if either of player2 and player 1 has not won the game  --label 3b
                        if(!player2.hasPlayerWon(p2)&&!player1.hasPlayerWon(p1)) {
                            while(p2.hasStarted) {
                                //set player positions on the grid
                                setSetPositionOnGrid1(player1.playerNewPosition);
                                setSetPositionOnGrid2(player2.playerNewPosition);
                                setSetPositionOnGrid3(player3.playerNewPosition);

                                //checks if a player2 lands on the same square as player1 and kicks player1 out of the game
                                if(player2.playerNewPosition==player1.playerNewPosition) {
                                    System.out.println(p2.getName()+" kicks "+p1.getName()+ " out!");
                                    p1.hasStarted=false;
                                    player1.faildToRollSix=0;
                                    player1.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                                //checks if a player2 lands on the same square as player3 and kicks player3 out of the game
                                else if(player2.playerNewPosition==player3.playerNewPosition) {
                                    System.out.println(p2.getName()+" kicks "+p3.getName()+ " out!");
                                    p3.hasStarted=false;
                                    player3.faildToRollSix=0;
                                    player3.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                                //player2 does not land on same grid position of other players
                                else {
                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;}
                            }
                            //player3 rolls next
                            System.out.println("\n\n"+p3.getName()+"'s turn to roll.\n1.Roll");
                            player3.playGame(p3);
                        }//end of label 3b
                        //player2 has won and game is over if main condition (label 3b) is false
                        else{for(int a=0;a<25;a++) {System.out.print("**");}
                            System.out.println("\nGame Over!!!");break;}

                        //game continues if either of player3 and player 2 has not won the game --label 3c
                        if(!player3.hasPlayerWon(p3)&&!player2.hasPlayerWon(p2)) {
                            while(p3.hasStarted) {
                                //set  player positions on the grid
                                setSetPositionOnGrid1(player1.playerNewPosition);
                                setSetPositionOnGrid2(player2.playerNewPosition);
                                setSetPositionOnGrid3(player3.playerNewPosition);

                                //checks if a player3 lands on the same square as player1 and kicks player1 out of the game
                                if(player3.playerNewPosition==player1.playerNewPosition) {
                                    System.out.println(p3.getName()+" kicks "+p1.getName()+ " out!");
                                    p1.hasStarted=false;
                                    player1.faildToRollSix=0;
                                    player1.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                                //checks if a player3 lands on the same square as player2 and kicks player2 out of the game
                                else if(player3.playerNewPosition==player2.playerNewPosition) {
                                    System.out.println(p3.getName()+" kicks "+p2.getName()+ " out!");
                                    p2.hasStarted=false;
                                    player2.faildToRollSix=0;
                                    player2.playerNewPosition=0;

                                    //set new player positions on the grid
                                    setSetPositionOnGrid1(player1.playerNewPosition);
                                    setSetPositionOnGrid2(player2.playerNewPosition);
                                    setSetPositionOnGrid3(player3.playerNewPosition);

                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                                //player3 does not land on same grid position of other players
                                else {
                                    ShowGrid(); //shows the grid
                                    System.out.println();
                                    break;
                                }
                            }
                            //player1 rolls next
                            System.out.println("\n\n"+p1.getName()+"'s turn to roll.\n1.Roll");
                        }//end of label 3c
                        //player3 has won and game is over if main condition (label 3c) is false
                        else{for(int a=0;a<25;a++) {System.out.print("**");}
                            System.out.println("\nGame Over!!!");break;}
                    }//end of main loop3

                }//end of body of game starts for 3 players

            }//end option 3 selected to play three players

            //player did not choose number of players between 1 and 3 inclusive
            else {System.out.println("wrong selection...");}

        }//end of option label P1 to select number of players and play game

        else  {//player selected option 2 to quit game
            System.out.println("Bye!...");}
    }

    //create grid method
    public static void ShowGrid(){
        System.out.println();
        //create 10 rows with
        for(int row=1 ; row<=10 ; row++){
            x=row; //x increases by 1 in every row (row++)
            for (int j = 0; j <10; j++){
                System.out.print("------+");
            }
            System.out.println();
            for(int col=0;col<10;col++){
                //method call to set player positions on the grid
                setPlayerGridPosition(getSetPositionOnGrid1(),getSetPositionOnGrid2(),
                        getSetPositionOnGrid3(), getInit(),getInit2(),getInit3());
                x = x+10;//x is increased by 10 in every colon
            }
            System.out.println();
        }
        for(int a=0;a<10;a++) {System.out.print("------+");}

    }

    //method to set player positions with their initials
    public static void setPlayerGridPosition(int position,int position2,int position3,
                                             char initials, char initials2,char initials3) {
        // check for proper alignment of the grid at positions <10
        if(x<10) {
            if(x==position) {
                System.out.print("|  "+initials+"  |");}
            else if(x==position2) {
                System.out.print("|  "+initials2+"  |");
            }else if(x==position3) {
                System.out.print("|  "+initials3+"  |");
            }
            else {
                System.out.print("|  "+(x)+"  |");}
        }
        else {
            // check for proper alignment of the grid at positions > 10
            if(x==position && x==10) {System.out.print("| "+initials+"   |");}
            else if(x==position){System.out.print("  "+initials+"   |");}
            else if(x==10) {System.out.print("| "+(x)+"  |");}
            else if(x==position2 && x==10) {System.out.print("| "+initials2+"   |");}
            else if(x==position2) {System.out.print("   "+initials2+"  |");}
            else if(x==position3) {System.out.print("   "+initials3+"  |");}
            else if(x==position3 && x==10) {System.out.print("| "+initials3+"   |");}
            else if(x==100) {System.out.print("  "+(x)+" |");}
            else {System.out.print("  "+(x)+"  |");}
        }
    }
    //method that extracts the initial of a player
    public static char NameInitial(String name) {
        name= name.toUpperCase();
        return name.charAt(0);
    }

}



