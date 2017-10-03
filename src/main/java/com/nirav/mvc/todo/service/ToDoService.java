package com.nirav.mvc.todo.service;

import com.nirav.mvc.todo.model.ToDoEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;

import static java.util.stream.Collectors.toCollection;

@Service
public class ToDoService {

    private static List<ToDoEntity> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new ToDoEntity(1, "nirav", "Learn Spring MVC", new Date(),
                false));
        todos.add(new ToDoEntity(2, "nirav", "Learn Struts", new Date(), false));
        todos.add(new ToDoEntity(3, "nirav", "Learn Hibernate", new Date(),
                false));
    }

    public List<ToDoEntity> retrieveTodos(@NotNull String user) {
        return todos.stream().filter(toDoEntity -> user.equals(toDoEntity.getUser())).collect(toCollection(ArrayList::new));
    }

    public ToDoEntity retrieveTodo(int id) {
        return todos.stream().filter(toDoEntity -> id == toDoEntity.getId()).findFirst().orElse(null);
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todos.add(new ToDoEntity(++todoCount, name, desc, targetDate, isDone));
    }

    public void updateToDo(ToDoEntity todo){
        todos.remove(todo);
        todos.add(todo);
    }

    public void deleteTodo(int id) {
        Iterator<ToDoEntity> iterator = todos.iterator();
        while (iterator.hasNext()) {
            ToDoEntity todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

}
