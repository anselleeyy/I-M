package cn.ltysyn.infiniti.mongo.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "album")
public class Music {
	
	@Id
	private ObjectId _id;
	
	private Artist artist;
	
	private List<AlbumList> albums;

	public Music(Artist artist, List<AlbumList> albums) {
		super();
		this.artist = artist;
		this.albums = albums;
	}

	@PersistenceConstructor
	public Music(ObjectId _id, Artist artist, List<AlbumList> albums) {
		super();
		this._id = _id;
		this.artist = artist;
		this.albums = albums;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<AlbumList> getAlbums() {
		return albums;
	}

	public void setAlbums(List<AlbumList> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Music [_id=" + _id + ", artist=" + artist + ", albums=" + albums + "]";
	}

}
