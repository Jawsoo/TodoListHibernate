import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TodoItemDAOTest {

    @Test
    public void testAddTodoItem() {
        TodoItemDAO dao = new TodoItemDAO();
        TodoItem item = new TodoItem("Test task");

        dao.addTodoItem(item);

        List<TodoItem> items = dao.getAllTodoItems();
        assertFalse(items.isEmpty(), "The item should have been added");
    }

    @Test
    public void testDeleteTodoItem() {
        TodoItemDAO dao = new TodoItemDAO();

        // Create and add a new TodoItem
        TodoItem item = new TodoItem("Task to delete");
        dao.addTodoItem(item);

        // Retrieve the ID of the newly added item
        int id = item.getId();

        // Delete the item by its ID
        dao.deleteTodoItem(id);

        // Retrieve all items and check if the item was successfully deleted
        List<TodoItem> items = dao.getAllTodoItems();
        boolean isDeleted = items.stream().noneMatch(i -> i.getId() == id);

        assertTrue(isDeleted, "The item should have been deleted");
    }
}
