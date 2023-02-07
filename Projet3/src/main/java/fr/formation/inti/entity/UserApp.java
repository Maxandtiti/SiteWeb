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
@Table(name = "users")
public class UserApp implements java.io.Serializable {

	
	
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
	private String zipcode;
	private String role;
	private String encrytedPassword;
	private boolean enabled;
	
	
	public UserApp() {
	}
	

	
	public UserApp(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
	
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusers", unique = true, nullable = false)
	public Integer getidUser() {
		return this.idusers;
	}

	public void setidUser(Integer idusers) {
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

	@Column(name = "firstName", length = 45)
	public String getfirstName() {
		return this.firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	@Column(name = "lastName", length = 45)
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
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
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
		return "isers [idusers=" + idusers + ", nickname=" + nickname + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}




	
}
