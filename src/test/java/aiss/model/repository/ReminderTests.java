package aiss.model.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.implementada.resources.ReminderResource;
import aiss.model.calendar.Reminder;

public class ReminderTests {

	@Test
	public void getRemindersTest() throws UnsupportedEncodingException {
		ReminderResource reminderR = new ReminderResource();
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
		Reminder reminder = reminderR.getReminder("8");

		assertNotNull("The search returned null", reminder);
		//assertFalse("The number of reminders is zero", reminders.size()==0);

		//System.out.println("The search for reminders returned " + reminders.size() + " reminders.");

		//for(Reminder reminder : reminders) {
		System.out.println("Reminder title: " + reminder.getTitle());
		//}

	}

}


