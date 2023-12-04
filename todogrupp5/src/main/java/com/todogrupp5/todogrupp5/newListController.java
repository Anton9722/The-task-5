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
    private static final List<ToDoList> lists = new ArrayList<>();

   

    @GetMapping("/newListToAdd")
    public String newListModel(Model model){
        model.addAttribute("todoLists", lists);
        model.addAttribute("newListObject", new ToDoList(null,0));
        return ("newListToAdd");}

     @PostMapping("/theNewList")
     String newListAdd(@RequestParam("listName") String listName){
        lists.add(new ToDoList(listName,lists.size()+1));
        return "redirect:/newListToAdd";

     }

      @GetMapping("/remove-list/{listID}")
     String seeList(@PathVariable("listID") int listID){
         lists.removeIf (list -> list.getId() == listID);
         return "redirect:/newListToAdd";
     }
     ToDoList todolist = new ToDoList(null, 0);
     //ToDoItem todoitem = new ToDoItem(null, null, 0);
     @GetMapping("/ToDoList")
     String toDoList(Model model){
         model.addAttribute("todoItems", todolist.getToDoItems());
         model.addAttribute("newTodo", new ToDoItem(null, null, 0));
         return"TodoList";
     }
     @PostMapping("/new-item")
     String newItem(@RequestParam("toDoItemName")String toDoItemName){
         todolist.getToDoItems().add(new ToDoItem(toDoItemName,null, todolist.getToDoItems().size()+1));
         return"redirect:/ToDoList";
     }
     @GetMapping("remove-item/{itemID}")
     String removeItem(@PathVariable("itemID") int itemID){
         todolist.getToDoItems().removeIf(item -> item.getId()==itemID);
         return"redirect:/ToDoList";
     }

    }