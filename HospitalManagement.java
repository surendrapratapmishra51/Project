package Project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement {
    public static class Patient{
       private static int idCounter = 1;

       private int id;
        private  String name;
        private  String gender;
        private   int age;
        public Patient(String name,int age,String gender){
            this.id = idCounter++;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
        public int getId(){
            return id;
        }
        @Override
        public String toString(){
            return "Patient ID: " +id+ ", Name: " +name+ ", age: " +age+ ", Gender "+gender;
        }
    }
    public static class Doctor {
        private static int idCounter = 1;
      private int id;
       String name;
       String speciality;
       public Doctor(String name, String speciality){
           this.id = idCounter++;
           this.name = name;
           this.speciality = speciality;
       }
        public int getId(){
           return id;
        }
        @Override
        public String toString(){
           return "Doctor ID: " +id+ ",Name: " + name + ",Speciality:"+speciality;
        }
    }
    public static class Appointment{
        private Patient patient;
        private Doctor doctor;
        private String date;
        public Appointment(Patient patient,Doctor doctor, String date){
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
        }
        @Override
        public String toString(){
            return "Appointment: [Patient:" + patient+ ".Doctor:" +doctor+ ",Date: " + date + "]";
        }
    }
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
           System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patient");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointment");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    ScheduleAppointment(scanner);
                    break;
                case 4:
                    viewPatient();
                break;
                case 5:
                    viewDoctor();
                break;
                case 6:
                        viewAppoinment();
                break;
                case 0:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again");
            }
        } while(choice != 0);
            scanner.close();
        }
        private static void addPatient(Scanner scanner){
            System.out.print("Enter Patient Name: ");
            String name = scanner.next();
            System.out.print("Enetr the Patient age ");
            int age = scanner.nextInt();
            System.out.print("Enter Patient Gender: ");
            String gender = scanner.next();

            Patient patient = new Patient(name, age, gender);
            patients.add(patient);

            System.out.print("Patient added successfully");

    }
    private static void addDoctor(Scanner scanner){
        System.out.print("Enter Doctor Name :");
        String name = scanner.next();
        System.out.print("Enter Doctor  Speciaality:");
        String speciality = scanner.next();
        Doctor doctor = new Doctor(name, speciality);
        doctors.add(doctor);
        System.out.print(" Doctor added successfully");
    }
    private static void ScheduleAppointment(Scanner scanner){
        System.out.print("Enter Patient ID: ");
        int patinetId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (yyyy-MM-DD: ");
        String date = scanner.next();

        Patient patient = findPatientById(patinetId);
        Doctor doctor  = findDoctorById(doctorId);
        if(patient != null && doctor != null){
            Appointment appointment = new Appointment(patient,doctor,date);
            appointments.add(appointment);
            System.out.print("Appointment scheduled successfully!");

        }
        else{
            System.out.print("Invalid Patient ID or Doctor ID");
        }
    }
    private static void viewPatient(){
        System.out.println("List of patient :");
        for (Patient patient:patients){
            System.out.print(patient);
        }
    }
    private static void viewDoctor(){
        System.out.println("List of doctor :");
        for (Doctor doctor:doctors){
            System.out.print(doctor);
        }
    }
    private static void viewAppoinment(){
        System.out.println("List of Appointment :");
        for (Appointment appointment:appointments){
            System.out.print(appointment);
        }
    }
    private static Patient findPatientById(int id ){
        for(Patient patient: patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }
    private static Doctor findDoctorById(int id){
        for (Doctor doctor:doctors){
            if(doctor.getId() == id){
                return doctor;
            }
        }
        return null;
    }
}
