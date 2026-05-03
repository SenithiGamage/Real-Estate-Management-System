import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-property-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './property-list.component.html',
  styleUrl: './property-list.component.css'
})
export class PropertyListComponent implements OnInit {

  properties: any[] = [];
  filteredProperties: any[] = [];
  loading = true;
  error = '';

  // Search & Filter
  searchTerm = '';
  selectedStatus = '';

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    this.loadProperties();
  }

  loadProperties() {
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        this.properties = data;
        this.filteredProperties = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load properties';
        this.loading = false;
      }
    });
  }

  filterProperties() {
    this.filteredProperties = this.properties.filter(property => {
      const matchesSearch = property.title.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        property.location.toLowerCase().includes(this.searchTerm.toLowerCase());
      const matchesStatus = !this.selectedStatus || property.status === this.selectedStatus;
      return matchesSearch && matchesStatus;
    });
  }
}
