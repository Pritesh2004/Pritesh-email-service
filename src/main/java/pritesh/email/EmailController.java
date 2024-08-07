package pritesh.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class EmailController {

	@Autowired
	private EmailSenderService emailService;
	
	
	@PostMapping("/email")
	public ResponseEntity<User> postQueries(@RequestBody User user) throws Exception{
		
		String toMe = "This is a message from your portfolio from " + user.getName() + ",\n"
				+ "The message body is as follows" + ",\n\n"
				+ user.getMessage()
				 +"\n\n"+ "Best regards,"+"\n"+ user.getName() +"\n"+ user.getEmail()+"";
		
		String toUser = "Dear " + user.getName() + ",\n\n"
                + "Thank you for reaching out to me through my portfolio.\n"
                + "I appreciate your message and will get back to you soon.\n\n"
                + "Best regards,\n"
                + "Pritesh Patil\n";

		
		emailService.sendEmail("patilpritesh7277@gmail.com", user.getSubject() , toMe);

		emailService.sendEmail(user.getEmail(), "Thank You for Your Message", toUser);
		
		User newUser = new User(user.getEmail(),user.getSubject(),user.getName(),user.getMessage()); 
		
		 return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
}
