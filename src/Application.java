
/**
 * YYC Pet Resort Management System
 * 
 * This Java application simulates a management system for a pet boarding facility,
 * allowing users to performtasks
 * appointments, and more.
 * 
 * Date: July 11, 2024
 * Author: Faris Janjua
 * Version: 1.0
 */



import java.util.*;

public class Application {
    private static List<Pet> pets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to YYC Pet Resort Management System");
            System.out.println("Please select an option:");
            System.out.println("1. Manage Pet Information");
            System.out.println("2. Check Pet Health");
            System.out.println("3. Manage Pet Diet");
            System.out.println("4. Pet Grooming");
            System.out.println("5. Manage Client Payment");
            System.out.println("6. Check Client Pet Status");
            System.out.println("7. Manage Client Appointment");
            System.out.println("8. Manage Bookings and Reservations");
            System.out.println("9. Manage Client Information");
            System.out.println("10. Manage Pet Medication");
            System.out.println("11. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    managePetInformation(scanner);
                    break;
                case 2:
                    checkPetHealth(scanner);
                    break;
                case 3:
                    managePetDiet(scanner);
                    break;
                case 4:
                    petGrooming(scanner);
                    break;
                case 5:
                    manageClientPayment(scanner);
                    break;
                case 6:
                    checkClientPetStatus(scanner);
                    break;
                case 7:
                    manageClientAppointment(scanner);
                    break;
                case 8:
                    manageBookingsAndReservations(scanner);
                    break;
                case 9:
                    manageClientInformation(scanner);
                    break;
                case 10:
                    managePetMedication(scanner);
                    break;
                case 11:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    private static void managePetDiet(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void managePetInformation(Scanner scanner) {
        System.out.println("Manage Pet Information");
        System.out.println("1. View Pet Information");
        System.out.println("2. Add New Pet Information");
        System.out.println("3. Update Pet Information");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Viewing Pet Information...");
                viewPetInformation(scanner);
                break;
            case 2:
                System.out.println("Adding New Pet Information...");
                addNewPetInformation(scanner);
                break;
            case 3:
                System.out.println("Updating Pet Information...");
                updatePetInformation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void viewPetInformation(Scanner scanner) {
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
        } else {
            for (Pet pet : pets) {
                System.out.println("Name: " + pet.getName());
                System.out.println("Breed: " + pet.getBreed());
                System.out.println("Age: " + pet.getAge());
                System.out.println("Medical Conditions: " + pet.getMedicalConditions());
                System.out.println("----------");
            }
        }
    }

    private static void addNewPetInformation(Scanner scanner) {
        Pet pet = new Pet();
        System.out.println("Enter pet name: ");
        pet.setName(scanner.nextLine());
        System.out.println("Enter pet breed: ");
        pet.setBreed(scanner.nextLine());
        System.out.println("Enter pet age: ");
        pet.setAge(scanner.nextInt());
        scanner.nextLine();  // Consume newline
        System.out.println("Enter pet medical conditions (if any): ");
        pet.setMedicalConditions(scanner.nextLine());
        pets.add(pet);
        System.out.println("Pet information added successfully.");
    }

    private static void updatePetInformation(Scanner scanner) {
        System.out.println("Enter pet name to update: ");
        String petName = scanner.nextLine();
        boolean petFound = false;

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(petName)) {
                petFound = true;
                System.out.println("Enter new pet name: ");
                pet.setName(scanner.nextLine());
                System.out.println("Enter new pet breed: ");
                pet.setBreed(scanner.nextLine());
                System.out.println("Enter new pet age: ");
                pet.setAge(scanner.nextInt());
                scanner.nextLine();  // Consume newline
                System.out.println("Enter new pet medical conditions (if any): ");
                pet.setMedicalConditions(scanner.nextLine());
                System.out.println("Pet information updated successfully.");
                break;
            }
        }

        if (!petFound) {
            System.out.println("Pet not found.");
        }
    }

