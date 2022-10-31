import greenfoot.*;

public class Power extends Support
{
    Man man;
    public void act()
    {
        if( !isAtEdge(80) ) {
            changeLocation(8);
        }
        
        if( isTouching(Man.class ) ) {
            man = getMan();
            man.setAvaiableSpecialMove(true);
            Greenfoot.playSound("itemCollected.mp3");
            getWorld().removeObject(this);    
        }
    }
    
    public Power()
    {
        GreenfootImage image = getImage();  
        image.scale(50, 80);
        setImage(image);
    }
}
