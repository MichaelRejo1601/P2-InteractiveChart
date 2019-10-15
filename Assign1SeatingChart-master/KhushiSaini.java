import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KhushiSaini class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class KhushiSaini extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KhushiSaini class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public KhushiSaini(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;//Row 4
        mySeat=s;//Column 2
        setLocation(mySeat,myRow);
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-silly.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }

    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public KhushiSaini() {
        firstName="Khushi";
        lastName="Saini";
        myRow=1;
        mySeat=1;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-silly.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
        numStudents++;
    }

    /**
     * Act - do whatever the KhushiSaini actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            for(int j=0;j<3;j++){
                setImage(standingFile);
                for(int i=0;i<360;i+=4){
                    turn(4);
                    Greenfoot.delay(1);
                }
                setImage(portraitFile);                                     
                Greenfoot.delay(15);
            }
            sitting=false;
            setImage(portraitFile);
            System.out.println(); // Print a blank line to create space between any student output.
            getName();
            sayName(soundFile);

            myHobby("I love to dance.");
                        sitDown();
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat

            //circleClass();  // Kilgore Trount's special method... Please write one of your own. You can use this, but please modify it and be creative.
            //playermove();
        }
    }
    //int centerX = 50;
    //int centerY = 50;
    /*int radius = 50;
    int rotation = 10;
    int turnSpeed = 10;
    // in act
    setLocation(0,0); // move to center
    setRotation(rotation); // rotate actor to old rotation
    turn(turnSpeed); // add change in rotation of actor
    rotation = getRotation(); // save new rotation value
    move(radius); // move to edge of circle
    setRotation(0); // un-rotate actor

    } 

    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }

    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void answerQuestion(){
        String q=Greenfoot.ask("Ask me something!");
        if (q.contains("hard")){
            q=Greenfoot.ask("2D arrays, recursion, and merge sort... May I sit down?");

        }
        else {
            q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }

    }
    /**
     * This is a local method specific to the KhushiSaini class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    /*public void playermove(){
    int centerX = 100;
    int centerY = 100;
    int radius = 50;
    int rotation = 0;
    int turnSpeed = 1;
    // in act
    setLocation(centerX, centerY); // move to center
    setRotation(rotation); // rotate actor to old rotation
    turn(turnSpeed); // add change in rotation of actor
    rotation = getRotation(); // save new rotation value
    move(radius); // move to edge of circle
    setRotation(0); // un-rotate actor
    }*/

    public void circleClass(){
        setLocation(0,0);
        Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
        // move left
        for (int i=9;i>=0;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
        // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
        Greenfoot.delay(20);
        returnToSeat();
    }

    public void myHobby(String s) {
        System.out.println(s);
    }

}