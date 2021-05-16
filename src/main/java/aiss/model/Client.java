package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String id;
	private String name;
	private String description;
	private List<Product> songs;
	
	public Client() {}
	
	public Client(String name) {
		this.name = name;
	}
	
	protected void setSongs(List<Product> s) {
		songs = s;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Product> getSongs() {
		return songs;
	}
	
	public Product getSong(String id) {
		if (songs==null)
			return null;
		
		Product song =null;
		for(Product s: songs)
			if (s.getId().equals(id))
			{
				song=s;
				break;
			}
		
		return song;
	}
	
	public void addSong(Product s) {
		if (songs==null)
			songs = new ArrayList<Product>();
		songs.add(s);
	}
	
	public void deleteSong(Product s) {
		songs.remove(s);
	}
	
	public void deleteSong(String id) {
		Product s = getSong(id);
		if (s!=null)
			songs.remove(s);
	}

}
