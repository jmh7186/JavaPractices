package controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import service.MemberService;
import service.PhonebookService;
import vo.MemberVO;

@Controller
public class FrontController {
	
	@Autowired
	MemberService mbservice;
	
	@Autowired
	PhonebookService pbservice;

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
	public ModelAndView mvLoginProc(String id,String pwd, HttpSession request) {
		ModelAndView mv = new ModelAndView();
		MemberVO m = mbservice.findById(id);
		
		if(m!=null && m.getMid().equals(id) && m.getMpwd().equals(pwd)) {
			mv.addObject("mainpage", "/member/loginProc.jsp");
			mv.addObject("result",1);
			request.setAttribute("id", id);
		}else {
			mv.addObject("mainpage", "/member/loginProc.jsp");
			mv.addObject("result",0);
		}
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/logoutProc")
	public ModelAndView mvLogoutProc(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.addObject("mainpage", "home/main.jsp");
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/member/view")
	public ModelAndView mvMemberView(String id) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("mainpage", "member/viewmember.jsp");
		mv.addObject("member", mbservice.findById(id));
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
	public ModelAndView mvUpdateProc(String mid, String mpwd, String mhp, String madr) {
		ModelAndView mv = new ModelAndView();
		MemberVO m = new MemberVO(mid,mpwd,mhp,madr);
		
		int result = mbservice.updateById(m);
		mv.addObject("mainpage", "member/updateProc.jsp");
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
	public ModelAndView mvSignupProc(String id, String pwd, String hp, String adr) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mainpage", "member/signupProc.jsp");
		int result = mbservice.insert(new MemberVO(id,pwd,hp,adr));
		
		if(result==1) {
			mv.addObject("mainpage", "member/welcome.jsp");
			mv.addObject("id", id);
		}else {
			mv.addObject("mainpage", "member/signupProc.jsp");
			mv.addObject("result", result);
		}
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/map")
	public ModelAndView map(ModelAndView mv) {
		mv.addObject("mainpage", "map/map.jsp");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = {"phonebook/pagelist/{page}","phonebook/pagelist"})
	public ModelAndView pbList(ModelAndView mv, @PathVariable(required = false, value = "page") Integer page) {
		if(page==null) {
			page=1;
		}
		mv.addObject("mainpage", "phonebook/pageList.jsp");
		mv.addObject("pblist", pbservice.pageList(page));
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("phonebook/view")
	public ModelAndView pbView(ModelAndView mv, @RequestParam("idx") String idx) {
		mv.addObject("p", pbservice.findById(idx));
		mv.addObject("mainpage", "phonebook/view.jsp");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("phonebook/update")
	public ModelAndView pbUpdate(ModelAndView mv) {
		
		return mv;
	}
}
