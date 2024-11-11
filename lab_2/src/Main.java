public class Main {
    public static void main(String[] args) {
        EdgedWeapon knife = new EdgedWeapon(5, 10);
        Firearm m4a1_s = new Firearm(40, 20);
        Firearm mp9 = new Firearm(90, 25);
        EdgedWeapon sword = new EdgedWeapon(15, 40);

        Weapon[] weapons = {knife, m4a1_s, mp9, sword};

        WeaponCounter counter = new WeaponCounter(weapons);
        counter.printWeaponInfo();
        counter.printWeaponCount();
    }
}