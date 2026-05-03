import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-inquiry',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inquiry.component.html'
})
export class InquiryComponent implements OnInit {
  inquiries: any[] = [];

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    // For now, load properties as placeholder
    this.propertyService.getAllProperties().subscribe(data => {
      this.inquiries = data.slice(0, 5);
    });
  }
}
