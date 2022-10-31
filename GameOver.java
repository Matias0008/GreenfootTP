import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor
{
    public GameOver( String image ) {
        GreenfootImage gImage = new GreenfootImage(image);
        switch( image ) {
            case "youLose.png":
                gImage.scale( 600, 600 );                
        }
        setImage(gImage);
    }
}