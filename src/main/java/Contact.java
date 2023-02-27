public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void validateFirstName() {
        if (this.firstName == null)
            throw new RuntimeException("Имя не может быть нулевым");
    }

    public void validateLastName() {
        if (this.lastName == null)
            throw new RuntimeException("Фамилия не может быть нулевой");
    }

    public void validatePhoneNumber() {
        if (this.phoneNumber.length() != 12) {
            throw new RuntimeException("Номер телефона должен состоять из 12 символов");
        }
        if (!this.phoneNumber.startsWith("+")) {
            throw new RuntimeException("Номер телефона должен начинаться с +");
        }
    }
}