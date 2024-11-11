public abstract class Weapon {
    protected int damage;
    public Weapon(int damage) {this.damage = damage;}
    public abstract int getDamage();
    public abstract void setDamage(int damage);
}

