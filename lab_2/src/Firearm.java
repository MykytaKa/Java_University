public class Firearm extends Weapon{
    private int ammoCapacity;

    Firearm(int damage, int ammoCapacity){
        super(damage);
        this.ammoCapacity = ammoCapacity;
    }

    @Override
    public String toString(){
        return "Firearm with: \n\tammo capacity: " + ammoCapacity + ";\n\tdamage: " + damage + ";";
    }

    @Override
    public int getDamage() {return damage;}

    @Override
    public void setDamage(int damage) {this.damage = damage;}

    public int getAmmoCapacity(){return ammoCapacity;}
    public void setAmmoCapacity(int ammoCapacity){this.ammoCapacity = ammoCapacity;}
}
