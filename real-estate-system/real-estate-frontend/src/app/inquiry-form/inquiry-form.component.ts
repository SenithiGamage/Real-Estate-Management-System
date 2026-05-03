import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-inquiry-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './inquiry-form.component.html',
  styleUrl: './inquiry-form.component.css'
})
export class InquiryFormComponent {

  inquiry = {
    customerName: '',
    customerEmail: '',
    message: '',
    propertyId: null as any
  };

  submitted = false;
  error = '';

  constructor(private propertyService: PropertyService) {}

  onSubmit() {
    if (!this.inquiry.customerName || !this.inquiry.customerEmail || !this.inquiry.message) {
      this.error = 'Please fill all required fields';
      return;
    }

    // TODO: Call backend API when InquiryService is ready
    console.log('Inquiry Submitted:', this.inquiry);

    this.submitted = true;
    this.error = '';

    // Reset form after successful submission
    setTimeout(() => {
      this.inquiry = {
        customerName: '',
        customerEmail: '',
        message: '',
        propertyId: null
      };
      this.submitted = false;
    }, 2000);
  }
}
