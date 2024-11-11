public class ShoppingCenter implements Building {
    private double area;
    private int numberOfShops;
    private boolean isRented;

    public ShoppingCenter(double area, int numberOfShops) {
        this.area = area;
        this.numberOfShops = numberOfShops;
        this.isRented = false;
    }

    @Override
    public void build() {
        System.out.println("Торговий центр побудовано з площею " + area + " кв. м.");
    }

    @Override
    public double calculatePricePerSquareMeter() {
        return 3000.90;
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfShops;
    }

    @Override
    public void increaseArea(double additionalArea) {
        area += additionalArea;
        System.out.println("Площа торгового центру збільшена на " + additionalArea + " кв. м.");
    }

    @Override
    public void rentOut() {
        if (!isRented) {
            isRented = true;
            System.out.println("Торговий центр зданий в оренду.");
        } else {
            System.out.println("Торговий центр вже зданий.");
        }
    }

    @Override
    public void repairRoom(int roomNumber) {
        if (roomNumber <= numberOfShops) {
            System.out.println("Ремонт виконано в магазині номер " + roomNumber);
        } else {
            System.out.println("Магазин з номером " + roomNumber + " не існує.");
        }
    }

    public void openShop(int shopNumber) {
        if (shopNumber <= numberOfShops) {
            System.out.println("Магазин номер " + shopNumber + " відкрито.");
        } else {
            System.out.println("Магазин з номером " + shopNumber + " не існує.");
        }
    }
}
