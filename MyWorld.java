import greenfoot.*;

public class MyWorld extends World {
    Man man;
    boolean existBoss;
    int i = 0;
    int y = 0;
    int e = 0;

    public MyWorld() {
        super(800, 600, 1);
        GreenfootImage bg = new GreenfootImage("dojo background.jpg");
        bg.scale( getWidth(), getHeight() );
        man = new Man();
        setBackground(bg);
        prepare();
    }

    public void act() {
        i++;
        y++;
        e++;
        spawnHealth();
        spawnPower();
        if ( man.getKill() == 10  && getObjects( Simple.class ).size() == 0 )  {
            GreenfootImage bossBg = new GreenfootImage("bossBg.jpg");
            bossBg.scale(getWidth(), getHeight());
            setBackground(bossBg);
            spawnBoss();
        } else if ( man.getKill() < 10 ) {
            spawnEnemies();
        }
    }
    
    public void prepare() {
        addObject(man, 200, 500);

    }

    public void spawnHealth() {
        if (i == 200) {
            addObject( new Health(), Greenfoot.getRandomNumber(800), 1 );
            i = 0;
        }
    }

    public void spawnPower() {
        if (y == 900) {
            addObject( new Power(), Greenfoot.getRandomNumber(500), 1 );
            y = 0;
        }
    }

    public void spawnEnemies() {
        if (e == 300) {
                addObject( new Simple() , 800, 500 );
                e++;
                if (e == 301) {
                    addObject( new Simple(), -800, 500) ;
                }
                e = 0;
        }
    }
    
    public void spawnBoss() {
        if (!existBoss) 
        {
            addObject( new Boss(900) , 900, 500 );
            existBoss = true;
            Greenfoot.playSound("Gong.mp3");
            Greenfoot.playSound("evilLaugh.mp3");
        };
    }
    

    
}
