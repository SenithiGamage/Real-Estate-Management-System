package edu.icet.ecom.controller;

import edu.icet.ecom.dto.InquiryDTO;
import edu.icet.ecom.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<InquiryDTO> createInquiry(@RequestBody InquiryDTO inquiryDTO) {
        InquiryDTO saved = inquiryService.saveInquiry(inquiryDTO);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<InquiryDTO>> getAllInquiries() {
        return ResponseEntity.ok(inquiryService.getAllInquiries());
    }

    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<InquiryDTO>> getInquiriesByProperty(@PathVariable Long propertyId) {
        return ResponseEntity.ok(inquiryService.getInquiriesByProperty(propertyId));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<InquiryDTO> updateStatus(@PathVariable Long id, @RequestParam String status) {
        InquiryDTO updated = inquiryService.updateInquiryStatus(id, status);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInquiry(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
        return ResponseEntity.noContent().build();
    }
}