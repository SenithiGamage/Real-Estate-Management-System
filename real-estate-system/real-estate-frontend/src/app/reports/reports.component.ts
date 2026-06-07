import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.css'
})
export class ReportsComponent implements OnInit {

  properties: any[] = [];
  loading = true;
  error = '';

  totalProperties = 0;
  availableProperties = 0;
  soldProperties = 0;
  rentedProperties = 0;

  constructor(
    private propertyService: PropertyService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.loadReports();
  }

  private loadReports() {
    this.loading = true;
    this.error = '';

    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        console.log('✅ Reports data loaded:', data);

        this.properties = data || [];

        this.totalProperties = this.properties.length;
        this.availableProperties = this.properties.filter(p => p.status === 'AVAILABLE').length;
        this.soldProperties = this.properties.filter(p => p.status === 'SOLD').length;
        this.rentedProperties = this.properties.filter(p => p.status === 'RENTED').length;

        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('❌ Error loading reports:', err);
        this.error = 'Failed to load reports. Please check if backend is running.';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }
}
