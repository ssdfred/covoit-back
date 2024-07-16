package covoit.entities;

/**
 * Represents an administrator account in the carpooling system.
 */
public class Administrator extends UserAccount {

    private boolean isAdmin;

    /**
     * Checks if the user is an administrator.
     * 
     * @return true if the user is an administrator, false otherwise
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Sets the administrator status of the user.
     * 
     * @param isAdmin true if the user is an administrator, false otherwise
     */
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
