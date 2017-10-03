package com.nirav.mvc.todo.controller;

import com.nirav.mvc.todo.model.ToDoEntity;
import com.nirav.mvc.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }

    @RequestMapping(value = "/welcome")
    public String welcome(ModelMap modelMap)
    {
        modelMap.addAttribute("name", "abc");
        return "welcome";
    }

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
            return "addUpdateTodo";
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
        return "addUpdateTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String displayUpdateTodoPage(ModelMap modelMap, @RequestParam("id") int id) {
        modelMap.addAttribute("toDoEntity", toDoService.retrieveTodo(id));
        return "addUpdateTodo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @ModelAttribute("toDoEntity") @Valid ToDoEntity toDoEntity, BindingResult result, @RequestParam("id") int id) {
        modelMap.clear();

        if (result.hasErrors()) {
            System.out.println("Error occured" + Arrays.asList(result.getAllErrors()).toString());
            modelMap.addAttribute("toDoEntity", toDoService.retrieveTodo(id));
            return "addUpdateTodo";
        }

        toDoService.updateToDo(toDoEntity);

        return "redirect:todo";
    }

}
