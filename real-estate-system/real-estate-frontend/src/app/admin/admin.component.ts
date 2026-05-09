import { Component, OnInit } from '@angular/core';
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
  users: any[] = [];
  loading = true;

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    this.loadAdminData();
  }

  loadAdminData() {
    this.propertyService.getAllProperties().subscribe(data => {
      this.properties = data;
      this.loading = false;
    });
  }

  deleteProperty(id: number) {
    if (confirm('Are you sure you want to delete this property?')) {
      // Call delete API
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
