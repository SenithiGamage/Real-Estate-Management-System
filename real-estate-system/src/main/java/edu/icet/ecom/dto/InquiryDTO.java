package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryDTO {
    private Long id;
    private Long propertyId;
    private String customerName;
    private String customerEmail;
    private String message;
    private String status;
    private LocalDateTime createdAt;
}