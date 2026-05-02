package edu.icet.ecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Column(nullable = false)
    private Double price; // cite: 327

    private Double size;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private PropertyStatus status = PropertyStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner; 
}

enum PropertyType {
    HOUSE, LAND, APARTMENT
}

enum PropertyStatus {
    AVAILABLE, SOLD, RENTED
}
