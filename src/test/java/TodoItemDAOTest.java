import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TodoItemDAOTest {

    @Test
    public void testAddTodoItem() {
        TodoItemDAO dao = new TodoItemDAO();
        TodoItem item = new TodoItem("Test task");
        dao.addTodoItem(item);
        assertFalse(dao.getAllTodoItems().isEmpty());
    }

    @Test
    public void testDeleteTodoItem() {
        TodoItemDAO dao = new TodoItemDAO();
        TodoItem item = new TodoItem("Task to delete");
        dao.addTodoItem(item);
        dao.deleteTodoItem(item.getId());
        assertTrue(dao.getAllTodoItems().isEmpty());
    }
}
