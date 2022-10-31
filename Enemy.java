    import greenfoot.*;

public class Enemy extends Actor
{
    Man man;
    int life;
    int walkTimer;
    int punchTimer;
    int punchAnimationTimer;
    boolean isLeft;
    
    public Enemy( int life ) {
        this.life = life;
        this.walkTimer = 0;
    }
    
    public Man getMan() {
        return (Man) getWorld().getObjects(Man.class).get(0);
    }
    
    public void goToMan( int offset, String imageRight, String imageLeft) {
        this.man = getMan();
        this.isLeft = man.getX() > getX() ? true : false;

        int rotation = getRotation();
        int manX = isLeft ? man.getX() - offset : man.getX() + offset;
        int manY = man.getY();
        String prefixImage = isLeft ? imageRight  : imageLeft;

        turnTowards(manX, manY);
        move(2);
        setRotation(rotation);
        walkTimer++;

        switch (walkTimer) {
            case 0:
                setImage( prefixImage + "1.png" );
                break;
            case 8:
                setImage( prefixImage + "1.png" );
                break;
            case 14:
                setImage( prefixImage + "2.png" );
                break;
            case 20:
                setImage( prefixImage + "2.png" );
                break;
            case 26:
                setImage( prefixImage + "2.png" );
                walkTimer = 0;
                break;
        }

    }

    public boolean contact( Class myClass ) {
        int intersect = this.isLeft ? 20 : -20;
        return getOneObjectAtOffset(intersect, 0, myClass) != null;
    }

    public void attackMan( int damage, String prefixImageStand, String prefixImagePunch ) {
        String prefixImage = isLeft ? "Right" : "Left";

        if ( contact( Man.class ) ) {
            punchTimer++;
            punchAnimationTimer++;
            move(0);

            switch (punchAnimationTimer) {
                case 6:
                    setImage(prefixImageStand + prefixImage + "1.png");
                    break;
                case 11:
                    setImage(prefixImageStand + prefixImage + "1.png");
                    break;
                case 30:
                    setImage(prefixImagePunch + prefixImage + ".png");
                    break;
                case 40:
                    setImage(prefixImagePunch + prefixImage + ".png");
                    break;
                case 50:
                    setImage(prefixImageStand + prefixImage + "2.png");
                    punchAnimationTimer = 0;
                    break;

            }

            if ( punchTimer == 30 ) {
                man.takeDamage( damage );
                punchTimer = 0;
            }

            if ( man.getLife() == 0 ) Greenfoot.stop();
        }
    }
    
    public void takeDamage( int damage ) {
        if ( this.life - damage <= 0 ) {
            man.setKill();

            if ( whoAmI() == "Boss" ) {
                Greenfoot.stop();
                Greenfoot.playSound("youWin.mp3");
                Greenfoot.playSound("winnerMusic.mp3");
                getWorld().addObject( new GameOver("youWin.png") , ( getWorld().getWidth() - 70)/2, getWorld().getHeight()/2);
            }
            getWorld().removeObject(this);

        } else {
            this.life -= damage;
            Greenfoot.playSound("Punch.mp3");
        }
    }
    
    public String whoAmI() {
        return this.getClass().getName();
    }
    
    public int getLife() {
        return this.life;
    }
    
    public boolean getIsLeft() {
        return this.isLeft;
    }

}