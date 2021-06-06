package aiss.model.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.List;


import org.junit.Test;

import aiss.implementada.resources.ReminderResource;
import aiss.model.calendar.Reminder;

public class ReminderTests {

	static Reminder reminder, reminder2, reminder3, reminder4;
	static ReminderResource reminderR = new ReminderResource();

	//No usar los mismos IDs para todos los tests
	
	@Test
	public void addReminderTest() throws UnsupportedEncodingException {
		String reminderId = "47"; //Cambiar ID para que coincidan en el delete y en el addReminder
		String reminderTitle = "Defensa de AISS proyecto integración final sudo";
		
		List<Reminder> reminders = reminderR.getReminders();
		Reminder reminder0 = reminders.get(0);
		reminder0.setId(reminderId);
		reminder0.setTitle(reminderTitle);
		reminderR.addReminder(reminder0);
		
		assertNotNull("Error when adding the playlist", reminder0);
		assertEquals("The reminder's id has not been set correctly", reminderId, reminder0.getId());
		assertEquals("The reminder's title has not been set correctly", reminderTitle, reminder0.getTitle());
		
		System.out.println("ID of the reminder added: " + reminder0.getId());
		System.out.println("Title of the reminder added: " + reminder0.getTitle());
	}

	
	
	@Test
	public void getRemindersTest() throws UnsupportedEncodingException {
		List<Reminder> reminders = reminderR.getReminders();

		assertNotNull("The search returned null", reminders);
		assertFalse("The number of reminders is zero", reminders.size()==0);

		System.out.println("The search for reminders returned " + reminders.size() + " reminders.");

		for(Reminder reminder : reminders) {
			System.out.println("Reminder title: " + reminder.getTitle());
		}

	}

	@Test
	public void getReminderTest() throws UnsupportedEncodingException {
		ReminderResource reminderR = new ReminderResource();
		String reminderId = "8";
		Reminder reminder = reminderR.getReminder(reminderId);

		assertNotNull("The search returned null", reminder);

		System.out.println("Reminder title with ID '" + reminderId + "' : "+ reminder.getTitle());
	}


	@Test
	public void updateReminderTest() throws UnsupportedEncodingException { //Cambiar ID y título en la defensa para no crear un Reminder igual
		String reminderId = "12"; //Id del recordatorio a actualizar
		String reminderTitle = "Entrega ADDA PI7";

		Reminder reminder0 = reminderR.getReminder(reminderId);
		reminder0.setTitle(reminderTitle);
		
		boolean success = reminderR.updateReminder(reminder0);

		assertTrue("Error when updating the reminder", success);
		
		System.out.println("ID of the reminder updated: " + reminder0.getId());
		System.out.println("New title of the reminder updated: " + reminder0.getTitle());
	}
	
	@Test
    public void deleteReminderTest() {
        String reminderId = "11";
        Reminder r1 = reminderR.getReminder(reminderId);
        boolean success = reminderR.deleteReminder(r1);
        assertTrue("Error when deleting the reminder", success);

        System.out.println("The reminder with ID '" + reminderId + "' has been deleted");
    }
	
}





