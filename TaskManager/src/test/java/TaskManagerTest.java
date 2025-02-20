import org.example.TaskManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import javax.swing.*;

import java.awt.event.ItemEvent;

import static org.junit.jupiter.api.Assertions.*;
public class TaskManagerTest 
{
    private TaskManager taskManager;

    @BeforeEach
    void setUp(){
        taskManager = new TaskManager();
    }

    @Test
    void testTaskWindowCreation()
    {
        JFrame frame = taskManager.Taskwindow();
        assertNotNull(frame);
        assertEquals("TODO LIST",frame.getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE,frame.getDefaultCloseOperation());
    }

    @Test
    void testMenuView()
    {
        JMenuBar menuBar = taskManager.menuView();
        assertNotNull(menuBar);
        assertEquals(3,menuBar.getComponentCount());
    }

    @Test
    void testAddTask()
    {
        taskManager.taskField().setText("Test Task");
        taskManager.DueTaskDate().setText("Test Description");
        taskManager.DueTaskDate().setText("2025-02-20");
        taskManager.editTaskCheckBox().setSelected(true);

    }
    @Test
    void testItemStateChange()
    {
        JToggleButton toggleButton = taskManager.toggleButton;
        ItemEvent selectedEvent = new ItemEvent(toggleButton,ItemEvent.ITEM_STATE_CHANGED,toggleButton,ItemEvent.SELECTED);
    }

}
