import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random; 
/**
 * The JoshBeatty class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Josh Beatty
 * @version 2.0 Aug 13, 2019
 */
public class JoshBeatty extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{

    /**
     * Constructor for the JoshBeatty class.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public JoshBeatty(String f, String l, int r, int s) {
        numStudents += 1;
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
        System.out.println(numStudents);
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * creates josh at  1,2 
     */
    public JoshBeatty() {
        numStudents += 1;
        firstName="Josh";
        lastName="Beatty";
        myRow=2;
        mySeat=1;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }

     /**
     * Act - do whatever the JoshBeatty actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);

                myHobby("I like to play Counter-Strike: Global Offensive");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat

             coolMethod();  // Special method
            }
            else {
                answerQuestion();
                //sitDown();
            }

        }
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
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            q=Greenfoot.ask("Merge Sort, 2D arrays, Interfaces, Conditionals, and constructors were difficult... May I sit down?");

        }
        else if(q.contains("brother")){
            q=Greenfoot.ask("I have " + numberOfBrothers() +" brothers... May I sit down?");
        }
        else if(q.contains("sister")){
            q=Greenfoot.ask("I have " + numberOfSisters() +" sisters... May I sit down?");
        }
        else if(q.contains("siblings")||q.contains("brother") && q.contains("sister")){
            q=Greenfoot.ask("I have " + numberOfSiblings() +" siblings... May I sit down?");
        }
        else if(q.contains("student")){
            q=Greenfoot.ask("There are " + numStudents + " students in my class... May I sit down?");
        }
        else{
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
    /**
     *  This Method animates the actor into standing up.
     *  This method uses a 2d array with 3 coloums where each colom represtns an r, g, or b, value whith each row being a coloum.
     *  This method rotates and enlarges the actor and then reverses the change.
     */
    public void coolMethod(){
        int numberRotations = (int)(Math.random() * (8)) + 3;
        int mat[][] = new int[10 * numberRotations+1][3];
        Random r = new Random();
        GreenfootImage bg = getWorld().getBackground();
        GreenfootImage bgBak = new GreenfootImage(bg);
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                mat[i][j] =  r.nextInt(256);
            }
        }
        for(int i=0; i <= 10 * numberRotations; i = i + 1){
            setRotation(i*36);
            GreenfootImage image = getImage();
            if(i < 5 * numberRotations){
                image.scale(image.getWidth() + 40, image.getHeight() + 50);
            } else {
                image.scale(image.getWidth() - 40, image.getHeight() - 50);
            }    
            setImage(image);
            GreenfootImage screen = new GreenfootImage(bg.getWidth(), bg.getHeight());
            screen.setColor(new Color(mat[i][0], mat[i][1], mat[i][2]));
            screen.fill();
            bg.drawImage(screen, 0,0);
            Greenfoot.delay(1);
            Greenfoot.delay(1);
        }
        bg.drawImage(bgBak, 0,0);
        setImage(standingFile);
        returnToSeat();
    }
     /**
     * Prints the string that is passed to it.
     */
    public void myHobby(String s) {
         System.out.println(s);
    }
     /**
     * Returns my number of siblings as an int.
     */
    public int numberOfSiblings(){
        return 5;
    }
     /**
     * Return my number of brothers as an int;
     */
    public int numberOfBrothers(){
        return 1;
    }
     /**
     * Returns my number of sisters as an int.
     */
    public int numberOfSisters(){
        return 4;
    }
    }
