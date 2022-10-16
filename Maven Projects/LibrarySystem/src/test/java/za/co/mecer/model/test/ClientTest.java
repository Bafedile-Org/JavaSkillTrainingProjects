package za.co.mecer.model.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.co.mecer.exceptions.ClientException;
import za.co.mecer.model.Client;

/**
 *
 * @author Dimakatso Sebatane
 */
public class ClientTest {

    static Client client1, client2;

    public ClientTest() {

    }

    @BeforeAll
    public static void startUp() {
        try {
            client1 = new Client(1, "Dan", "Brown", "1234567890123", "England, London",
                    "0123456789", "0987654321", "1234567890");
            client2 = new Client();
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertSetClientIdThrows() {
        assertThrows(ClientException.class, () -> client2.setClientId(0));
    }

    @Test
    public void assertSetFirstNameThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setFirstName(""));
    }

    @Test
    public void assertSetLastNameThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setLastName(""));
    }

    @Test
    public void assertSetIdentityNumThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setIdentityNum("1234"));
    }

    @Test
    public void assertSetMobileTelThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setMobileTel("123"));
    }

    @Test
    public void assertSetHomeTelThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setHomeTel("123456789"));
    }

    @Test
    public void assertSetWorkTelThrows() {
        assertThrows(ClientException.class, ()
                -> client2.setWorkTel("123456789"));
    }

    @Test
    public void assertGetIdentityNumNotNull() {
        assertNotNull(client1.getIdentityNum());
    }

    @Test
    public void assertGetFirstnameNotNull() {
        assertNotNull(client1.getFirstName());
    }

    @Test
    public void assertGetLastnameNotNull() {
        assertNotNull(client1.getLastName());
    }

    @Test
    public void assertGetHomeTelNotNull() {
        assertNotNull(client1.getHomeTel());
    }

    @Test
    public void assertCheckIdentityNumLengthTrue() {
        try {
            assertTrue(client2.checkIdentityNumLength("1234567890123"));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertCheckIdentityNumLengthFalse() {
        try {
            assertFalse(client2.checkIdentityNumLength("123456789012"));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertCheckNameLengthTrue() {
        try {
            assertTrue(client2.checkNameLength("John"));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertCheckNameLengthFalse() {
        try {
            assertFalse(client2.checkNameLength(""));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertCheckTelLengthTrue() {
        try {
            assertTrue(client2.checkTelLength("0123456789"));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertCheckTelLengthFalse() {
        try {
            assertFalse(client2.checkTelLength("123456789"));
        } catch (ClientException ex) {
            System.out.println(String.format("Error: %s%n", ex.getMessage()));
        }
    }

    @Test
    public void assertClientIdTrue() {
        assertTrue(client1.getClientId() > 0);
    }
}
