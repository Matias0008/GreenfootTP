import greenfoot.*;

public class Man extends Actor {
    GreenfootImage punchingRight;
    GreenfootImage punchingLeft;
    int walkTimer;
    int speed;
    int power;
    int life;
    int rotate;
    int punchTimer;
    int defenceTimer;
    int killCount;
    boolean spaceDown;
    boolean sDown;
    boolean aDown;
    boolean keyForDefence;
    boolean isRight;
    boolean isLeft;
    boolean isPunching;
    boolean isDefending;
    boolean avaiableSpecialMove;
 
    public Man() {
        punchingRight = new GreenfootImage("punchRight.png");
        punchingLeft = new GreenfootImage("punchLeft.png");
        walkTimer = 0;
        punchTimer = 0;
        defenceTimer = 100;
        speed = 0;
        power = 0;
        life = 100;
        killCount = 0;
    }

    public void act() {
        keyPressWalk();
        keyPressPush();
        keyPressKick();
        keyPressSpecialMove();
        checkEnemy();
        handleDefence();
        move(speed);
        getWorld().showText("HP: " + Integer.toString( getLife() ), 760, ( getWorld().getHeight() / 2 ) - 25);
        getWorld().showText("Kills: " + getKill(), 760, getWorld().getHeight() / 2);
    }
    
    public void takeDamage( int damage ) {
        if ( (life - damage) <= 0) {
            this.life = 0;
            getWorld().showText("HP: " + Integer.toString( getLife() ), 760, ( getWorld().getHeight() / 2 ) - 25);
            Greenfoot.stop();
            Greenfoot.playSound("youLose.mp3");
            getWorld().addObject( new GameOver("youLose.png") , getWorld().getWidth()/2, getWorld().getHeight()/2);
        } else  if ( !this.isDefending ){
            this.life -= damage;
        }
    }

    public void keyPressPush() {
        String auxiliar = isLeft ? "punchLeft" : "punchRight";
        String auxiliar2 = isLeft ? "Left2" : "Right2";

        if ( !isPunching && Greenfoot.isKeyDown("s") && !this.spaceDown ) {
            setImage("stand" + auxiliar2 + ".png");
            punchTimer++;
        }
        
        if ( Greenfoot.isKeyDown("s") && punchTimer == 2 && !this.spaceDown  ) {
            setImage(auxiliar + ".png");
            isPunching = true;
        }
        
        if ( isPunching && !Greenfoot.isKeyDown("s")  ) {
            setImage("stand" + auxiliar2 + ".png");
            isPunching = false;
            punchTimer -= 2;
        }

    }

    public void keyPressWalk() {
        String auxiliar = this.isLeft ? "Left" : "Right";

        if ( ( Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left") ) && !this.spaceDown ) {
            this.isRight = !this.isLeft;
            this.isLeft =  Greenfoot.isKeyDown("left") ? true : false;

            walkTimer++;
            move(this.isRight ? 5 : -5);
 
            switch (walkTimer) {
                case 0:
                    setImage("stand" + auxiliar + "1.png");
                    break;
                case 6:
                    setImage("stand" + auxiliar + "1.png");
                    break;
                case 11:
                    setImage("stand" + auxiliar + "2.png");
                    break;
                case 16:
                    setImage("stand" + auxiliar + "2.png");
                    break;
                case 21:
                    setImage("stand" + auxiliar + "2.png");
                    walkTimer = 0;
                    break;
            }
        }
    }

    public void keyPressKick() {
        if ( ( Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") ) && !this.spaceDown ) {
            String auxiliar = this.isLeft ? "Left" : "Right";
    
            walkTimer++;
            switch( walkTimer ) {
                case 0:
                    setImage("kick" + auxiliar + "1.png");
                    break;
                case 6:
                    setImage("kick" + auxiliar + "1.png");
                    break;
                case 11:
                    setImage("kick" + auxiliar + "2.png");
                    break;
                case 16:
                    setImage("kick" + auxiliar + "2.png");
                    break;
                case 21:
                    setImage("stand" + auxiliar + "2.png");
                    walkTimer = 0;
                    break;
            }            
        }
    }

    public void keyPressSpecialMove() {
        String prefixImage = this.isLeft ? "Left" : "Right";
        int speed = this.isLeft ? -10 : 10;

        if ( Greenfoot.isKeyDown("space") && !isAtEdge() && getAvaiableSpecialMove() && !Greenfoot.isKeyDown("s") ) {
            this.speed = speed;
            this.spaceDown = true;
            setImage("specialMove" + prefixImage + ".png");
            Greenfoot.playSound("Whoosh.mp3");
        }
        
        if ( !Greenfoot.isKeyDown("space") && isAtEdge() ) {
                this.speed = 0;
                this.spaceDown = false;
                setAvaiableSpecialMove(false);
                setImage("stand" + prefixImage + "1.png");
        }
    }
    
    public void setAvaiableSpecialMove(boolean avaiableSpecialMove) {
        this.avaiableSpecialMove = avaiableSpecialMove;
    }

    public void setLife(int step) {
        if ( this.life + step < 100 ) {
            this.life += step;
        } else {
            this.life = 100;
        }

    }

    public void setMove(int speed) {
        move(speed);
    }
    
    public void checkEnemy(){        
        for (Enemy enemy : getIntersectingObjects( Enemy.class ) )
        {
            boolean faceToFace = enemy.getIsLeft() == this.isLeft;
            if ( enemy != null ) {
                if ( sDown != Greenfoot.isKeyDown("s") && faceToFace) {
                    sDown = !sDown;
                    if (sDown) enemy.takeDamage( 20 );
                }
                
                if ( aDown != Greenfoot.isKeyDown("a") && faceToFace) {
                    aDown = !aDown;
                    if (aDown) enemy.takeDamage( 22 );
                    
                }

                if ( this.spaceDown && this.getAvaiableSpecialMove() && faceToFace ) {
                    enemy.takeDamage( 12 );
                }
                
            }
        }
    }
    
    public void handleDefence() {
        String auxiliar = this.isLeft ? "Left" : "Right" ;
    
        if ( keyForDefence != Greenfoot.isKeyDown("d") && !this.spaceDown) {
            keyForDefence = !keyForDefence;
            if (keyForDefence) {
                setImage("defence" + auxiliar + ".png");
                isDefending = true;
            }
        }
            
        if ( isDefending && !this.spaceDown ) {
            defenceTimer--;
            if ( defenceTimer <= 0 ) {
                setImage("stand" + auxiliar + "1.png");
                isDefending = false;
                defenceTimer = 100;
            }
        }   
    }
        
    public void setKill(){
        this.killCount++;
    }
    
    public int getKill(){
        return this.killCount;
    }
    
    public boolean getIsLeft() {
        return this.isLeft;
    }

    public boolean getIsRight() {
        return this.isRight;
    }
    
    public int getLife() {
        return this.life;
    }

    public boolean getAvaiableSpecialMove() {
        return this.avaiableSpecialMove;
    }
    
    public boolean getSpaceDown() {
        return this.spaceDown;
    }

}