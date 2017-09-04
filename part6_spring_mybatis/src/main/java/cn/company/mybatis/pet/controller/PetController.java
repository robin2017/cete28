package cn.company.mybatis.pet.controller;

import cn.company.mybatis.pet.domain.Pet;
import cn.company.mybatis.pet.service.impl.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/pet/")
public class PetController {

//	按照类型进行查找
	@Autowired
	private PetServiceImpl petService;
	public PetController(){
		System.out.println("petcontroller constuctor");
	}

	@RequestMapping("editUI")
	public ModelAndView editUI(String id) {
		System.out.println("ediUI");
		ModelAndView mv=new ModelAndView("pet_edit");
		if(id==null||id.length()==0)
			return mv;
		else{
			Pet pet=petService.findObjectById(Integer.parseInt(id));
			mv.addObject("pet",pet);
			System.out.println("editui :");
			System.out.println(pet);
		}
		return mv;
	}
	@RequestMapping("listUI")
	public String listUI(HttpServletRequest request) {

		System.out.println("listUI");
		List<Pet> list=petService.findObjects();
		request.setAttribute("pets",list);
		return "pet_list";
	}
	@RequestMapping("doSave")
	public String doSave(HttpServletRequest req,String id,String code,String name,String note) {

		Pet pet=new Pet();
		System.out.println("id:"+id+"+++");
		pet.setId(Integer.parseInt(id));
		pet.setCode(code);
		pet.setName(name);
		pet.setNote(note);
		System.out.println("==doSave==");
		System.out.println(pet);
		if(petService.findObjectById(pet.getId())!=null)
			petService.updateObject(pet);
		else
			petService.saveObject(pet);

		return "redirect:/pet/listUI.do";
	}
	@RequestMapping("doDelete")
	public String doDelete(HttpServletRequest req,String id) {
		petService.deleteObject(Integer.parseInt(id));
		return "redirect:/pet/listUI.do";
	}

}
