package cplayer.recommended.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recommended {
	
	@Id
	private int pid;
	private String country;
	private String name;
	private String fullName;
	private String majorTeams;
	private String currentAge;
	private String imageURL;
	private String playingRole;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getMajorTeams() {
		return majorTeams;
	}
	public void setMajorTeams(String majorTeams) {
		this.majorTeams = majorTeams;
	}
	
	public String getCurrentAge() {
		return currentAge;
	}
	public void setCurrentAge(String currentAge) {
		this.currentAge = currentAge;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public String getPlayingRole() {
		return playingRole;
	}
	public void setPlayingRole(String playingRole) {
		this.playingRole = playingRole;
	}
	
	@Override                //When the name of super's methods changing, the compiler can notify that case
	public String toString() {
		return "Favourites [pid=" + pid + ", country=" + country + ", name=" + name + ", fullName=" + fullName
				+ ", majorTeams=" + majorTeams + ", currentAge=" + currentAge + ", imageURL=" + imageURL
				+ ", playingRole=" + playingRole + "]";
	}
	
}
