public class House implements Building {
    private double area;
    private int numberOfRooms;
    private boolean isRented;

    public House(double area, int numberOfRooms) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.isRented = false;
    }

    @Override
    public void build() {
        System.out.println("Дім побудовано з площею " + area + " кв. м.");
    }

    @Override
    public double calculatePricePerSquareMeter() {
        return 1200.75;
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public void increaseArea(double additionalArea) {
        area += additionalArea;
        System.out.println("Площа дому збільшена на " + additionalArea + " кв. м.");
    }

    @Override
    public void rentOut() {
        if (!isRented) {
            isRented = true;
            System.out.println("Дім зданий у найм.");
        } else {
            System.out.println("Дім вже зданий.");
        }
    }

    @Override
    public void repairRoom(int roomNumber) {
        if (roomNumber <= numberOfRooms) {
            System.out.println("Ремонт виконано в кімнаті " + roomNumber);
        } else {
            System.out.println("Кімната з номером " + roomNumber + " не існує.");
        }
    }
}
