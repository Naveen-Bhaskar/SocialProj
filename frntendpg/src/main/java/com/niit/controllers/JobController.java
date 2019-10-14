package com.niit.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.JobDao;
import com.niit.dao.UserDao;
import com.niit.model.ErrorClas;
import com.niit.model.Job;
import com.niit.model.User;

@RestController
public class JobController {
	@Autowired
	private JobDao jobDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/addjob", method = RequestMethod.POST)
	public ResponseEntity<?> saveJob(@RequestBody Job job, HttpSession session) {

		String email = (String) session.getAttribute("loggedInUser"); // Check for
		// Authentication
		if (email == null) {
			ErrorClas ErrorClas = new ErrorClas(4, "Uauthorized access.. please login.....");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}

		// Check for Authorization(Role)
		System.out.println("Entered Job Add method");
		// String email = "adam@abc.com";
		User user = userDao.getUser(email);
		if (!user.getRole().equals("ADMIN")) {
			ErrorClas ErrorClas = new ErrorClas(5, "Access Denied.... You are not authorized to post a job");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		try {
			job.setPostedOn(new Date());
			jobDao.saveJob(job);
		} catch (Exception e) {
			ErrorClas ErrorClas = new ErrorClas(6, "Unable to post job details");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Job>(job, HttpStatus.OK);
	}

	@RequestMapping(value = "/getalljobs", method = RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session) {
		String email = (String) session.getAttribute("loggedInUser");
		if (email == null) {
			ErrorClas ErrorClas = new ErrorClas(4, "Unauthorized access");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs = jobDao.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletejob/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteJob(@PathVariable int id, HttpSession session) {
		String email = (String) session.getAttribute("loggedInUser"); // Check for
		// Authentication
		if (email == null) {
			ErrorClas ErrorClas = new ErrorClas(4, "Unauthorized access.. please login.....");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		User user = userDao.getUser(email);
		if (!user.getRole().equals("ADMIN")) {
			ErrorClas ErrorClas = new ErrorClas(5, "Access Denied.... You are not authorized to post a job");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		try {
			jobDao.deleteJob(id);
		} catch (Exception e) {
			ErrorClas ErrorClas = new ErrorClas(6, "Unable to Delete job details");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/updatejobform/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> UpdateForm(@PathVariable int id, HttpSession session) {
		String email = (String) session.getAttribute("loggedInUser");
		if (email == null) {
			ErrorClas ErrorClas = new ErrorClas(4, "Unauthorized access... please login...");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		User user = userDao.getUser(email);
		if (!user.getRole().equals("ADMIN")) {
			ErrorClas ErrorClas = new ErrorClas(5, "Access denied... You are not authorized to update");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}

		Job job = jobDao.getJob(id);
		if (job == null) {
			ErrorClas ErrorClas = new ErrorClas(6, "Unable to get a job");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updatejob", method = RequestMethod.PUT)
	public ResponseEntity<?> UpdateJob(@RequestBody Job job, HttpSession session) {
		String email = (String) session.getAttribute("loggedInUser"); // Check for
		// Authentication
		if (email == null) {
			ErrorClas ErrorClas = new ErrorClas(4, "Unauthorized access.. please login.....");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		User user = userDao.getUser(email);
		if (!user.getRole().equals("ADMIN")) {
			ErrorClas ErrorClas = new ErrorClas(5, "Access Denied.... You are not authorized to post a job");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.UNAUTHORIZED);
		}
		try {
			job.setPostedOn(new Date());
			jobDao.updateJob(job);
		} catch (Exception e) {
			ErrorClas ErrorClas = new ErrorClas(6, "Unable to Delete job details");
			return new ResponseEntity<ErrorClas>(ErrorClas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}