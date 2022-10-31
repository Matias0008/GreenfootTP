import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    Arrow arrow = new Arrow();
    private int option = 0; // 0 = play, 1 = exit
    GreenfootSound music = new GreenfootSound("Music.mp3");
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 450, 1);
        prepareMundo();
        music();
    }
    
    private void prepareMundo()
    {
        addObject (new Start(),620,250);
        addObject (new Exit(),620,350);
        addObject (arrow, 520,250);
        
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("up") && option !=0) {option++;}
        if (Greenfoot.isKeyDown("down") && option !=1) {option++;}
        
        if (option >= 2) option  = 0;
        if (option < 0) option = 1;
        
        arrow.setLocation(520,250 +(option *100));
        
        if (Greenfoot.isKeyDown("enter"))
        {
            switch(option){
                case 0:
                    Greenfoot.setWorld(new MyWorld());
                    Greenfoot.playSound("Gong.mp3");
                    music.stop();
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
            }
        
        }
    }
    
    public void music()
    {
        music.play();
    }
}
