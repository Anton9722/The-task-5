package com.todogrupp5.todogrupp5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class newListController {

    static final List<ToDoList> lists = new ArrayList<>();

    @GetMapping("/newListToAdd")
    public String newListModel(Model model){
        model.addAttribute("todoLists", lists);
        model.addAttribute("newListObject", new ToDoList(null, 0));
        return "newListToAdd";
    }
    @GetMapping("/newListToAdd/{username}")
    public String newListToAdd(@PathVariable String username, Model model) {
        User user = UserController.users.stream()
        .filter(u -> u.getUsername().equals(username))
        .findFirst()
        .orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("todoLists", lists);
        model.addAttribute("newListObject", new ToDoList(null, 0));
        return "newListToAdd";
    }

    @PostMapping("/theNewList")
    String newListAdd(@RequestParam("listName") String listName){
        lists.add(new ToDoList(listName, lists.size() + 1));
        return "redirect:/newListToAdd";
    }

    @GetMapping("/remove-list/{listID}")
    String seeList(@PathVariable("listID") int listID){
        lists.removeIf (list -> list.getId() == listID);
        return "redirect:/newListToAdd";
    }

    @GetMapping("/ToDoList/{listName}")
    String toDoList(@PathVariable("listName") String listName, Model model){
        ToDoList todoList = findListByName(listName);
        model.addAttribute("listName", todoList.getListName());
        model.addAttribute("todoItems", todoList.getToDoItems());
        model.addAttribute("newTodo", new ToDoItem(null, null, 0)); 
        return "TodoList";
    }

    @PostMapping("/new-item/{listName}")
    String newItem(@PathVariable("listName") String listName,
     @RequestParam("toDoItemName") String toDoItemName) {
        
        ToDoList todoList = findListByName(listName);
        todoList.getToDoItems().add(new ToDoItem(toDoItemName, null, Integer.valueOf(todoList.getToDoItems().size() + 1)));
        return "redirect:/ToDoList/{listName}";
    }
    
    @GetMapping("remove-item/{listName}/{itemID}")
        String removeItem(@PathVariable("listName") String listName, @PathVariable("itemID") int itemID) {
        ToDoList todoList = findListByName(listName);
        todoList.getToDoItems().removeIf(item -> item.getId() == itemID);
        return "redirect:/ToDoList/{listName}";
    }

   /*  private ToDoList findListById(int listID) {
        return lists.stream().filter(list -> list.getId() == listID).findFirst().orElse(null);
    } */

    private ToDoList findListByName(String listName) {
        return lists.stream().filter(list -> list.getListName().equals(listName)).findFirst().orElse(null);
    }
}