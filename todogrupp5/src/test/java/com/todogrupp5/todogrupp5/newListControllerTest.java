package com.todogrupp5.todogrupp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class newListControllerTest {

    @BeforeEach
    void setUp() {
        newListController.lists.clear();
    }

    @Test
    void testNewListModel() {
        Model model = mock(Model.class);
        newListController controller = new newListController();
        String result = controller.newListModel(model);
        assertEquals("newListToAdd", result);
    }

    @Test
    void testNewListToAdd() {
        Model model = mock(Model.class);
        newListController controller = new newListController();
        String result = controller.newListToAdd("testUser", model);
        assertEquals("newListToAdd", result);
    }

    @Test
    void testNewListAdd() {
        newListController controller = new newListController();
        String result = controller.newListAdd("testList");
        assertEquals("redirect:/newListToAdd", result);
        assertTrue(newListController.lists.stream().anyMatch(list -> list.getListName().equals("testList")));
    }

    @Test
    void testRemoveItem() {
        newListController controller = new newListController();
        ToDoList testList = new ToDoList("testList", newListController.lists.size() + 1);
        newListController.lists.add(testList);
        ToDoItem testItem = new ToDoItem("testItem", null, testList.getToDoItems().size() + 1);
        testList.getToDoItems().add(testItem);
        String result = controller.removeItem("testList", testItem.getId());
        assertEquals("redirect:/ToDoList/{listName}", result);
        assertTrue(testList.getToDoItems().stream().noneMatch(item -> item.getToDoItemName().equals(testItem.getToDoItemName())));
    }

    @Test
    void testSeeList() {
        newListController controller = new newListController();
        ToDoList testList = new ToDoList("testList", newListController.lists.size() + 1);
        newListController.lists.add(testList);
        String result = controller.seeList(testList.getId());
        assertEquals("redirect:/newListToAdd", result);
        assertTrue(newListController.lists.stream().noneMatch(list -> list.getListName().equals(testList.getListName())));
    }

    @Test
    void testToDoList() {
        Model model = mock(Model.class);
        newListController controller = new newListController();
        ToDoList testList = new ToDoList("testList", newListController.lists.size() + 1);
        newListController.lists.add(testList);
        String result = controller.toDoList(testList.getListName(), model);
        assertEquals("TodoList", result);
    }

    @Test
    void testNewItem() {
    newListController controller = new newListController();
    ToDoList testList = new ToDoList("testList", newListController.lists.size() + 1);
    newListController.lists.add(testList);
    String result = controller.newItem(testList.getListName(), "testItem");
    assertEquals("redirect:/ToDoList/" + testList.getListName(), result);
    assertTrue(testList.getToDoItems().stream().anyMatch(item -> item.getToDoItemName().equals("testItem")));
    }
}
