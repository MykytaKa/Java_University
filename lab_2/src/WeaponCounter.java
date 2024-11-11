import java.util.Map;
import java.util.HashMap;

public class WeaponCounter {
    private Weapon[] weapons;
    private Map<String, Integer> counter;

    public WeaponCounter(Weapon[] weapons){
        this.weapons = weapons;
        this.counter = new HashMap<>(Map.of(
        "EdgedWeapon", 0,
        "Firearm", 0
        ));
        countWeapon();
    }

    private void countWeapon(){
        for(Weapon weapon : weapons){
            if (weapon instanceof EdgedWeapon){
                counter.put("EdgedWeapon", counter.get("EdgedWeapon") + 1);
            }
            if (weapon instanceof Firearm){
                counter.put("Firearm", counter.get("Firearm") + 1);
            }
        }
    }

    public void printWeaponCount(){
        System.out.println("Кількість вогнепальної зброї: " + counter.get("Firearm"));
        System.out.println("Кількість холодної зброї: " + counter.get("EdgedWeapon"));
    }

    public void printWeaponInfo(){
        for(Weapon weapon : weapons){
            System.out.println(weapon.toString());
        }
    }
}
