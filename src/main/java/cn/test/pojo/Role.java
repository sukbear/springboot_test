package cn.test.pojo;

public class Role {
	private Integer id;
	private String name;
	private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Role() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role(Integer id, String name, String level) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
	}
}
