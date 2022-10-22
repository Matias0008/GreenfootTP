import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fragment extends Actor
{
    int x;
    int y;

    public void act()
    {
        int y = getY();
        changeLocation(y, 8);
        
        if (isAtEdge()) {
            getWorld().removeObject(this);
        } else if(isTouching(Man.class)) {
            Greenfoot.stop();    
        }
 
        
    }
    
    public void changeLocation(int y, int step){
        setLocation(getX(), y + step);
    }
    
    public boolean isAtEdge() {
        return getY() > (getWorld().getHeight() - 15);
    }
    
}
