package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import vo.MemberVO;

@Controller
public class FrontController {
	
	@Autowired
	MemberService mbservice;

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView mvIndex() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "home/main.jsp");
		mv.addObject("asidepage", "home/aside.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/member/login")
	public ModelAndView mvLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "/member/login.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/member/loginProc")
	public ModelAndView mvLoginProc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "/member/loginProc.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/logoutProc")
	public ModelAndView mvLogoutProc(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		request.getSession().invalidate();
		mv.addObject("mainpage", "home/main.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/member/view")
	public ModelAndView mvMemberView() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mainpage", "member/viewmember.jsp");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/member/deleteProc")
	public ModelAndView mvMemberDeleteProc() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/deleteProc.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/member/updateProc")
	public ModelAndView mvUpdateProc(String id, String password, String hp, String address) {
		ModelAndView mv = new ModelAndView();
		MemberVO m = new MemberVO(id,password,hp,address);
		
		int result = mbservice.updateById(m);
		mv.addObject("result", result);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/signup/contract")
	public ModelAndView mvContract() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/contract.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/signup")
	public ModelAndView mvSignup() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/signup.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/signup/signupProc")
	public ModelAndView mvSignupProc(String id, String password, String hp, String address) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/loginProc.jsp");
		int result = mbservice.insert(new MemberVO(id,password,hp,address));
		mv.addObject("result",result);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/logout.jsp");
		mv.setViewName("index");
		return mv;
	}

}
