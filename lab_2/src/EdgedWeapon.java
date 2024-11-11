public class EdgedWeapon extends Weapon {
    private int length;

    public EdgedWeapon(int damage, int length) {
        super(damage);
        this.length = length;
    }

    @Override
    public String toString() {
        return "Edged weapon with: \n\tlength: " + length + ";\n\tdamage: " + damage + ";";
    }

    @Override
    public int getDamage() {return damage;}

    @Override
    public void setDamage(int damage) {this.damage = damage;}

    public int getLength() {return length;}
    public void setLength(int length) {this.length = length;}
}