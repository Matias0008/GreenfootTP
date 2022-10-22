import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    Man man;
    int manX;
    int manY;   
    
    public void act()
    {
        goToMan();
    }
    
    public void goToMan() {
        man = (Man)getWorld().getObjects(Man.class).get(0);
        int rotation = getRotation();
        int manX = man.getX();
        int manY = man.getY() + 2;
        turnTowards(manX,manY);
        move(2);
        setRotation(rotation);
    }
}
