import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-inquiry',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inquiry.component.html',
  styleUrl: './inquiry.component.css'     // ← Add this line
})
export class InquiryComponent implements OnInit {

  inquiries: any[] = [];
  loading = true;
  error = '';

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    this.loadInquiries();
  }

  loadInquiries() {
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        this.inquiries = data.slice(0, 6);   // Show only 6 for better UI
        this.loading = false;
      },
      error: (err) => {
        console.error('Error loading inquiries', err);
        this.error = 'Failed to load inquiries. Please try again later.';
        this.loading = false;
      }
    });
  }
}
