package com.todogrupp5.todogrupp5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

class UserControllerTest {

    @BeforeEach
    void setUp() {
        UserController.users.clear();   
    }

    @Test
    void testAddUser() {
       // Skapa mock-objekt
        Model model = mock(Model.class);
        RedirectAttributes redirectAttributes = mock(RedirectAttributes.class);

        // Skapa en instans av din controller
        UserController controller = new UserController();

        // Anropa metoden med testdata
        String result = controller.addUser("testUser", "testPassword", "testPassword", model, redirectAttributes);

        // Verifiera att metoden returnerar förväntat resultat
        assertEquals("redirect:/createuser", result);

        // Verifiera att inga felmeddelanden har lagts till
        verify(redirectAttributes, never()).addFlashAttribute(eq("error"), anyString());

        // Testa scenario när användarnamnet redan finns
        result = controller.addUser("testUser", "testPassword", "testPassword", model, redirectAttributes);
        assertEquals("redirect:/createuser", result);
        verify(redirectAttributes).addFlashAttribute("error", "Användarnamnet är redan taget. Vänligen välj ett annat.");

        // Testa scenario när lösenorden inte matchar
        result = controller.addUser("newUser", "testPassword", "wrongPassword", model, redirectAttributes);
        assertEquals("redirect:/createuser", result);
        verify(redirectAttributes).addFlashAttribute("error", "Lösenorden matchar inte. Vänligen försök igen.");
    }
    
    @Test
    void testGetUser() {
        Model model = mock(Model.class);
        UserController controller = new UserController();
        String result = controller.getUser(model, "testUser", "testPassword");
        assertEquals("createuser", result);
    }

    @Test
    void testRemoveUser() {
        UserController controller = new UserController();
        User testUser = new User("testUser", "testPassword", false, UserController.users.size() + 1);
        UserController.users.add(testUser);
    
        // Skriv ut användarna före borttagning
        System.out.println("Före borttagning: " + UserController.users);
    
        String result = controller.removeUser(testUser.getId());
        assertEquals("redirect:/createuser", result);
    
        // Skriv ut användarna efter borttagning
        System.out.println("Efter borttagning: " + UserController.users);
    
        // Verifiera att användaren har tagits bort
        assertTrue(UserController.users.stream().noneMatch(user -> user.getUsername().equals(testUser.getUsername())));
    }
}