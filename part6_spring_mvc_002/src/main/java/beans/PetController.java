package beans;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/pet/")
public class PetController {
	@RequestMapping("editUI")
	public String editUI() {
		System.out.println("ediUI");
		return "pet_edit";
	}
	@RequestMapping("listUI")
	public String listUI() {
		System.out.println("listUI");
		return "pet_list";
	}
	@RequestMapping("doSave")
	public String doSave() {
		System.out.println("==doSave==");
		return "pet_list";
	}
}
