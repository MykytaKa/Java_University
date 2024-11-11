public interface Building {
    void build();
    double calculatePricePerSquareMeter();
    int getNumberOfRooms();
    void increaseArea(double additionalArea);
    void rentOut();
    void repairRoom(int roomNumber);
}
