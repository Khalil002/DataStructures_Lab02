package System;

/*
 * @Group #9
 */
public class User {

    private final String userID;
    private final String name;
    private final String surname;
    private final int identificationNumber;
    private final String email;
    private final String password;

    //Constructor
    public User(String name, String surname, int identificationNumber, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.email = email;
        this.password = password;
        this.userID = calculateHash();
    }

    /*
    * Calcula el hash del usuario, se puede utilizar como ID unica ya que 
    * nos aseguramos de que no pueda haber dos usuarios con el mismo correo
     */
    private String calculateHash() {
        return Util.applySha256(
                name
                + surname
                + identificationNumber
                + email
                + password
        );
    }

    public String getID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Nombre=" + name + " Apellido=" + surname;
    }

    public String saveString() {
        return name + "," + surname + "," + identificationNumber + "," + email + "," + password + "\n";
    }
}
