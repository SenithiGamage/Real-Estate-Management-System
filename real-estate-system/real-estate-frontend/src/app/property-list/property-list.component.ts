import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-property-list',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './property-list.component.html',
  styleUrl: './property-list.component.css'
})
export class PropertyListComponent implements OnInit {

  properties: any[] = [];
  filteredProperties: any[] = [];
  loading = true;
  error = '';

  searchTerm = '';
  selectedStatus = '';

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    this.loadProperties();
  }

  loadProperties() {
    this.loading = true;
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        console.log('✅ Properties loaded:', data);
        this.properties = data || [];
        this.filteredProperties = [...this.properties];
        this.loading = false;
      },
      error: (err) => {
        console.error('❌ Error:', err);
        this.error = 'Failed to load properties';
        this.loading = false;
      }
    });
  }

  filterProperties() {
    this.filteredProperties = this.properties.filter(p => {
      const matchesSearch = (p.title || '').toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        (p.location || '').toLowerCase().includes(this.searchTerm.toLowerCase());
      const matchesStatus = !this.selectedStatus || p.status === this.selectedStatus;
      return matchesSearch && matchesStatus;
    });
  }
}
