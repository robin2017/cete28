package beans.controller;

import beans.domain.Pet;
import beans.service.PetService;
import beans.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/pet/")
@Controller
public class PetController {
	@Autowired
	private PetService petService;
	@RequestMapping("listUI")
	public String listUI() {
		return "pet_list";
	}
	@RequestMapping("editUI")
	public String editUI() {
		return "pet_edit";
	}
	/*@RequestMapping("doSaveObject")
	public ModelAndView doSaveObject(Pet pet) {
		petService.saveObject(pet);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("pet_edit");
		mv.addObject("message", "Pet Add OK");
		return mv;
	}*/
	@RequestMapping("doSaveObject")
	public String doSaveObject(Pet pet) {
		petService.saveObject(pet);
		return "redirect:doFindObjects.do";
	}
	/**
	 * 
	 */
	@RequestMapping("/doFindObjects")
	public ModelAndView doFindObjects() {
		List<Pet> list=petService.findObjects();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("pet_list");
		mv.addObject("list",list);
		return mv;
	}
	/**@ReponseBody的作用是借助JSON API将Java对象
	 * 转换为JSON字符串*/
	@RequestMapping("doQueryObjects")
	@ResponseBody
	public JsonResult doQueryObjects(String name){
		System.out.println("name="+name);
	/*	List<Pet> pets=new ArrayList<Pet>();
		Pet p1=new Pet();
		p1.setName("A");
		p1.setNote("AAAAAAAAAA");
		pets.add(p1);
		Pet p2=new Pet();
		p2.setName("B");
		p2.setNote("BBBBBBBBBB");
		pets.add(p2);*/
		List<Pet> pets=petService.findObjects(name);
		return new JsonResult(pets);
	}
	
	/**{
	 * "state":1,
	 * "message":ok,
	 * "data":[{"name":"A",....},{}]
	 * }
	 */
	
}
