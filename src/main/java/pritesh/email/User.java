package pritesh.email;

public class User {

	
	private String email;
	
	private String subject;
	
	private String name;
	
	private String message;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User(String email, String subject, String name, String message) {
		super();
		this.email = email;
		this.subject = subject;
		this.name = name;
		this.message = message;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
