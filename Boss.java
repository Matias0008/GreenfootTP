import greenfoot.*;

public class Boss extends Enemy
{

    public Boss(int life) {
        super(life);
    }

    public void act()
    {
        goToMan( 50, "bossStandRight", "bossStandLeft");
        attackMan( 14, "bossStand", "bossKick" );
    }

}