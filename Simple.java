import greenfoot.*;

public class Simple extends Enemy
{

    public Simple(int life) {
        super(life);
    }
    
    public Simple() {
        super(100);
    }

    public void act()
    {
        goToMan( 50, "enemyStandRight", "enemyStandLeft");
        attackMan( 3, "enemyStand", "enemyPunch" );
    }

}