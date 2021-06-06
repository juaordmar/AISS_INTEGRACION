package aiss.implementada.resources;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.calendar.Reminder;

public class ReminderResource {
	
	private static final Logger log = Logger.getLogger(ReminderResource.class.getName());
    private String uri = "https://calendar-api-l2-02.ew.r.appspot.com/api/v1/reminders";

	public Reminder addReminder(Reminder reminder) {
        ClientResource cr = null;
        Reminder resultReminder = null;
        try {
            cr = new ClientResource(uri);
            cr.setEntityBuffering(true);        // Needed for using RESTlet from JUnit tests
            resultReminder = cr.post(reminder,Reminder.class);

        } catch (ResourceException wse) {
            log.log(Level.SEVERE, "Error when adding the reminder: " + cr.getResponse().getStatus());
        }

        return resultReminder;
    }
	
	public boolean updateReminder(Reminder r) {
        ClientResource cr = null;
        boolean success = true;
        try {
            cr = new ClientResource(uri);
            cr.setEntityBuffering(true); // Needed for using RESTlet from JUnit tests
            cr.put(r);

        } catch (ResourceException re) {
            System.err.println("Error when updating the reminder: " + cr.getResponse().getStatus());
            success = false;
            throw re;
        }

        return success;
    }
	
	public Reminder getReminder(String reminderId) {
        ClientResource cr = null;
        Reminder reminder = null;
        try {
            cr = new ClientResource(uri + "/" + reminderId);
            reminder = cr.get(Reminder.class);

        } catch (ResourceException re) {
            System.err.println("Error when retrieving the reminder: " + cr.getResponse().getStatus());
            throw re;
        }

        return reminder;
    }
	
	public List<Reminder> getReminders() {
        ClientResource cr = null;
        Reminder[] reminders = null;
        try {
            cr = new ClientResource(uri);
            reminders = cr.get(Reminder[].class);

        } catch (ResourceException re) {
            System.err.println("Error when retrieving the reminder: " + cr.getResponse().getStatus());
            throw re;
        }

        return Arrays.asList(reminders);
    }
	
	public boolean deleteReminder(Reminder r) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + r.getId());
			cr.setEntityBuffering(true); // Needed for using RESTlet from JUnit tests
			cr.delete();

		} catch (ResourceException re) {
			System.err.println("Error when deleting the reminder: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		return success;
	}

	
}
