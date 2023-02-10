package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "myevents")
public class MyEvents {

	private UserApp user;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idusers")
	public UserApp getUser() {
		return user;
	}

	public void setUser(UserApp user) {
		this.user = user;
	}

	public Integer idmyevents;
//	public Integer idusers;
	public String slug;
	public String title;
	public String description;
	public String longdescription;
	public String keywords;
	public String image;
	public String preview;
	public String sourceimage;
	public String times;
	public Date firstdate_begin;
	public Date firstdate_end;
	public Date lastdate_begin;
	public Date lastdate_end;
	public String detailed_times;
	public String location_name;
	public String location_coordinates;
	public String datecreation;
	public String accessibility;
	public String address;
	public String city;
	public String zipcode;
	public String department;
	public String phone_number;
	public String email;
	public String conditions;
	private String adress_perso;


	
	public MyEvents() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmyevents", unique = true, nullable = false)
	public Integer getIdmyevents() {
		return idmyevents;
	}

	public void setIdmyevents(Integer idmyevents) {
		this.idmyevents = idmyevents;
	}

	
//	@OneToMany(fetch = FetchType.EAGER)
//	@Column(nullable = false, name = "idusers")
//	public Integer getIduser() {
//		return idusers;
//	}
//
//	public void setIduser(Integer idusers) {
//		this.idusers = idusers;
//	}


	@Column(name = "slug", length = 200)
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "title", length = 200)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "longdescription", length = 1000)
	public String getLongdescription() {
		return longdescription;
	}

	public void setLongdescription(String longdescription) {
		this.longdescription = longdescription;
	}

	@Column(name = "keywords", length = 200)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "image", length = 150)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "preview", length = 150)
	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	@Column(name = "sourceimage", length = 150)
	public String getSource_image() {
		return sourceimage;
	}

	public void setSource_image(String source_image) {
		this.sourceimage = source_image;
	}

	@Column(name = "times", length = 45)
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "firstdate_begin")
	public Date getFirstdate_begin() {
		return firstdate_begin;
	}

	public void setFirstdate_begin(Date firstdate_begin) {
		this.firstdate_begin = firstdate_begin;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "firstdate_end")
	public Date getFirstdate_end() {
		return firstdate_end;
	}

	public void setFirstdate_end(Date firstdate_end) {
		this.firstdate_end = firstdate_end;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "lastdate_begin")
	public Date getLastdate_begin() {
		return lastdate_begin;
	}

	public void setLastdate_begin(Date lastdate_begin) {
		this.lastdate_begin = lastdate_begin;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "lastdate_end")
	public Date getLastdate_end() {
		return lastdate_end;
	}

	public void setLastdate_end(Date lastdate_end) {
		this.lastdate_end = lastdate_end;
	}

	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "detailed_times", length = 500)
	public String getDetailed_times() {
		return detailed_times;
	}

	public void setDetailed_times(String detailed_times) {
		this.detailed_times = detailed_times;
	}

	@Column(name = "location_name", length = 100)
	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	@Column(name = "location_coordinates", length = 100)
	public String getLocation_coordinates() {
		return location_coordinates;
	}

	public void setLocation_coordinates(String location_coordinates) {
		this.location_coordinates = location_coordinates;
	}

	@Column(name = "accessibility", length = 45)
	public String getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}

	@Column(name = "address", length = 500)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", length = 500)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zipcode")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "department", length = 150)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "phone_number", length = 45)
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "conditions", length = 100)
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	@Column(name = "adress_perso", length = 100)
	public String getAdress_perso() {
		return adress_perso;
	}

	public void setAdress_perso(String adress_perso) {
		this.adress_perso = adress_perso;
	}

	@Override
	public String toString() {
		return "MyEvents [idmyevents=" + idmyevents + ", slug=" + slug + ", title=" + title
				+ ", description=" + description + ", longdescription=" + longdescription + ", keywords=" + keywords
				+ ", image=" + image + ", preview=" + preview + ", sourceimage=" + sourceimage + ", times=" + times
				+ ", firstdate_begin=" + firstdate_begin + ", firstdate_end=" + firstdate_end + ", lastdate_begin="
				+ lastdate_begin + ", lastdate_end=" + lastdate_end + ", detailed_times=" + detailed_times
				+ ", location_name=" + location_name + ", location_coordinates=" + location_coordinates
				+ ", datecreation=" + datecreation + ", accessibility=" + accessibility + ", address=" + address
				+ ", city=" + city + ", zipcode=" + zipcode + ", department=" + department + ", phone_number="
				+ phone_number + ", email=" + email + ", conditions=" + conditions + ", adress_perso=" + adress_perso
				+ "]";
	}

}
