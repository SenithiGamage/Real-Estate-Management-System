package edu.icet.ecom.dto;

import edu.icet.ecom.entity.PropertyStatus;
import edu.icet.ecom.entity.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    private String title;
    private String location;
    private String address;
    private PropertyType propertyType;
    private Double price;
    private Double size;
    private Integer bedrooms;
    private Integer bathrooms;
    private String description;
    private PropertyStatus status;
    private Long ownerId;
    private Long agentId;
    private LocalDateTime createdAt;
}
