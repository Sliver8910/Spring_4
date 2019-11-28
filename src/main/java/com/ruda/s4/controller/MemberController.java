package com.ruda.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s4.model.MemberVO;
import com.ruda.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Inject
	private MemberServiceImpl memberServiceImpl;
	
	@GetMapping(value = "memberJoin")
	public void memberJoin() throws Exception{
		
	}

	@PostMapping(value = "memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO, HttpSession session, HttpServletRequest request)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		 int result = memberServiceImpl.memberJoin(memberVO, session); 
		 String message = "Join Fail"; 
		  if(result>0) { message = "Join Success"; } 
		  mv.addObject("msg",message); 
		  mv.addObject("path", "../");
		  mv.setViewName("common/common_result");
		 
		return mv;		
	}
	
	@PostMapping(value = "memberCheckId")
	public void memberCheckId(MemberVO memberVO, Model model)throws Exception{
		memberVO = memberServiceImpl.memberCheckId(memberVO);
		String result ="unpass";
		
		if(memberVO == null) {
			result ="pass";
		}
		
		model.addAttribute("result", result);
		
	}
	
	@GetMapping(value = "memberLogin")
	public void memberLogin()throws Exception{}
	
	@PostMapping(value = "memberLogin")
	public String memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		memberVO = memberServiceImpl.memberLogin(memberVO);
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			session.setAttribute("dto", memberVO);
		}
		return "redirect:../";
	}
	@GetMapping(value = "memberLogout")
	public String memberLogout(HttpSession session)throws Exception{
		//session.removeAttribute("member");
		session.invalidate();//유지시간을0으로 변경
		return "redirect:../";
	};
	
	@GetMapping(value = "memberMypage")
	public void memberMypage(HttpSession session)throws Exception{
		session.getAttribute("dto");
		
	}
	
	@GetMapping(value = "memberUpdate")
	public String memberUpdate(Model model ,MemberVO memberVO, HttpSession session)throws Exception{
		memberVO = (MemberVO)session.getAttribute("member");
		model.addAttribute("dto", memberVO);
		return "member/memberUpdate";
	}
	
	@PostMapping(value = "memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberUpdate((MemberVO)session.getAttribute("dto"));
		String message = "Update Fail";
		if(result>0) {
			message = "Update Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./memberMypage");
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
	@GetMapping("memberDelete")
	public void memberDelete()throws Exception{
		
		
	}
	
}
