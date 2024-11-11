import java.util.*;

public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<String> medicalHistory = new ArrayList<>();
    private List<String> prescriptions = new ArrayList<>();

    public Patient(String id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Date getBirthDate() { return birthDate; }
    public List<String> getMedicalHistory() { return medicalHistory; }
    public List<String> getPrescriptions() { return prescriptions; }

    public void addMedicalHistory(String record) { medicalHistory.add(record); }
    public void addPrescription(String prescription) { prescriptions.add(prescription); }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + birthDate + " (ID: " + id + ")";
    }
}