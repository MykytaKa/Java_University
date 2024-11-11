public class OfficeBuilding implements Building {
    private double area;
    private int numberOfRooms;
    private boolean isRented;

    public OfficeBuilding(double area, int numberOfRooms) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.isRented = false;
    }

    @Override
    public void build() {
        System.out.println("Офісну будівлю побудовано з площею " + area + " кв. м.");
    }

    @Override
    public double calculatePricePerSquareMeter() {
        return 2000.75;
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public void increaseArea(double additionalArea) {
        area += additionalArea;
        System.out.println("Площа офісної будівлі збільшена на " + additionalArea + " кв. м.");
    }

    @Override
    public void rentOut() {
        if (!isRented) {
            isRented = true;
            System.out.println("Офісна будівля здана в оренду.");
        } else {
            System.out.println("Офісна будівля вже здана.");
        }
    }

    @Override
    public void repairRoom(int roomNumber) {
        if (roomNumber <= numberOfRooms) {
            System.out.println("Ремонт виконано в офісі номер " + roomNumber);
        } else {
            System.out.println("Офіс з номером " + roomNumber + " не існує.");
        }
    }

    public void rentOfficeSpace(int roomNumber) {
        if (roomNumber <= numberOfRooms && !isRented) {
            System.out.println("Офіс номер " + roomNumber + " зданий в оренду.");
        } else {
            System.out.println("Офіс номер " + roomNumber + " вже зданий або не існує.");
        }
    }
}
