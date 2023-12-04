public class AddUserTest {
    @Test
	public void addUserTest () {
		UserList toDoList = new UserList("UserList");
		User user = new User("user", "pass", false);

		toDoList.addUser(user);

		assertEquals(1,toDoList.getUsers().size());
		assertEquals("user", toDoList.getUsers().get(0).getUsername());
	}
}
