package cn.company.mybatis.pet.domain;
import java.io.Serializable;
import java.util.Date;
/**М≈д©пео╒*/
public class Pet implements Serializable{
	private static final long serialVersionUID = 2789323017407446520L;
	private Integer id;
	private String code;
	private String name;
	private Date birthday;
	private String note;
	private String createdUser;
	private Date createdTime;
	private String modifiedUser;
	private Date modifiedTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", code=" + code + ", name=" + name + ", birthday=" + birthday + ", note=" + note
				+ ", createdUser=" + createdUser + ", createdTime=" + createdTime + ", modifiedUser=" + modifiedUser
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
}
