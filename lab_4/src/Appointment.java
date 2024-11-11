import java.util.*;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private Date date;

    public Appointment(Patient patient, Doctor doctor, Date date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return "Appointment on " + date + " with Dr. " + doctor.getName() + " for " + patient.getFirstName() + " " + patient.getLastName();
    }
}
