import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
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

  constructor(
    private propertyService: PropertyService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit() {
    this.loadTransactions();
  }

  private loadTransactions() {
    this.loading = true;
    this.error = '';

    // For now, we reuse properties and simulate transactions
    this.propertyService.getAllProperties().subscribe({
      next: (data) => {
        // Mock transaction data based on sold/rented properties
        this.transactions = (data || [])
          .filter(p => p.status === 'SOLD' || p.status === 'RENTED')
          .map(p => ({
            id: p.id,
            propertyTitle: p.title,
            location: p.location,
            price: p.price,
            type: p.propertyType,
            status: p.status,
            date: new Date().toISOString().split('T')[0], // Mock date
            customer: 'John Doe' // Mock customer
          }));

        this.loading = false;
        this.cdr.detectChanges();
      },
      error: (err) => {
        console.error('❌ Error loading transactions:', err);
        this.error = 'Failed to load transactions';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }
}
