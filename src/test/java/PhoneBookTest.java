import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    @Test
    public void testCreateContact() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Masha", "Petrova", "+79871723414");
        assertFalse(phoneBook.getAllContacts().isEmpty());
        assertEquals(1, phoneBook.getAllContacts().size());
    }

    @Test
    public void testWhenFirstNameIsNull() {
        PhoneBook phoneBook = new PhoneBook();
        Assertions.assertThrows(RuntimeException.class, () -> phoneBook.addContact(null, "Sidorov", "+79251726093"));
    }

    //@Test
    @ParameterizedTest
    @ValueSource(strings = {"+79871723414", "+79251726093", "+79851253890"})
    public void testPhoneNumberFormat(String phoneNumber) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Маша", "Смирнова", phoneNumber);
        assertFalse(phoneBook.getAllContacts().isEmpty());
        assertEquals(1, phoneBook.getAllContacts().size());
    }
}