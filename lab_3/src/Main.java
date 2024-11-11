
public class Main {
    public static void main(String[] args) {
        House myHouse = new House(40.3, 5);
        OfficeBuilding myOffice = new OfficeBuilding(400.1, 123);
        ShoppingCenter myCenter = new ShoppingCenter(250.3, 63);
        Building[] buildings = {myHouse, myOffice, myCenter};

        for (Building building : buildings) {
            building.build();
            building.rentOut();
            System.out.println(building.calculatePricePerSquareMeter());
            System.out.println("Кількість кімнат: " + building.getNumberOfRooms());
            building.increaseArea(20.0);
            building.repairRoom(52);
            if (building instanceof OfficeBuilding){
                ((OfficeBuilding) building).rentOfficeSpace(5);
            }
            if (building instanceof ShoppingCenter){
                ((ShoppingCenter) building).openShop(62);
            }
            System.out.println();
        }
    }
}