    private static void checkPetHealth(Scanner scanner) {
        System.out.println("Check Pet Health");
        System.out.println("1. Enter Pet Details");
        System.out.println("2. View Health Status");
        System.out.println("3. View Detailed Health Records");
        System.out.println("4. Schedule Health Checkup");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Entering Pet Details...");
                enterPetDetails(scanner);
                break;
            case 2:
                System.out.println("Viewing Health Status...");
                viewHealthStatus(scanner);
                break;
            case 3:
                System.out.println("Viewing Detailed Health Records...");
                viewDetailedHealthRecords(scanner);
                break;
            case 4:
                System.out.println("Scheduling Health Checkup...");
                scheduleHealthCheckup(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void enterPetDetails(Scanner scanner) {
        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();
        boolean petFound = false;

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                petFound = true;
                System.out.println("Enter health record date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.println("Enter health status: ");
                String status = scanner.nextLine();
                System.out.println("Enter detailed health information: ");
                String details = scanner.nextLine();
                HealthRecord record = new HealthRecord(date, status, details);
                pet.addHealthRecord(record);
                System.out.println("Health record added successfully.");
                break;
            }
        }

        if (!petFound) {
            System.out.println("Pet not found.");
        }
    }

    private static void viewHealthStatus(Scanner scanner) {
        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();
        boolean petFound = false;

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                petFound = true;
                List<HealthRecord> records = pet.getHealthRecords();
                if (records.isEmpty()) {
                    System.out.println("No health records found for this pet.");
                } else {
                    HealthRecord latestRecord = records.get(records.size() - 1);
                    System.out.println("Latest Health Status: " + latestRecord.getStatus());
                }
                break;
            }
        }
        

        if (!petFound) {
            System.out.println("Pet not found.");
        }
    }

    private static void viewDetailedHealthRecords(Scanner scanner) {
        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();
        boolean petFound = false;

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                petFound = true;
                List<HealthRecord> records = pet.getHealthRecords();
                if (records.isEmpty()) {
                    System.out.println("No health records found for this pet.");
                } else {
                    for (HealthRecord record : records) {
                        System.out.println("Date: " + record.getDate());
                        System.out.println("Status: " + record.getStatus());
                        System.out.println("Details: " + record.getDetails());
                        System.out.println("----------");
                    }
                }
                break;
            }
        }

        if (!petFound) {
            System.out.println("Pet not found.");
        }
    }

    private static void scheduleHealthCheckup(Scanner scanner) {
        System.out.println("Enter pet name: ");
        String name = scanner.nextLine();
        boolean petFound = false;

        for (Pet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                petFound = true;
                System.out.println("Enter checkup date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                HealthRecord checkupRecord = new HealthRecord(date, "Scheduled Checkup", "Checkup scheduled for " + date);
                pet.addHealthRecord(checkupRecord);
                System.out.println("Health checkup scheduled successfully.");
                break;
            }
        }

        if (!petFound) {
            System.out.println("Pet not found.");
        }
    }



class ManagePetDiet {
        
        private static Map<String, String> petDietPlans = new HashMap<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            managePetDiet(scanner);

