package com.vivek.spring.webApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.spring.webApp.IssueReport;
import com.vivek.spring.webApp.repositories.IssueRepository;

@RestController
@RequestMapping("/api/issues")
public class IssueRestController {
    private IssueRepository issueRepository;

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
    
    @GetMapping("/{id}/{email}")
    public ResponseEntity<IssueReport> getIssueByEmail(@PathVariable("id") long id,@PathVariable("email") String email,  Optional<IssueReport> issueReportOptional )
    {
    	if(!issueReportOptional.isPresent())
    	{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    	return new ResponseEntity<>( issueReportOptional.get(), HttpStatus.FOUND);
    }
    @GetMapping
    public List<IssueReport> getIssues() {
        return this.issueRepository.findAllButPrivate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") Optional<IssueReport> issueReportOptional) {
        if (!issueReportOptional.isPresent() ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(issueReportOptional.get(), HttpStatus.OK);
    }
    
}