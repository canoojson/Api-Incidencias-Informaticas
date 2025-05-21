package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.Profesor;
import com.example.demo.service.ProfesorService;

@RestController
@RequestMapping(value = "/api")
public class LoginController {
	
	@Autowired
    private ProfesorService profesorService;
	
	@PostMapping("/login")
    public ResponseEntity<?> validarInicioSesion(@RequestBody LoginRequest request){
		System.out.println("USERNAME: " + request.getUsername());
	    System.out.println("PWD: " + request.getPwd());
		
    	Profesor p = profesorService.validarInicioSesion(request.getUsername(), request.getPwd());
    	
    	if(p==null) {
    		System.out.println("PATATA");
    		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales invalidas");
    	} else {
    		return ResponseEntity.ok(p);
    	}
    	
    }
}
