import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';  
import { Router } from '@angular/router';  
import { user } from 'src/app/user';  
import { AuthService } from '../auth.service'  

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(  private formBuilder : FormBuilder,
    private router: Router,
    private authService: AuthService) { 
  
  }
model : user= {id: 1, firstName:'Jesse', lastName:'Warren',userType: 'Supervisor', balance : 0, reportsto: 3, email:'jtwarrenz@gmail.com',username:"Jesse", password: "Jesse" }
loginForm: FormGroup;  
message: string;  
returnUrl: string;  


ngOnInit() {
  this.loginForm=this.formBuilder.group({
    username: ['',Validators.required],
    password: ['',Validators.required]

  });
  this.returnUrl='/employee101';
  this.authService.logout();
  }

  get f() { return this.loginForm.controls; }

  login() {  
  
    // stop here if form is invalid  
    if (this.loginForm.invalid) {  
       return;  
    }  
    else {  
       if (this.f.username.value == this.model.username && this.f.password.value == this.model.password) {  
          console.log("Login successful");  
          //this.authService.authLogin(this.model);  
          localStorage.setItem('isLoggedIn', "true");  
          localStorage.setItem('token', this.f.username.value);  
          this.router.navigate([this.returnUrl]);  
       }  
    else {  
       this.message = "Please check your username and password";  
       }  
      }  
    }  

}