            // Close scanner
            scanner.close();
        }

        private static void managePetDiet(Scanner scanner) {
            System.out.println("Manage Pet Diet");
            System.out.println("1. Add New Diet Plan");
            System.out.println("2. Update Diet Plan");
            System.out.println("3. Create Custom Diet Plan");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewDietPlan(scanner);
                    break;
                case 2:
                    updateDietPlan(scanner);
                    break;
                case 3:
                    createCustomDietPlan(scanner);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        private static void addNewDietPlan(Scanner scanner) {
            System.out.println("Enter pet name for diet plan: ");
            String petName = scanner.nextLine();

            System.out.println("Enter diet plan details:");
            String dietPlanDetails = scanner.nextLine();

            petDietPlans.put(petName, dietPlanDetails);

            System.out.println("New diet plan added for " + petName);
        }

        private static void updateDietPlan(Scanner scanner) {
            System.out.println("Enter pet name to update diet plan: ");
            String petName = scanner.nextLine();

            if (petDietPlans.containsKey(petName)) {
                System.out.println("Enter updated diet plan details:");
                String updatedDetails = scanner.nextLine();

                petDietPlans.put(petName, updatedDetails);

                System.out.println("Diet plan updated for " + petName);
            } else {
                System.out.println("No diet plan found for " + petName);
            }
        }

        private static void createCustomDietPlan(Scanner scanner) {
            System.out.println("Enter pet name for custom diet plan: ");
            String petName = scanner.nextLine();

            System.out.println("Enter custom diet plan details:");
            String customDetails = scanner.nextLine();

            petDietPlans.put(petName, customDetails);

            System.out.println("Custom diet plan created for " + petName);
        }
    }


private static void petGrooming(Scanner scanner) {
    System.out.println("Pet Grooming");
    System.out.println("1. Schedule Grooming Appointment");
    System.out.println("2. Update Grooming Appointment");
    System.out.println("3. Cancel Grooming Appointment");

    int choice = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    switch (choice) {
        case 1:
            scheduleGroomingAppointment(scanner);
            break;
        case 2:
            updateGroomingAppointment(scanner);
            break;
        case 3:
            cancelGroomingAppointment(scanner);
            break;
        default:
            System.out.println("Invalid choice.");
    }
}

private static void scheduleGroomingAppointment(Scanner scanner) {
    System.out.println("Enter pet name: ");
    String petName = scanner.nextLine();
   
    System.out.println("Grooming appointment scheduled for " + petName);
}

private static void updateGroomingAppointment(Scanner scanner) {
    System.out.println("Enter pet name: ");
    String petName = scanner.nextLine();
   
    System.out.println("Grooming appointment updated for " + petName);
}

private static void cancelGroomingAppointment(Scanner scanner) {
    System.out.println("Enter pet name: ");
    String petName = scanner.nextLine();

    System.out.println("Grooming appointment canceled for " + petName);
}


private static void manageClientPayment(Scanner scanner) {
    System.out.println("Manage Client Payment");
    System.out.println("1. View Payment History");
    System.out.println("2. Process Payment");
    System.out.println("3. Issue Refund");

    int choice = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    switch (choice) {
        case 1:
            viewPaymentHistory(scanner);
            break;
        case 2:
            processPayment(scanner);
            break;
        case 3:
            issueRefund(scanner);
            break;
        default:
            System.out.println("Invalid choice.");
    }
}

private static void viewPaymentHistory(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();
    boolean clientFound = false;

    // Simulate viewing payment history
    System.out.println("Payment history for client: " + clientName);
    System.out.println("1. Payment on 2023-01-15: $100.00");
    System.out.println("2. Payment on 2023-02-20: $150.00");
    System.out.println("3. Payment on 2023-03-25: $120.00");
}

