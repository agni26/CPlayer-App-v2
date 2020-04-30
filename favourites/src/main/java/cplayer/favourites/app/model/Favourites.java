package cplayer.favourites.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Favourites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private int pid;               //Getting player id to be stored as private
	private String country;        //Getting player country to be stored as private
	private String name;           //Getting player name to be stored as private
	private String fullName;       //Getting player fullName to be stored as private
	private String majorTeams;     //Getting info about major teams to be stored as private
	private String currentAge;     //Getting player currentAge to be stored as private
	private String imageURL;       //Getting player imageURL to be stored as private
	private String playingRole;    //Getting player role to be stored as private
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	@Override
	public String toString() {
		return "Favourites [id=" + id + ", username=" + username + ", pid=" + pid + ", country=" + country + ", name="
				+ name + ", fullName=" + fullName + ", majorTeams=" + majorTeams + ", currentAge=" + currentAge
				+ ", imageURL=" + imageURL + ", playingRole=" + playingRole + "]";
	}
		
}
