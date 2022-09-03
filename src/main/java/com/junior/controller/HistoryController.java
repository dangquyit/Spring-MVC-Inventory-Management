package com.junior.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junior.entity.History;
import com.junior.model.Paging;
import com.junior.service.HistoryService;
import com.junior.util.Constant;

@Controller
public class HistoryController {
	private static final Logger LOGGER = Logger.getLogger(HistoryController.class);
	
	@Autowired
	private HistoryService historyService;
	
//	@GetMapping(value = {"/history/list/", "/history/list"})
	@GetMapping(value = {"/history", "/history/"})
	public String redirect() {
		return "redirect:/history/1";
	}
	
//	@RequestMapping("/history/list/{page}")
	@RequestMapping("/history/{page}")
	public String history(Model model, @ModelAttribute("searchForm") History history, @PathVariable("page") int page) {
		LOGGER.info("Show history list");
		Paging paging = new Paging(5);
		paging.setIndexPage(page);
		List<History> listHistory = historyService.findAll(history, paging);
		Map<String, String> mapType = new HashMap<>();
		mapType.put(String.valueOf(Constant.TYPE_ALL), "All");
		mapType.put(String.valueOf(Constant.TYPE_GOODS_RECEIPT), "Goods Receipt");
		mapType.put(String.valueOf(Constant.TYPE_GOODS_ISSUES), "Goods Issues");
		model.addAttribute("listHistory", listHistory);
		model.addAttribute("pageInfo", paging);
		model.addAttribute("mapType", mapType);
		return "history";
	}
	
	
}
