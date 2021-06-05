package aiss.model.calendar;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"user",
	"reminders"
})

public class CalendarResource {

	@JsonProperty("user")
	private String user;
	@JsonProperty("reminders")
	private Object reminders;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("user")
	public String getUser() {
		return user;
	}

	@JsonProperty("user")
	public void setUser(String user) {
		this.user = user;
	}

	@JsonProperty("reminders")
	public Object getReminders() {
		return reminders;
	}

	@JsonProperty("reminders")
	public void setReminders(Object reminders) {
		this.reminders = reminders;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}