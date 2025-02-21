package ControllerPkg;

import java.io.*;

public class Utils {
    // Some interesting functions

    /**
     * Convertit les dates dans le bon format (DD-MM-YYYY)
     * @param date
     * @param format
     * @return newDate
     */
    public static String dateConverter(String date, String format)
    {
        String newDate = null;

        if (format.equals("YYYY-MM-DD")) {
            newDate = date.substring(8, 10) + "/" + date.substring(5, 7) + "/"
                    + date.substring(0, 4);
        }
        else if (format.equals("DD/MM/YYYY")) {
            newDate = date.substring(6, 10) + "-" + date.substring(3, 5) + "-"
                    + date.substring(0, 2);
        }
        return (newDate);
    }

    /**
     * Vérifie qu'une date est valide
     * @param date
     * @return
     */
    public static boolean dateValidator(String date)
    {
        int day, month, year;

        if (date.length() != 10) {
            return (false);
        }
        else {
            try {
                day = Integer.parseInt(date.substring(0, 2));
                month = Integer.parseInt(date.substring(3, 5));
                year = Integer.parseInt(date.substring(6, 10));
                if (!(day >= 1 && day <= 31) || !(month >= 1 && month <= 12)
                        || !(year >= 1800 && year <= 3000)) {
                    return (false);
                }
            } catch (NumberFormatException numberFormatException) {
                return (false);
            }
        }
        return (true);
    }

    /**
     * Vérifie qu'un mail soit valide
     * @param email
     * @return
     */
    public static boolean emailValidator(String email)
    {
        if (email.length() < 10) {
            return (false);
        }
        else {
            return (email.contains("@") && email.contains("."));
        }
    }

    /**
     * Ecrit dans un fichier
     * @param filename
     * @param text
     */
    public static void writeInFile(String filename, String text)
    {
        String os = System.getProperty("os.name").toLowerCase();
        String userDirectory = System.getProperty("user.dir");
        String absolute_path;
        File file;
        FileOutputStream fos;

        // Set absolute path of the file according to the OS
        if (os.contains("linux")) {
            absolute_path = userDirectory + "/" + filename;
        }
        else {
            absolute_path = userDirectory + "\'" + filename;
        }
        // Check file existence
        file = new File(absolute_path);
        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException ioException) {
                System.err.println("Can't create the file.");
            }
        }
        // Write in the file
        try {
            fos = new FileOutputStream(file);
            for (int i = 0; i < text.length(); i++) {
                fos.write(text.charAt(i));
            }
            fos.close();
        }
        catch (FileNotFoundException exception) {
            System.err.println("Can't open the file in the writing mode.");
        }
        catch (IOException exception) {
            System.err.println("Can't write in the file.");
        }

    }

    /**
     * Lit dans un fichier
     * @param filename
     * @return
     */
    public static String readFromFile(String filename)
    {
        int character;
        String text = null;
        String os = System.getProperty("os.name").toLowerCase();
        String userDirectory = System.getProperty("user.dir");
        String absolute_path;
        FileInputStream fis;

        // Set absolute path of the file according to the OS
        if (os.contains("linux")) {
            absolute_path = userDirectory + "/" + filename;
        }
        else {
            absolute_path = userDirectory + "\'" + filename;
        }
        try {
            fis = new FileInputStream(absolute_path);
        }
        catch (NullPointerException | FileNotFoundException exc ) {
            System.err.println("File doesn't exists.");
            return (text);
        }
        try {
            while (fis.available() != 0) {
                character = fis.read();
                if (text == null)
                    text = String.valueOf((char)character);
                else {
                    text += String.valueOf((char)character);
                }
            }
            fis.close();
        }
        catch (IOException exc)  {
            System.err.println("Invalid content.");
            return (text);
        }
        return (text);
    }
}
