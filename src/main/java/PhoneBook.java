import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PhoneBook {
    Map contactList = new ConcurrentHashMap();

    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        contactAlreadyExist(contact);
        contactList.put(createKey(contact), contact);
    }

    public Collection getAllContacts() {
        return contactList.values();
    }

    private void contactAlreadyExist(Contact contact) {
        if (contactList.containsKey(createKey(contact)))
            throw new RuntimeException("Контакт уже существует");
    }

    private void validateContact(Contact contact) {
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }

    private String createKey(Contact contact) {
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
    }
}
