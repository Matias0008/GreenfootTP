import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int i = 0;
    public MyWorld()
    {    
        super(800, 600, 1); 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        GreenfootImage bg = new GreenfootImage("dojo background.jpg"); // adjust filename as needed
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
       populateWorld();
       generateFragments();
        
    }
    
    public void act() {
        i++;
        generateFragments();
    }
    
    public void populateWorld()
    {
         Man man = new Man();
         addObject(man,200,500);
    }
    
    public void generateFragments() {
        if (i == 300) {
            for(int i = 0; i < 2; i++) {
             addObject(new Fragment(),Greenfoot.getRandomNumber(800),1);
        }
        i = 0;
        }
    }

}
