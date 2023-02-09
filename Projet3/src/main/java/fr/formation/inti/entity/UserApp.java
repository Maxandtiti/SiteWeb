package fr.formation.inti.entity;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "user")
public class UserApp implements java.io.Serializable {

	
<<<<<<< HEAD

	private Integer idusers;
	private String nickname;
	@NotNull
    @NotEmpty
	private String email;
	@NotNull
    @NotEmpty
	private String password;
	private String firstName;
	private String lastName;
	private String adress;
	private String city;
	private Integer zipcode;
	private String role;
	private String encrytedPassword;
	private boolean enabled;

=======
	
	public Integer idusers;
	public String nickname;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String adress;
	public String city;
	public Integer zipcode;
	public String role;
	
>>>>>>> refs/remotes/origin/Maxime
	
	public UserApp() {
	}

<<<<<<< HEAD
=======
	

>>>>>>> refs/remotes/origin/Maxime
	public UserApp(Integer idusers, String nickname, String email, String firstName, String lastName,
			String adress, String city, Integer zipcode) {
		this.idusers = idusers;
		this.nickname = nickname;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getEncrytedPassword() {
        return encrytedPassword;
    }

<<<<<<< HEAD

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
	
    public boolean isEnabled() {
        return enabled;
    }
=======
	public UserApp(Integer idusers, String nickname, String email, String password, String firstName, String lastName,
			String adress, String city, Integer zipcode, String role) {
		this.idusers = idusers;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.city = city;
		this.zipcode = zipcode;
		this.role = role;
	}
>>>>>>> refs/remotes/origin/Maxime

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idusers", unique = true, nullable = false)
	public Integer getidusers() {
		return this.idusers;
	}

	public void setidusers(Integer idusers) {
		this.idusers = idusers;
	}
	
	@Column(name = "nickname", length = 45, nullable = false)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "email", length = 45, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 100, nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "firstname", length = 45, nullable = false)
	public String getfirstName() {
		return this.firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	@Column(name = "lastname", length = 45, nullable = false)
	public String getlastName() {
		return this.lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "adress", length = 200)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	@Column(name = "zipcode")
	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	
	@Column(name = "role", length = 20)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [idusers=" + idusers + ", nickname=" + nickname + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}




	
}
