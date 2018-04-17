package robin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import robin.domain.Post;
import robin.service.PostServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/post/")
public class PostController {

//	按照类型进行查找
	@Autowired
	private PostServiceImpl postService;
	public PostController(){
		System.out.println("petcontroller constuctor");
	}

	@RequestMapping("editUI")
	public ModelAndView editUI(String id) {
		System.out.println("ediUI");
		ModelAndView mv=new ModelAndView("post_edit");
		if(id==null||id.length()==0)
			return mv;
		else{
			Post post=postService.findObjectById(Integer.parseInt(id));
			mv.addObject("post",post);
			System.out.println("editui :");
			System.out.println(post);
		}
		return mv;
	}
	@RequestMapping("listUI")
	public String listUI(HttpServletRequest request) {

		System.out.println("listUI");
		List<Post> list=postService.findObjects();
		request.setAttribute("posts",list);
		return "post_list";
	}
	@RequestMapping("doSave")
	public String doSave(HttpServletRequest req,String id,String name,String keyword,String content) {

		Post pet=new Post();
		System.out.println("id:"+id+"+++");
		pet.setId(Integer.parseInt(id));
		pet.setName(name);
		pet.setKeyword(keyword);
		pet.setContent(content);
		System.out.println("==doSave==");
		System.out.println(pet);
		if(postService.findObjectById(pet.getId())!=null)
			postService.updateObject(pet);
		else
			postService.saveObject(pet);

		return "redirect:/post/listUI.do";
	}
	@RequestMapping("doDelete")
	public String doDelete(HttpServletRequest req,String id) {
		postService.deleteObject(Integer.parseInt(id));
		return "redirect:/post/listUI.do";
	}

}
