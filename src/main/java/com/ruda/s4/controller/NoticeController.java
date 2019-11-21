package com.ruda.s4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ruda.s4.model.BoardNoticeVO;
import com.ruda.s4.model.BoardVO;
import com.ruda.s4.model.NoticeFilesVO;
import com.ruda.s4.service.BoardNoticeService;
import com.ruda.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(NoticeFilesVO noticeFilesVO)throws Exception{
		int result = boardNoticeService.fileDelete(noticeFilesVO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", result);
		return mv;

	}
	
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager" ,pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
		
	}
	
	@RequestMapping(value = "noticeWrite", method =  RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session, MultipartFile [] file)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardWrite(boardVO, session, file);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "Write Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite(Model model)throws Exception{
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	@RequestMapping(value = "noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		mv.addObject("dto", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO)throws Exception{
		int result = boardNoticeService.boardDelete(boardVO);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Fail";
		if(result>0) {
			message = "Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		
		return mv;	
	}
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(Model model, BoardVO boardVO)throws Exception{
		boardVO = boardNoticeService.boardSelect(boardVO);
		BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		model.addAttribute("size", boardNoticeVO.getFiles().size());
		model.addAttribute("dto", boardVO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = boardNoticeService.boardUpdate(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else {
			mv.addObject("msg", "Update Fail");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	

}
