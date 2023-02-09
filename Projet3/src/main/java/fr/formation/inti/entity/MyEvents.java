package fr.formation.inti.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "myevents")
public class MyEvents {

	public Integer idmyevents;
	public Integer iduser;
	public String slug;
	public String title;
	public String description;
	public String longdescription;
	public String keywords;
	public String image;
	public String preview;
	public String source_image;
	public String times;
	@Temporal(TemporalType.DATE)
	public Date firstdate_begin;
	public Date firstdate_end;
	public Date lastdate_begin;
	public Date lastdate_end;
	public String detailed_times;
	public String location_name;
	public String location_coordinates;
	public String accessibility;
	public String adress;
	public String city;
	public String zipcode;
	public String department;
	public String phone_number;
	public String email;
	public String conditions;
	private String adress_perso;

	public Integer getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public MyEvents() {

	}

	public MyEvents(Integer idmyevents, Integer iduser, String slug, String title, String description,
			String longdescription, String keywords, String image, String preview, String source_image, String times,
			Date firstdate_begin, Date firstdate_end, Date lastdate_begin, Date lastdate_end, String detailed_times,
			String location_name, String location_coordinates, String accessibility, String adress, String city,
			String zipcode, String department, String phone_number, String email, String conditions) {
		this.idmyevents = idmyevents;
		this.slug = slug;
		this.title = title;
		this.iduser = iduser;
		this.description = description;
		this.longdescription = longdescription;
		this.keywords = keywords;
		this.image = image;
		this.preview = preview;
		this.source_image = source_image;
		this.times = times;
		this.firstdate_begin = firstdate_begin;
		this.firstdate_end = firstdate_end;
		this.lastdate_begin = lastdate_begin;
		this.lastdate_end = lastdate_end;
		this.detailed_times = detailed_times;
		this.location_name = location_name;
		this.location_coordinates = location_coordinates;
		this.accessibility = accessibility;
		this.adress = adress;
		this.city = city;
		this.zipcode = zipcode;
		this.department = department;
		this.phone_number = phone_number;
		this.email = email;
		this.conditions = conditions;
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

	@Column(name = "Slug", length = 200)
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Column(name = "Title", length = 200)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Description", length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Long_description", length = 1000)
	public String getLongdescription() {
		return longdescription;
	}

	public void setLongdescription(String longdescription) {
		this.longdescription = longdescription;
	}

	@Column(name = "Keywords", length = 200)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "Image", length = 150)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Preview", length = 150)
	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	@Column(name = "Source_image", length = 150)
	public String getSource_image() {
		return source_image;
	}

	public void setSource_image(String source_image) {
		this.source_image = source_image;
	}

	@Column(name = "Times", length = 45)
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

//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "firstdate_end")
	public Date getFirstdate_end() {
		return firstdate_end;
	}

	public void setFirstdate_end(Date firstdate_end) {
		this.firstdate_end = firstdate_end;
	}

//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "lastdate_begin")
	public Date getLastdate_begin() {
		return lastdate_begin;
	}

	public void setLastdate_begin(Date lastdate_begin) {
		this.lastdate_begin = lastdate_begin;
	}

//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "lastdate_end")
	public Date getLastdate_end() {
		return lastdate_end;
	}

	public void setLastdate_end(Date lastdate_end) {
		this.lastdate_end = lastdate_end;
	}

//	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Column(name = "Detailed_times", length = 500)
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

	@Column(name = "Adress", length = 500)
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "City", length = 500)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "Zipcode")
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "Department", length = 150)
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

	@Column(name = "adressPerson", length = 100)
	public String getAdress_perso() {
		return adress_perso;
	}

	public void setAdress_perso(String adress_perso) {
		this.adress_perso = adress_perso;
	}

	@Override
	public String toString() {
		return "MyEvents [idmyevents=" + idmyevents + ", slug=" + slug + ", title=" + title + ", description="
				+ description + ", longdescription=" + longdescription + ", keywords=" + keywords + ", image=" + image
				+ ", preview=" + preview + ", source_image=" + source_image + ", times=" + times + ", firstdate_begin="
				+ firstdate_begin + ", firstdate_end=" + firstdate_end + ", lastdate_begin=" + lastdate_begin
				+ ", lastdate_end=" + lastdate_end + ", detailed_times=" + detailed_times + ", location_name="
				+ location_name + ", location_coordinates=" + location_coordinates + ", accessibility=" + accessibility
				+ ", adress=" + adress + ", city=" + city + ", zipcode=" + zipcode + ", department=" + department
				+ ", phone_number=" + phone_number + ", email=" + email + ", conditions=" + conditions + "]";
	}

}
