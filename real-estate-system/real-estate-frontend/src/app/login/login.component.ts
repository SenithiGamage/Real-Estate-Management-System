import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  credentials = {
    username: '',
    password: ''
  };

  error = '';
  loading = false;

  constructor(private router: Router) {}

  onLogin() {
    this.loading = true;
    this.error = '';

    // Mock login (replace with real API call later)
    setTimeout(() => {
      if (this.credentials.username && this.credentials.password) {
        alert('✅ Login Successful! (Mock)');
        this.router.navigate(['/']);
      } else {
        this.error = 'Please enter username and password';
      }
      this.loading = false;
    }, 800);
  }
}
