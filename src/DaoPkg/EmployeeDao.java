package DaoPkg;

public interface EmployeeDao
{
    /**
     * Vérifie que le compte existe, permet de se connecter
     * @param mail_address
     * @param password
     * @return true si info correctes, false sinon
     */
    public boolean checkAccount(String mail_address, String password);
}
