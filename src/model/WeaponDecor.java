package model;

public abstract class WeaponDecor implements WeaponComponent{
    
    protected WeaponComponent weapon;
    
    public WeaponDecor(WeaponComponent weapon){
        this.weapon = weapon;
    }
    
    @Override
    public void shoot(int sx, int sy, int tx, int ty){
        weapon.shoot(sx, sy, tx, ty);
    }
    
}