public class LoginTest {
    @Test 
	public void loginSuccessTest () {
		String username = "user";
		String correctPassword = "correctpass";

		assertTrue(Todogrupp5Application.loginSuccess(username, correctPassword));
	}

	@Test
	public void loginFailTest () {
		String username = "wronguser";
		String password = "wrongpass";

		assertFalse(Todogrupp5Application.loginSuccess(username, password));
	}

    @Test
    public void testlogIn(){
        List<User> users = new ArrayList<>();
        users.add(new User("Sam","123!Sam",false));
        users.add(new User("Sanna","123!Sanna",false));
        users.add(new User("Anton","123!Anton",false));
        users.add(new User("Marcus","123!Marcus",false));
        users.add(new User("Georg","123!Georg",false));
    
        assertEquals("Sam"+"123!Sam",Todogrupp5Application.logIn(users, "Sam", "123!Sam"));
    }
        @Test
        public void testLogOut(){
            boolean isLoggedOut = true;
            User User = new User("","",false);
            assertEquals(isLoggedOut, Todogrupp5Application.logOut(User));
    }
}
