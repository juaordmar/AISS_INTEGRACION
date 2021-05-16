package aiss.model.repository;

import java.util.Collection;

import aiss.model.Client;
import aiss.model.Product;

public interface ClientRepository {
	
	
	// Songs
	public void addSong(Product s);
	public Collection<Product> getAllSongs();
	public Product getSong(String songId);
	public void updateSong(Product s);
	public void deleteSong(String songId);
	
	// Playlists
	public void addPlaylist(Client p);
	public Collection<Client> getAllPlaylists();
	public Client getPlaylist(String playlistId);
	public void updatePlaylist(Client p);
	public void deletePlaylist(String playlistId);
	public Collection<Product> getAll(String playlistId);
	public void addSong(String playlistId, String songId);
	public void removeSong(String playlistId, String songId); 

	
	
	
	

}
