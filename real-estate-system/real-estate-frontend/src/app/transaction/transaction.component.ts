import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PropertyService } from '../property.service';

@Component({
  selector: 'app-transaction',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './transaction.component.html',
  styleUrl: './transaction.component.css'
})
export class TransactionComponent implements OnInit {

  transactions: any[] = [];
  loading = true;
  error = '';

  constructor(private propertyService: PropertyService) {}

  ngOnInit() {
    this.loadTransactions();
  }

  loadTransactions() {
    // For demo, we'll use properties as sold/rented items
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        this.transactions = data.filter(p => p.status === 'SOLD' || p.status === 'RENTED');
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Failed to load transactions';
        this.loading = false;
      }
    });
  }

  recordTransaction(property: any) {
    alert(`Transaction recorded for: ${property.title}\nStatus: ${property.status}`);
  }
}
