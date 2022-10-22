import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Man extends Actor
{
    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // private GreenfootImage walking1;
    // private GreenfootImage walking2;
    // private GreenfootImage kicking1;
    // private GreenfootImage kicking2;
    private int walkTimer;
    private int speed;
    private int i;
    private int y;
    private int j;
    private int t;
    private boolean isRight;
    private boolean isLeft;
    
    
    public Man()
    {
        // walking1 = new GreenfootImage("standRight1.png");
        // walking2 = new GreenfootImage("standRight2.png");
        // kicking1 = new GreenfootImage("kickRight1.png");
        // kicking2 = new GreenfootImage("kickRight2.png");
        walkTimer = 0;
        speed = 0;
        i = 0;
        y = 0;
        j = 0;
        t = 0;
    }
    public void act()
    {
        keyPressWalk();
        keyPressKick();
        keyPressSpecialMove();
        keyPressDefense();
        move(speed);
    }
    
    public void keyPressWalk()
    {
        if (Greenfoot.isKeyDown("right") && i == 0 && j  == 0 && t  == 0)
    { 
        isRight = true;
        isLeft = false;
        walkTimer ++;
        move(5);
            
            switch(walkTimer) {
                case 0:
                    setImage("standRight1.png");
                    break;
                case 6:
                    setImage("standRight1.png");
                    break;
                case 11:
                    setImage("standRight2.png");
                    break;
                case 16:
                    setImage("standRight2.png");
                    break;
                case 21:
                    setImage("standRight2.png");
                    walkTimer = 0;
                    break;
            }
    }
    else
        {
            if (Greenfoot.isKeyDown("left") && i == 0 && j == 0 && t == 0)
        { 
            isLeft = true;
            isRight = false;
            move(-5);
            walkTimer ++;

            if(walkTimer == 0)
                setImage("standLeft1.png");
            if(walkTimer == 6)
                setImage("standLeft1.png");
            if(walkTimer == 11)
                setImage("standLeft2.png");
            if(walkTimer == 16)
                setImage("standLeft2.png");
            if(walkTimer == 21)
            {
                setImage("standLeft2.png");
                walkTimer = 0;
            }
        }
        }
        
        // if (Greenfoot.isKeyDown("up"))
        // {    
        // setLocation(getX(), getY()-speed); //up
        // walkTimer ++;

            // if(walkTimer == 0)
                // setImage("parado 1.png");
            // if(walkTimer == 6)
                // setImage("parado 1.png");
            // if(walkTimer == 11)
                // setImage("parado 2.png");
            // if(walkTimer == 16)
                // setImage("parado 2.png");
            // if(walkTimer == 21)
            // {
                // setImage("parado 2.png");
                // walkTimer = 0;
            // }
        // }
        // if (Greenfoot.isKeyDown("down"))
        // {
        // setLocation(getX(), getY()+speed); //down
        // walkTimer ++;

            // if(walkTimer == 0)
                // setImage("parado 1.png");
            // if(walkTimer == 6)
                // setImage("parado 1.png");
            // if(walkTimer == 11)
                // setImage("parado 2.png");
            // if(walkTimer == 16)
                // setImage("parado 2.png");
            // if(walkTimer == 21)
            // {
                // setImage("parado 2.png");
                // walkTimer = 0;
            // }
        // }
    
    }
    
    public void keyPressKick()
    {
        if (Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && isRight == true)
        { 
            j = 1;
            walkTimer ++;
            if(walkTimer == 0)
                setImage("kickRight1.png");
            if(walkTimer == 6)
                setImage("kickRight1.png");
            if(walkTimer == 11)
                setImage("kickRight2.png");
            if(walkTimer == 16)
                setImage("kickRight2.png");
            if(walkTimer == 21)
            {
                setImage("standRight2.png");
                walkTimer = 0;
            }
        }else{
            j = 0;
        }
        
         if (Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && isLeft == true)
        { 
            j = 1;
            walkTimer ++;
            if(walkTimer == 0)
                setImage("kickLeft1.png");
            if(walkTimer == 6)
                setImage("kickLeft1.png");
            if(walkTimer == 11)
                setImage("kickLeft2.png");
            if(walkTimer == 16)
                setImage("kickLeft2.png");
            if(walkTimer == 21)
            {
                setImage("standLeft2.png");
                walkTimer = 0;
            }
        }else{
            j = 0;
        }
        
        if (Greenfoot.isKeyDown("s") && isRight == true)
        {
            j = 1;
            walkTimer ++;
            if(walkTimer == 0)
                setImage("standRight1.png");
            if(walkTimer == 6)
                setImage("standRight1.png");
            if(walkTimer == 11)
                setImage("punchRight.png");
            if(walkTimer == 16)
                setImage("punchRight.png");
            if(walkTimer == 21)
            {
                setImage("standRight2.png");
                walkTimer = 0;
            }
        }
         if (Greenfoot.isKeyDown("s") && isLeft == true)
        {
            j = 1;
            walkTimer ++;
            if(walkTimer == 0)
                setImage("standLeft1.png");
            if(walkTimer == 6)
                setImage("standLeft1.png");
            if(walkTimer == 11)
                setImage("punchLeft.png");
            if(walkTimer == 16)
                setImage("punchLeft.png");
            if(walkTimer == 21)
            {
                setImage("standLeft2.png");
                walkTimer = 0;
            }
        }
    
    }
    public void keyPressSpecialMove()
    {
        if (Greenfoot.isKeyDown("space") && isRight == true && !isAtEdge())
            {   
                i = 1;
                y = 1;
                speed = 10;
                setImage("specialMoveRight.png");
            }
        else{
            if (!Greenfoot.isKeyDown("space") && isAtEdge())
            {
               speed = 0;
               setImage("standLeft1.png");
               i = 0;
               y = 0;
            }
            }
        if (Greenfoot.isKeyDown("space") && isLeft == true && !isAtEdge())
            {
                i = 1;
                y = 1;
                speed = -10;
                setImage("specialMoveLeft.png");
            }
        else{
            if (!Greenfoot.isKeyDown("space") && isAtEdge())
            {
               speed = 0;
               setImage("standRight1.png");
               i = 0;
               y = 0;
            }
            }    
            
        }
        
    public void keyPressDefense()
    {
        if (Greenfoot.isKeyDown("down") && isRight == true && y == 0)
        {
            t = 1;
            setImage("defenceRight.png");
        }
        else
        {
            t = 0;
        }
        
        if (Greenfoot.isKeyDown("down") && isLeft == true && y == 0)
        {
            setImage("defenceLeft.png");
            t = 1;
        }
        else
        {
            t = 0;
        }
    }
}
    
