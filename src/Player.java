
public class Player {
	private String name;
	private Role role;
	public Boolean disk;
	public Player(String name,Role role,Boolean disk) {
		this.name=name;
		this.role=role;
		this.disk=disk;
	}
	

	
	public Role getRole() {
		return this.role;
	}
	
	public String toString() {
		return String.format("name=%s, role=%s", name,role);
	}
}
