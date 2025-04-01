import { Component, Inject, PLATFORM_ID } from '@angular/core';
import { Router } from '@angular/router';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  username: string = '';
  password: string = '';

  constructor(
    @Inject(PLATFORM_ID) private platformId: object,
    private router: Router
  ) {}

  login() {
    if (isPlatformBrowser(this.platformId)) {
      if (this.username === 'Priyanka' && this.password === 'helloPetify') {
        localStorage.setItem('username', this.username); // Store username

        alert('Successfully logged in'); // Show success message
        this.router.navigate(['/']); // Redirect to homepage

        // ✅ Force Navbar to detect change
        setTimeout(() => window.location.reload(), 100);
      } else {
        alert('Invalid username or password');
      }
    }
  }
}