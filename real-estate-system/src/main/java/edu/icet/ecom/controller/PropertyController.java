package edu.icet.ecom.controller;

import edu.icet.ecom.dto.PropertyDTO;
import edu.icet.ecom.entity.PropertyStatus;
import edu.icet.ecom.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/properties")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyService propertyService;

    // Create Property
    @PostMapping
    public ResponseEntity<PropertyDTO> createProperty(@RequestBody PropertyDTO propertyDTO) {
        PropertyDTO saved = propertyService.saveProperty(propertyDTO);
        return ResponseEntity.ok(saved);
    }

    // Get All Properties
    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    // Get Property by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id) {
        PropertyDTO property = propertyService.getPropertyById(id);
        return property != null ? ResponseEntity.ok(property) : ResponseEntity.notFound().build();
    }

    // Search by Location
    @GetMapping("/search")
    public ResponseEntity<List<PropertyDTO>> searchByLocation(@RequestParam String location) {
        return ResponseEntity.ok(propertyService.getPropertiesByLocation(location));
    }

    // Filter by Status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<PropertyDTO>> getByStatus(@PathVariable PropertyStatus status) {
        return ResponseEntity.ok(propertyService.getPropertiesByStatus(status));
    }

    // Filter by Price Range
    @GetMapping("/price-range")
    public ResponseEntity<List<PropertyDTO>> getByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return ResponseEntity.ok(propertyService.getPropertiesByPriceRange(minPrice, maxPrice));
    }

    // Update Property
    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(
            @PathVariable Long id,
            @RequestBody PropertyDTO propertyDTO) {
        PropertyDTO updated = propertyService.updateProperty(id, propertyDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Delete Property
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
