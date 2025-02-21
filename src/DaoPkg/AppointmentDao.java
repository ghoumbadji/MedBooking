package DaoPkg;

import ModelPkg.Appointment;

import java.util.ArrayList;

public interface AppointmentDao {
    /**
     * Vérifie si le rendez-vous exise déjà
     * @param appointment
     * @return true si appointment existe, false sinon
     */
    public Boolean checkIfAppointmentExists(Appointment appointment);

    /**
     * Permet d'obtenir tous les rendez-vous d'un client
     * @param client_id
     * @return appointments
     */
    public ArrayList<Appointment> getAppointmentsByClient(int client_id);

    /**
     * Filtre les rendez-vous par critère
     * @param criterion
     * @param criterionValue
     * @param beginDate
     * @param endDate
     * @return appointments
     */
    public ArrayList<Appointment> findByCriterion(String criterion, String criterionValue,
                                                  String beginDate, String endDate);


    public ArrayList<Appointment> getAppointmentList();

    /**
     * Ajoute un rendez-vous
     * @param appointment
     */
    public void addAppointment(Appointment appointment);

    /**
     * Mets à jour un rendez-vous
     * @param appointment_id
     * @param appointment
     */
    public void updateAppointment(int appointment_id, Appointment appointment);

    /**
     * Suprrime un rendez-vous
     * @param appointment_id
     */
    public void deleteAppointment(int appointment_id);
}