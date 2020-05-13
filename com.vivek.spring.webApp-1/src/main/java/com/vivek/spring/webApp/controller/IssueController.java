package com.vivek.spring.webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vivek.spring.webApp.IssueReport;
import com.vivek.spring.webApp.repositories.IssueRepository;

@Controller
public class IssueController 
{
	IssueRepository issueRepository;
	
	public IssueController(IssueRepository issueRepository)
	{
		this.issueRepository = issueRepository;
	}
	@GetMapping("/issuereport")
	public String getReport(Model model,
	@RequestParam(name = "submitted", required = false)		
	boolean submitted		)
	{
		model.addAttribute("submitted",submitted);
		model.addAttribute("issuereport", new IssueReport());
		return "issues/issuereport_form";
	}
	
	@PostMapping(value = "/issuereport")
	public String submitReport(IssueReport issueReport,RedirectAttributes ra)
	{
		this.issueRepository.save(issueReport);
		//model.addAttribute("issuereport",new IssueReport());
		ra.addAttribute("submitted",true);
		return "redirect:/issuereport";
	}
	
	@GetMapping("/issues")
    public String getIssues(Model model) {  
		model.addAttribute("issues",this.issueRepository.findAllButPrivate());
        return "issues/issuereport_list";
    }
}
