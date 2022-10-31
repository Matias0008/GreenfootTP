import greenfoot.*;

public class Health extends Support
{
    Man man;

    public void act()
    {
        if ( !isAtEdge(70) ) {
            changeLocation(8);
        }
        
        if( isTouching(Man.class) ) {
            man = getMan();
            man.setLife(5);
            Greenfoot.playSound("itemCollected.mp3");
            getWorld().removeObject(this);  
        }       
    }
}