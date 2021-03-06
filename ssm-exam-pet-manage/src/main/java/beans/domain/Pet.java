package beans.domain;

import java.io.Serializable;

public class Pet implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Pet{" +
				"id=" + id +
				", name='" + name + '\'' +
				", note='" + note + '\'' +
				'}';
	}
}
