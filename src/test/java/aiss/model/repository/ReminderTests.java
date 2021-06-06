package aiss.model.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import aiss.implementada.resources.CalendarResource;
import aiss.implementada.resources.ReminderResource;
import aiss.model.calendar.Reminder;

public class ReminderTests {

	static Reminder reminder, reminder2, reminder3, reminder4;
	static ReminderResource reminderR = new ReminderResource();
	static CalendarResource calendarR = new CalendarResource();
<<<<<<< HEAD

//	@BeforeClass
//	public static void setUp() throws Exception{
//
//		Reminder rm1 = new Reminder();
//		rm1.setTitle("Recordatorio test 1");
//		rm1.setDate("21/04/2021");
//		rm1.setDescription("descripción 1");
//		rm1.setId("9");
//		rm1.setType("calendario");
//		reminder = reminderR.addReminder(rm1);
//
//	}
	
	@Test
	public void createReminderTest() throws UnsupportedEncodingException {
		String reminderId = "15"; //Cambiar ID y título en la defensa para no crear un Reminder igual
		String reminderTitle = "Defensa de AISS proyecto integración";
		
		List<Reminder> reminders = reminderR.getReminders();
		Reminder reminder0 = reminders.get(0);
		reminder0.setId(reminderId);
		reminder0.setTitle(reminderTitle);
		reminderR.addReminder(reminder0);
		
		assertNotNull("Error when adding the playlist", reminder0);
		assertEquals("The reminder's id has not been set correctly", reminderId, reminder0.getId());
		assertEquals("The reminder's title has not been set correctly", reminderTitle, reminder0.getTitle());
		
		System.out.println(reminder0.getId());
		System.out.println(reminder0.getTitle());
	}


//	@Test
//	public void getRemindersTest() throws UnsupportedEncodingException {
//		//		ReminderResource reminderR = new ReminderResource();
=======
	
	@BeforeClass
	public static void setUp() throws Exception{
		
		Reminder rm1 = new Reminder();
		rm1.setTitle("Recordatorio test 1");
		rm1.setDate("21/04/2021");
		rm1.setDescription("descripción 1");
		rm1.setId("9");
		rm1.setType("calendario");
		reminder = reminderR.addReminder(rm1);
		
	}
	
	
//	@Test
//	public void getRemindersTest() throws UnsupportedEncodingException {
////		ReminderResource reminderR = new ReminderResource();
>>>>>>> 5f00567af1b0eca5020648650941d2d34b30a38e
//		List<Reminder> reminders = reminderR.getReminders();
//
//		assertNotNull("The search returned null", reminders);
//		assertFalse("The number of reminders is zero", reminders.size()==0);
//
//		System.out.println("The search for reminders returned " + reminders.size() + " reminders.");
//
//		for(Reminder reminder : reminders) {
//			System.out.println("Reminder title: " + reminder.getTitle());
//		}
//
//	}
<<<<<<< HEAD

=======
	
>>>>>>> 5f00567af1b0eca5020648650941d2d34b30a38e
//	@Test
//	public void getReminderTest() throws UnsupportedEncodingException {
//		ReminderResource reminderR = new ReminderResource();
//		Reminder reminder = reminderR.getReminder("8");
//
//		assertNotNull("The search returned null", reminder);
//		//assertFalse("The number of reminders is zero", reminders.size()==0);
//
//		//System.out.println("The search for reminders returned " + reminders.size() + " reminders.");
//
//		//for(Reminder reminder : reminders) {
//		System.out.println("Reminder title: " + reminder.getTitle());
//		//}
<<<<<<< HEAD

	}


	//	@Test
	//    public void testAddPlaylist() {
	//        String playlistName = "Add playlist test title";
	//        String playlistDescription = "Add playlist test description";
	//
	//        playlist4 = plr.addPlaylist(new Playlist(playlistName,playlistDescription));
	//        reminder4 = reminderR.addReminder(new Reminder());
	//
	//        assertNotNull("Error when adding the playlist", playlist4);
	//        assertEquals("The playlist's name has not been setted correctly", playlistName, playlist4.getName());
	//        assertEquals("The playlist's description has not been setted correctly", playlistDescription, playlist4.getDescription());
	//    }

//	@Test
//	public void testUpdateReminder() {
//		String reminderTitle = "Updated reminder title";
//
//		// Update reminder
//		reminder.setTitle(reminderTitle);
//
//		boolean success = reminderR.updateReminder(reminder);
//
//		assertTrue("Error when updating the reminder", success);
//
//		Reminder r  = reminderR.getReminder(reminder.getId());
//		assertEquals("The reminder's title has not been updated correctly", reminderTitle, r.getTitle());
//
//	}
	//
	//    @Test
	//    public void testDeletePlaylist() {
	//        boolean success = plr.deletePlaylist(playlist2.getId());
	//        assertTrue("Error when deleting the playlist", success);
	//
	//        Playlist pl = plr.getPlaylist(playlist2.getId());
	//        assertNull("The playlist has not been deleted correctly", pl);
	//    }

=======
//
//	}
	
	
//	@Test
//    public void testAddPlaylist() {
//        String playlistName = "Add playlist test title";
//        String playlistDescription = "Add playlist test description";
//
//        playlist4 = plr.addPlaylist(new Playlist(playlistName,playlistDescription));
//        reminder4 = reminderR.addReminder(new Reminder());
//
//        assertNotNull("Error when adding the playlist", playlist4);
//        assertEquals("The playlist's name has not been setted correctly", playlistName, playlist4.getName());
//        assertEquals("The playlist's description has not been setted correctly", playlistDescription, playlist4.getDescription());
//    }

    @Test
    public void testUpdateReminder() {
        String reminderTitle = "Updated reminder title";

        // Update reminder
        reminder.setTitle(reminderTitle);

        boolean success = reminderR.updateReminder(reminder);

        assertTrue("Error when updating the reminder", success);

        Reminder r  = reminderR.getReminder(reminder.getId());
        assertEquals("The reminder's title has not been updated correctly", reminderTitle, r.getTitle());

    }
//
//    @Test
//    public void testDeletePlaylist() {
//        boolean success = plr.deletePlaylist(playlist2.getId());
//        assertTrue("Error when deleting the playlist", success);
//
//        Playlist pl = plr.getPlaylist(playlist2.getId());
//        assertNull("The playlist has not been deleted correctly", pl);
//    }
>>>>>>> 5f00567af1b0eca5020648650941d2d34b30a38e




