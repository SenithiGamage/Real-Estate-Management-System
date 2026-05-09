import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-inquiry',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inquiry.component.html',
  styleUrl: './inquiry.component.css'
})
export class InquiryComponent {

  inquiries: any[] = [];
  loading = true;
  error = '';

  constructor(private propertyService: PropertyService) {
    // Load immediately
    this.loadInquiries();
  }

  private loadInquiries() {
    this.loading = true;
    this.error = '';

    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        console.log('✅ Inquiries loaded successfully:', data);
        this.inquiries = data || [];
        this.loading = false;
      },
      error: (err) => {
        console.error('❌ Error:', err);
        this.error = 'Failed to load inquiries';
        this.loading = false;
      }
    });
  }

  openInquiryForm(item: any) {
    alert(`Inquiry Form Opened for: ${item.title || 'Property'}`);
  }
}
