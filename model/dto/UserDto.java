package model.dto;

public class UserDto {
	private long id;
  private String name;

	public UserDto(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + "]";
	}

	
}
