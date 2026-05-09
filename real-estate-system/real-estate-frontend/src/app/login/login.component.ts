import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  isLoginMode = true; // Toggle between Login and Register

  loginData = {
    username: '',
    password: ''
  };

  registerData = {
    username: '',
    email: '',
    fullName: '',
    password: '',
    role: 'CUSTOMER' as 'CUSTOMER' | 'SELLER' | 'AGENT'
  };

  message = '';
  isSuccess = false;

  constructor(private http: HttpClient) {}

  toggleMode() {
    this.isLoginMode = !this.isLoginMode;
    this.message = '';
  }

  onSubmit() {
    if (this.isLoginMode) {
      this.login();
    } else {
      this.register();
    }
  }

  login() {
    this.http.post('http://localhost:8080/api/users/login', this.loginData)
      .subscribe({
        next: (response: any) => {
          this.message = 'Login Successful!';
          this.isSuccess = true;
          alert('Welcome! Login Successful.');
          // TODO: Save token and redirect
        },
        error: (err) => {
          this.message = 'Invalid username or password';
          this.isSuccess = false;
        }
      });
  }

  register() {
    this.http.post('http://localhost:8080/api/users/register', this.registerData)
      .subscribe({
        next: (response) => {
          this.message = 'Registration Successful! You can now login.';
          this.isSuccess = true;
          this.toggleMode(); // Switch to login mode
        },
        error: (err) => {
          this.message = err.error?.message || 'Registration Failed';
          this.isSuccess = false;
        }
      });
  }
}
