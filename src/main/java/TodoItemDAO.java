import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class TodoItemDAO {

    private final SessionFactory sessionFactory;

    // initialize the Hibernate SessionFactory
    public TodoItemDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // adds a new TodoItem to the database
    public void addTodoItem(TodoItem item) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(item);
        transaction.commit();
        session.close();
    }

    // delete a TodoItem from the database based on its ID
    public void deleteTodoItem(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        TodoItem item = session.get(TodoItem.class, id);
        if (item != null) {
            session.remove(item);
            transaction.commit();
        }
        session.close();
    }

    // retrieve all TodoItems from the database
    public List<TodoItem> getAllTodoItems() {
        Session session = sessionFactory.openSession();
        List<TodoItem> items = session.createQuery("FROM TodoItem", TodoItem.class).list();
        session.close();
        return items;
    }
}
