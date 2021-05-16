package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Client;
import aiss.model.Product;


public class MapClientRepository implements ClientRepository{

	Map<String, Client> playlistMap;
	Map<String, Product> songMap;
	private static MapClientRepository instance=null;
	private int index=0;			// Index to create playlists and songs' identifiers.
	
	
	public static MapClientRepository getInstance() {
		
		if (instance==null) {
			instance = new MapClientRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		playlistMap = new HashMap<String,Client>();
		songMap = new HashMap<String,Product>();
		
		// Create songs
		Product rollingInTheDeep=new Product();
		rollingInTheDeep.setTitle("Rolling in the Deep");
		rollingInTheDeep.setArtist("Adele");
		rollingInTheDeep.setYear("2011");
		rollingInTheDeep.setAlbum("21");
		addSong(rollingInTheDeep);
		
		Product one=new Product();
		one.setTitle("One");
		one.setArtist("U2");
		one.setYear("1992");
		one.setAlbum("Achtung Baby");
		addSong(one);
		
		Product losingMyReligion=new Product();
		losingMyReligion.setTitle("Losing my Religion");
		losingMyReligion.setArtist("REM");
		losingMyReligion.setYear("1991");
		losingMyReligion.setAlbum("Out of Time");
		addSong(losingMyReligion);
		
		Product smellLikeTeenSpirit=new Product();
		smellLikeTeenSpirit.setTitle("Smell Like Teen Spirit");
		smellLikeTeenSpirit.setArtist("Nirvana");
		smellLikeTeenSpirit.setAlbum("Nevermind");
		smellLikeTeenSpirit.setYear("1991");
		addSong(smellLikeTeenSpirit);
		
		Product gotye=new Product();
		gotye.setTitle("Someone that I used to know");
		gotye.setArtist("Gotye");
		gotye.setYear("2011");
		gotye.setAlbum("Making Mirrors");
		addSong(gotye);
		
		// Create playlists
		Client japlaylist=new Client();
		japlaylist.setName("AISSPlayList");
		japlaylist.setDescription("AISS PlayList");
		addPlaylist(japlaylist);
		
		Client playlist = new Client();
		playlist.setName("Favourites");
		playlist.setDescription("A sample playlist");
		addPlaylist(playlist);
		
		// Add songs to playlists
		addSong(japlaylist.getId(), rollingInTheDeep.getId());
		addSong(japlaylist.getId(), one.getId());
		addSong(japlaylist.getId(), smellLikeTeenSpirit.getId());
		addSong(japlaylist.getId(), losingMyReligion.getId());
		
		addSong(playlist.getId(), losingMyReligion.getId());
		addSong(playlist.getId(), gotye.getId());
	}
	
	// Playlist related operations
	@Override
	public void addPlaylist(Client p) {
		String id = "p" + index++;	
		p.setId(id);
		playlistMap.put(id,p);
	}
	
	@Override
	public Collection<Client> getAllPlaylists() {
			return playlistMap.values();
	}

	@Override
	public Client getPlaylist(String id) {
		return playlistMap.get(id);
	}
	
	@Override
	public void updatePlaylist(Client p) {
		playlistMap.put(p.getId(),p);
	}

	@Override
	public void deletePlaylist(String id) {	
		playlistMap.remove(id);
	}
	

	@Override
	public void addSong(String playlistId, String songId) {
		Client playlist = getPlaylist(playlistId);
		playlist.addSong(songMap.get(songId));
	}

	@Override
	public Collection<Product> getAll(String playlistId) {
		return getPlaylist(playlistId).getSongs();
	}

	@Override
	public void removeSong(String playlistId, String songId) {
		getPlaylist(playlistId).deleteSong(songId);
	}

	
	// Song related operations
	
	@Override
	public void addSong(Product s) {
		String id = "s" + index++;
		s.setId(id);
		songMap.put(id, s);
	}
	
	@Override
	public Collection<Product> getAllSongs() {
			return songMap.values();
	}

	@Override
	public Product getSong(String songId) {
		return songMap.get(songId);
	}

	@Override
	public void updateSong(Product s) {
		Product song = songMap.get(s.getId());
		song.setTitle(s.getTitle());
		song.setAlbum(s.getAlbum());
		song.setArtist(s.getArtist());
		song.setYear(s.getYear());
	}

	@Override
	public void deleteSong(String songId) {
		songMap.remove(songId);
	}
	
}
