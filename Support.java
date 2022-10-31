import greenfoot.*;

public class Support extends Actor
{    
    public Man getMan() {
        return (Man)getWorld().getObjects(Man.class).get(0);
    }
    
    public void changeLocation(int step){
        setLocation(getX(), getY() + step);
    }
    
    public boolean isAtEdge(int width) {
        return getY() > ( getWorld().getHeight() - width );
    }
    
}