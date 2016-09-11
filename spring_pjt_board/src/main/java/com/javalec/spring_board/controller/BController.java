package com.javalec.spring_board.controller;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_board.command.BCommnad;

@Controller
public class BController {

	BCommnad commnad=null;
		
	@RequestMapping("/list")
	public String list(Model model){
		System.out.println("list()");
		commnad = new BListCommand();
		commnad.execute(model);
		
		return "list";
	}
	
	@RequestMapping("write_view()")
	public Stirng write_view(Model model){
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model){
		System.out.println("write()");
		
		model.addAttribute("request", request);
		commnad = new BWriteCommnad();
		commnad.execute(model);
		
		return "redirect:list"; 
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model){
		System.out.println("content_view()");
		
		model.addAttribute("requset", request);
		commnad = new BcontentCommand();
		commnad.execute(model);
		
		return "content_view";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model){
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		commnad = new BModifyCommand();
		commnad.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model){
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		commnad = new BReplyViewcommnad();
		commnad.execute(model);
		
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model){
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		commnad = new BReplyCommand();
		commnad.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		commnad = new BDeleteCommand();
		commnad.execute(model);
		
		return "redirect:list";
	}
}


