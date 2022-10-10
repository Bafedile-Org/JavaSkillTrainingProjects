package za.co.mecer;

import java.sql.SQLException;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.dbconnection.donordao.DonorDAO;
import za.co.mecer.dbconnection.patientdao.PatientDAO;
import za.co.mecer.donor.Donor;
import za.co.mecer.patient.Patient;

/**
 *
 * @author Dimakatso Sebatane
 */
public class BloodDonation {

    public static void main(String[] args) {
        new BloodDonation().run();
    }

    private void run() {
        DatabaseConnection dbConn = DatabaseConnection.getInstance();
        dbConn.close();

    }

    private void addPatientsToTable(DatabaseConnection dbConn) throws SQLException {
        String names[] = {"Thomas", "Lizy", "Jonathan", "Mercy", "Nevabi", "Aurora", "Jim"};
        String bloodGroups[] = {"A", "O", "AB", "A", "B", "O", "B"};
        String diseases[] = {"Cancer", "Influenza", "Swine Flu", "Luekimia", "TB",
            "Sexually Transmitted Disease", "Deafness"};
        PatientDAO p = new PatientDAO(dbConn.getConnection());
        for (int i = 0; i < names.length; i++) {
            p.addPatient(new Patient(names[i], bloodGroups[i], diseases[i]));

        }
    }

    private void addDonorToTable(DatabaseConnection dbConn) throws SQLException {
        String names[] = {"Thomas", "Lizy", "Jonathan", "Mercy", "Nevabi", "Aurora", "Jim"};
        String bloodGroups[] = {"AB", "A", "B", "A", "O", "AB", "AB"};
        String[] medicalReports = {"Dignosed with bipolar", "Diagnosed with Covid-19", "Dignosed with lung cancer two years ago",
            "suffered anxiety and depression", "experiencing difficuly in breathing", "None", "suffered tragic trauma as a kid"};

        DonorDAO d = new DonorDAO(dbConn.getConnection());
        for (int i = 0; i < names.length; i++) {
            d.addDonor(new Donor(names[i], bloodGroups[i], medicalReports[i]));

        }
    }
}
