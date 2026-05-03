import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

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

  onSubmit() {
    if (this.inquiry.customerName && this.inquiry.customerEmail && this.inquiry.message) {
      alert('Inquiry Submitted Successfully! (Backend integration coming soon)');
      this.inquiry = { customerName: '', customerEmail: '', message: '', propertyId: null };
    } else {
      alert('Please fill all fields');
    }
  }
}
