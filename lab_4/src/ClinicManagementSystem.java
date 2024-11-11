import java.util.*;


public class ClinicManagementSystem {
    private static HashMap<String, Patient> patients = new HashMap<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static PriorityQueue<Appointment> appointments = new PriorityQueue<>(Comparator.comparing(Appointment::getDate));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Clinic Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient by ID");
            System.out.println("4. Add Doctor");
            System.out.println("5. View Doctors");
            System.out.println("6. Delete Doctor by ID");
            System.out.println("7. Schedule Appointment");
            System.out.println("8. View Appointments");
            System.out.println("9. Add Medical History");
            System.out.println("10. View patients medical history");
            System.out.println("11. Add Prescription");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPatient(scanner);
                case 2 -> viewPatients();
                case 3 -> deletePatientById(scanner);
                case 4 -> addDoctor(scanner);
                case 5 -> viewDoctors();
                case 6 -> deleteDoctorById(scanner);
                case 7 -> scheduleAppointment(scanner);
                case 8 -> viewAppointments();
                case 9 -> addMedicalHistory(scanner);
                case 10 -> viewPatientsMedicalHistory();
                case 11 -> addPrescription(scanner);
                case 12 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter birth date (yyyy-mm-dd): ");
        String birthDateStr = scanner.nextLine();
        Date birthDate = java.sql.Date.valueOf(birthDateStr);

        Patient patient = new Patient(id, firstName, lastName, birthDate);
        patients.put(id, patient);
        System.out.println("Patient added successfully.");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("Patients:");
        patients.values().forEach(System.out::println);
    }

    private static void deletePatientById(Scanner scanner) {
        System.out.print("Enter patient ID to delete: ");
        String id = scanner.nextLine();
        if (patients.remove(id) != null) {
            System.out.println("Patient deleted successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter doctor's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();
        doctors.add(new Doctor(name, specialty));
        System.out.println("Doctor added successfully.");
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        System.out.println("Doctors:");
        doctors.forEach(System.out::println);
    }

    private static void deleteDoctorById(Scanner scanner) {
        System.out.print("Enter doctor's name to delete: ");
        String name = scanner.nextLine();
        boolean removed = doctors.removeIf(doctor -> doctor.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Doctor deleted successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = patients.get(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = doctors.stream().filter(d -> d.getName().equalsIgnoreCase(doctorName)).findFirst().orElse(null);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        Date date = java.sql.Date.valueOf(dateStr);

        appointments.add(new Appointment(patient, doctor, date));
        System.out.println("Appointment scheduled successfully.");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("Appointments:");
        appointments.forEach(System.out::println);
    }

    private static void addMedicalHistory(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = patients.get(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter medical history record: ");
        String record = scanner.nextLine();
        patient.addMedicalHistory(record);
        System.out.println("Medical history updated successfully.");
    }

    private static void viewPatientsMedicalHistory() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        }
        System.out.println("Patients:");
        for (Patient patient : patients.values()) {
            System.out.println(patient);
            for (String record : patient.getMedicalHistory()) {
                System.out.println("\t" + record);
            }
        }
    }

    private static void addPrescription(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        Patient patient = patients.get(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter prescription: ");
        String prescription = scanner.nextLine();
        patient.addPrescription(prescription);
        System.out.println("Prescription added successfully.");
    }
}