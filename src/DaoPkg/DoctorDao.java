package DaoPkg;

import ModelPkg.Doctor;

import java.util.ArrayList;

public interface DoctorDao {
   /**
    * Vérifie qu'un docteur existe déjà, permet de ne pas le mettre en double dans la bdd
    * @param doctor
    * @return true si docteur existe, false sinon
    */
   public Boolean checkIfDoctorExists(Doctor doctor);

   /**
    * Permet d'avoir les informations d'un docteur à partir de son ID
    * @param doctor_id
    * @return doctor avec id = doctor_id
    */
   public Doctor getDoctorWithId(int doctor_id);

   /**
    * Permet d'avoir les informations d'un docteur à partir de son nom complet
    * @param full_name
    * @return doctor avec prénom = first_name et nom = last_name
    */
   public Doctor getDoctorWithFullName(String full_name);

   /**
    * Permet d'avoir la liste des docteurs
    * @param
    * @return liste de docteurs
    */
   public ArrayList<Doctor> getDoctorList();


   /**
    * Ajoute un docteur à la bdd
    * @param doctor
    */
   public void addDoctor(Doctor doctor);
   public void updateAverageRating(int doctor_id);
}