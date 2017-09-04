package blog.controller;

/**
 * Created by robin on 2017/8/23.
 */

import blog.domain.Blog;
import blog.service.impl.BlogServiceImpl;
import blog.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/blog/")
public class BlogController {
    private int cnt=10;

    //	按照类型进行查找
    @Autowired
    private BlogServiceImpl blogService;
    public BlogController(){
        System.out.println("petcontroller constuctor");
    }

    @RequestMapping("editUI")
    public String editUI(HttpServletRequest request) {
        System.out.println("ediUI");

        List<Blog> list=blogService.findObjects();
        request.setAttribute("blogs", list);

        return "blog";
    }

    @RequestMapping("doSaveObject")
    public String  insertObject(HttpServletRequest req){
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        Blog blog=new Blog();
        blog.setId(cnt++);
        blog.setTitle(title);
        blog.setContent(content);
        blogService.insertObject(blog);
        return "redirect:/blog/editUI.do";
    }

    @RequestMapping("doDelete")
    public String doDelete(HttpServletRequest req,String id) {
        blogService.deleteObject(Integer.parseInt(id));
        return "redirect:/blog/editUI.do";
    }

    @RequestMapping("doQueryObjectsAjax")
    @ResponseBody
    public JsonResult doQueryObjectsAjax(String name){
        System.out.println("name:"+name);
        List<Blog> list=blogService.findObjectsByName(name);
        System.err.println(list);
        System.out.println("send to client");
        return new JsonResult(list);
    }

}