private static void processPayment(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();
    boolean clientFound = false;

    //
    System.out.println("Enter amount to be paid: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();  

  
    System.out.println("Payment processed successfully.");
}

private static void issueRefund(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();
    boolean clientFound = false;

  
    System.out.println("Enter refund amount: ");
    double amount = scanner.nextDouble();
    scanner.nextLine();  


    System.out.println("Refund issued successfully.");
}

    

private static void checkClientPetStatus(Scanner scanner) {
    System.out.println("Check Client Pet Status");
    System.out.println("1. View Client Pet Status");
    System.out.println("2. Update Client Pet Status");
    System.out.println("3. Send Health Report to Client");

    int choice = scanner.nextInt();
    scanner.nextLine(); 

    switch (choice) {
        case 1:
            viewClientPetStatus(scanner);
            break;
        case 2:
            updateClientPetStatus(scanner);
            break;
        case 3:
            sendHealthReportToClient(scanner);
            break;
        default:
            System.out.println("Invalid choice.");
    }
}

private static void viewClientPetStatus(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();

    System.out.println("Client " + clientName + "'s pets are all healthy.");
}

private static void updateClientPetStatus(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();
    System.out.println("Enter pet name: ");
    String petName = scanner.nextLine();
    System.out.println("Enter new health status: ");
    String healthStatus = scanner.nextLine();

  
    System.out.println("Health status updated to '" + healthStatus + "' for pet " + petName + " belonging to client " + clientName);
}

private static void sendHealthReportToClient(Scanner scanner) {
    System.out.println("Enter client name: ");
    String clientName = scanner.nextLine();

    
    System.out.println("Health report sent to client " + clientName);
}


    private static void manageClientAppointment(Scanner scanner) {
        System.out.println("Manage Client Appointment");
        System.out.println("1. View Appointments");
        System.out.println("2. Schedule Appointment");
        System.out.println("3. Cancel Appointment");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.println("Viewing Appointments...");
  
                break;
            case 2:
                System.out.println("Scheduling Appointment...");
               
                break;
            case 3:
                System.out.println("Cancelling Appointment...");
                
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageBookingsAndReservations(Scanner scanner) {
        System.out.println("Manage Bookings and Reservations");
        System.out.println("1. View Bookings");
        System.out.println("2. Add Booking");
        System.out.println("3. Update Booking");
        System.out.println("4. Cancel Booking");

        int choice = scanner.nextInt();
        scanner.nextLine();  

        switch (choice) {
            case 1:
                System.out.println("Viewing Bookings...");
               
                break;
            case 2:
                System.out.println("Adding Booking...");
     
                break;
            case 3:
                System.out.println("Updating Booking...");
            
                break;
            case 4:
                System.out.println("Cancelling Booking...");
       
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageClientInformation(Scanner scanner) {
        System.out.println("Manage Client Information");
        System.out.println("1. View Client Information");
        System.out.println("2. Update Client Information");
        System.out.println("3. Add New Client");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        switch (choice) {
            case 1:
                System.out.println("Viewing Client Information...");
     
                viewClientInformation();
                break;
            case 2:
                System.out.println("Updating Client Information...");
           
                updateClientInformation(scanner);
                break;
            case 3:
                System.out.println("Adding New Client...");

                addNewClient(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    //  viewing client information
    private static void viewClientInformation() {

        System.out.println("Client information displayed here.");
    }

    //updating client information
    private static void updateClientInformation(Scanner scanner) {
       
        System.out.println("Enter client ID to update:");
        String clientId = scanner.nextLine();
        System.out.println("Client " + clientId + " information updated.");
    }

    //adding a new client
    private static void addNewClient(Scanner scanner) {

        System.out.println("Enter new client name:");
        String clientName = scanner.nextLine();
        System.out.println("Client " + clientName + " added successfully.");
    }

    private static void managePetMedication(Scanner scanner) {
        System.out.println("Manage Pet Medication");
        System.out.println("1. View Medication History");
        System.out.println("2. Add Medication");
        System.out.println("3. Update Medication");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Viewing Medication History...");
                // Code to view medication history
                break;
            case 2:
                System.out.println("Adding Medication...");
                // Code to add medication
                break;
            case 3:
                System.out.println("Updating Medication...");
                // Code to update medication
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

class Pet {
    private String name;
    private String breed;
    private int age;
    private String medicalConditions;
    private List<HealthRecord> healthRecords;

    public Pet() {
        this.healthRecords = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void addHealthRecord(HealthRecord healthRecord) {
        this.healthRecords.add(healthRecord);
    }
}

class HealthRecord {
    private String date;
    private String status;
    private String details;

    public HealthRecord(String date, String status, String details) {
        this.date = date;
        this.status = status;
        this.details = details;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
