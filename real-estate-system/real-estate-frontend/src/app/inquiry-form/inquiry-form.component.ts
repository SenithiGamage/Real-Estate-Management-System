import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inquiry-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './inquiry-form.component.html',
  styleUrl: './inquiry-form.component.css'
})
export class InquiryFormComponent {

  @Input() propertyId: number | null = null;   // Pass property ID from property card

  inquiry = {
    customerName: '',
    customerEmail: '',
    message: '',
    propertyId: null as any
  };

  submitted = false;
  error = '';
  success = false;

  constructor(private http: HttpClient) {}

  onSubmit() {
    if (!this.inquiry.customerName || !this.inquiry.customerEmail || !this.inquiry.message) {
      this.error = 'Please fill all required fields';
      return;
    }

    this.inquiry.propertyId = this.propertyId;

    this.http.post('http://localhost:8080/api/inquiries', this.inquiry)
      .subscribe({
        next: () => {
          this.success = true;
          this.submitted = true;
          this.error = '';

          // Reset form after 3 seconds
          setTimeout(() => {
            this.resetForm();
          }, 3000);
        },
        error: (err) => {
          this.error = err.error?.message || 'Failed to send inquiry. Please try again.';
        }
      });
  }

  resetForm() {
    this.inquiry = { customerName: '', customerEmail: '', message: '', propertyId: null };
    this.submitted = false;
    this.success = false;
    this.error = '';
  }
}
