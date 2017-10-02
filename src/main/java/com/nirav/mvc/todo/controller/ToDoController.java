package com.nirav.mvc.todo.controller;

import com.nirav.mvc.todo.model.ToDoEntity;
import com.nirav.mvc.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String displayToDos(ModelMap modelMap) {
        modelMap.addAttribute("todos", toDoService.retrieveTodos("nirav"));
        return "display-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap modelMap, @ModelAttribute("toDoEntity") @Valid ToDoEntity toDoEntity, BindingResult result) {

        modelMap.clear();

        if (result.hasErrors()) {
            System.out.println("Error occured" + Arrays.asList(result.getAllErrors()).toString());
            modelMap.addAttribute("toDoEntity", new ToDoEntity(0, "nirav", "", new Date(), false));
            return "add-todo";
        }

        toDoService.addTodo("nirav", toDoEntity.getDescription(), new Date(), false);

        return "redirect:todo";
    }


    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteToDo(ModelMap modelMap, @RequestParam("id") int id) {
        toDoService.deleteTodo(id);
        return "redirect:todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String displayAddTodoPage(ModelMap modelMap) {
        modelMap.addAttribute("toDoEntity", new ToDoEntity(0, "nirav", "", new Date(), false));
        return "add-todo";
    }

}
