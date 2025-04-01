import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  username: string | null = null;

  constructor(private router: Router, private cdr: ChangeDetectorRef) {}

  ngOnInit() {
    this.loadUsername();

    // ✅ Check for changes on every navigation event
    this.router.events.subscribe(() => {
      this.loadUsername();
    });
  }

  loadUsername() {
    this.username = localStorage.getItem('username');
    this.cdr.detectChanges(); // ✅ Force update
  }

  logout() {
    localStorage.removeItem('username'); // ✅ Clear storage
    this.username = null;

    this.router.navigate(['/login']); // ✅ Redirect to login page

    // ✅ Force Navbar Update
    setTimeout(() => window.location.reload(), 100);
  }
}
