package com.sairam.project.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sairam.project.modal.College;
import com.sairam.project.modal.RegisterModal;
import com.sairam.project.repo.CollegeRepo;
import com.sairam.project.repo.RegisterRepo;



@Controller
@RequestMapping("/api")
public class Register {


public RegisterModal Rm;
@Autowired
public RegisterRepo Rp;

@Autowired
public CollegeRepo collegerepo;

	/*@RequestMapping("/reg")
	public ResponseEntity<Void> savingg(@PathVariable("n") String FirstName,@PathVariable("s") String lname,
			@PathVariable("m") String eamil ,@PathVariable("d") String password) throws URISyntaxException{
		System.out.println("this is controller "+FirstName+" "+lname+" "+eamil+" "+password);
		Rm=new RegisterModal();
		Rm.setFirstName(FirstName);
		Rm.setLastName(lname);
		Rm.setEmail(eamil);
		Rm.setPassword(password);
		System.out.println("this is controller "+Rm.getFirstName()+"  "+Rm.getLastName());

		Rp.save(Rm);
		getall();
	System.out.println("this is controllerssssssssssssss "+FirstName+" "+lname+" "+eamil+" "+password);
	return ResponseEntity.created(
			new URI("/api/reggg/" + Rm.getId())).build();
		
	}*/
	
@RequestMapping(value="/reg",method=RequestMethod.POST)
public ResponseEntity<Void> savingg(@RequestBody RegisterModal regm) throws URISyntaxException{
	System.out.println("this is controller "+regm.getFirstname());
	Rp.save(regm);
	getall();
return ResponseEntity.created(
		new URI("/api/reggg/" + Rm.getId())).build();
	
}

	@RequestMapping(value="/getRegister",method=RequestMethod.GET)
	public ResponseEntity<List<RegisterModal>> getall(){
		
		List<RegisterModal> GetRm=Rp.findAll();
		return new ResponseEntity<List<RegisterModal>>(GetRm,HttpStatus.OK);
	}
	
	@RequestMapping("/update")
	public ResponseEntity<Void> update(@RequestBody RegisterModal regm ){
		Rp.save(regm);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public ResponseEntity<RegisterModal> get(@PathVariable Long id,HttpServletResponse response){
		RegisterModal Rr=Rp.findByIdre(id);
		System.out.println(Rr);
		return new ResponseEntity<>(Rr,HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		System.out.println("delete");
		RegisterModal Rr=Rp.findByIdre(id);
		Rp.delete(Rr);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/getAllColleges",method=RequestMethod.GET)
	public ResponseEntity<List<College>> getAllcolleges(){
		List<College> getall=collegerepo.findAll();
		return new  ResponseEntity<>(getall,HttpStatus.OK);
	}
}
