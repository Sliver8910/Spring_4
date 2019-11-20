package com.ruda.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s4.model.BoardQnaVO;
import com.ruda.s4.model.BoardVO;
import com.ruda.s4.service.BoardQnaService;
import com.ruda.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	@Inject
	private BoardQnaService boardQnaService;
	
	@RequestMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> ar = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager" ,pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method =  RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session, MultipartFile [] file)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardWrite(boardVO, session, file);
		String message = "Write Fail";
		if(result>0) {
			message = "Write Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.addObject("board", "qna");
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public String boardWrite(Model model)throws Exception{
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "qnaSelect")
	public ModelAndView boardSelect(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardQnaService.boardSelect(boardVO);
		mv.addObject("dto", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView boardDelete(BoardVO boardVO)throws Exception{
		int result = boardQnaService.boardDelete(boardVO);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;	
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public String boardUpdate(Model model, BoardVO boardVO)throws Exception{
		boardVO = boardQnaService.boardSelect(boardVO);
		model.addAttribute("dto", boardVO);
		model.addAttribute("board", "qna");
		return "board/boardUpdate";
	}
	
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardUpdate(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("msg", "Update Fail");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public String boardReply(BoardVO boardVO ,Model model)throws Exception{
		model.addAttribute("dto", boardVO);
		model.addAttribute("board", "qna");
		return "board/boardReply";
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply(BoardVO boardVO)throws Exception{
		int result = boardQnaService.boardReply(boardVO);
		ModelAndView mv = new ModelAndView();
		String message = "Reply Fail";
		if(result>0) {
			message = "Reply Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		return mv;
	}
	
}
