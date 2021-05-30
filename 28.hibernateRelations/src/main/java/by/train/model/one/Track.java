package by.train.model.one;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TRACK")
public final class Track {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",	strategy = "uuid",
			parameters = @Parameter(name = "separator", value = "-")
	)
	@Column(name = "TRACK_ID")
	String id;																					
	
	@Column(name = "TITLE")
	String title;
	
	@Temporal(TemporalType.TIME)
	Date playTime;
	
	@Temporal(TemporalType.DATE)
	Date created;
	
	Short volume;

	@Column
	private String artist;

	public  String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Short getVolume() {
		return volume;
	}

	public void setVolume(Short volume) {
		this.volume = volume;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
}
