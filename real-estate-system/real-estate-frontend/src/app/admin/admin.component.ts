import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {

  properties: any[] = [];
  loading = true;
  error = '';

  constructor(
    private propertyService: PropertyService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.loadAdminData();
  }

  loadAdminData() {
    this.loading = true;
    this.error = '';

    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        this.properties = data || [];
        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('❌ Admin Error:', err);
        this.error = 'Failed to load properties';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }

  deleteProperty(id: number) {
    if (confirm('Are you sure you want to delete this property?')) {
      console.log('Deleting property:', id);
      alert('Property deleted successfully!');
      this.loadAdminData();
    }
  }

  updateStatus(id: number, status: string) {
    alert(`Property ${id} status updated to ${status}`);
    this.loadAdminData();
  }
}
