package beans.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.domain.Pet;
import beans.service.PetService;
import beans.web.JsonResult;

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
/*	@RequestMapping("/doFindObjects")
	public ModelAndView doFindObjects(String name) {
		List<Pet> list=petService.findObjects(name);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("pet_list");
		mv.addObject("list",list);
		return mv;
	}*/
	/**@ReponseBody的作用是借助JSON API将Java对象
	 * 转换为JSON字符串*/
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(String name,Integer pageCurrent){
		Map<String,Object> map=petService.findObjects(name,pageCurrent);
		return new JsonResult(map);
	}
	/**{
	 * "state":1,
	 * "message":ok,
	 * "data":[{"name":"A",....},{}]
	 * }
	 */
	@RequestMapping("doDeleteObjects")
	@ResponseBody
    public JsonResult doDeleteObjects(String checkedIds) {
    	petService.deleteObject(checkedIds);
		return new JsonResult();//state==1,message=ok
    }
	
}
