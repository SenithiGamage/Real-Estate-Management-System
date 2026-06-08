package edu.icet.ecom.config;

import edu.icet.ecom.entity.Property;
import edu.icet.ecom.entity.PropertyStatus;
import edu.icet.ecom.entity.PropertyType;
import edu.icet.ecom.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PropertyRepository propertyRepository;

    @Override
    public void run(String... args) throws Exception {
        if (propertyRepository.count() == 0) {
            System.out.println("🌱 Seeding sample properties...");

            Property p1 = new Property();
            p1.setTitle("Luxury Beach Villa in Galle");
            p1.setLocation("Galle");
            p1.setPrice(45000000.0);
            p1.setPropertyType(PropertyType.VILLA);
            p1.setSize(45.0);
            p1.setBedrooms(5);
            p1.setBathrooms(4);
            p1.setDescription("Beautiful beachfront villa with private pool and ocean view.");
            p1.setStatus(PropertyStatus.AVAILABLE);

            Property p2 = new Property();
            p2.setTitle("Modern Apartment in Colombo 7");
            p2.setLocation("Colombo");
            p2.setPrice(18500000.0);
            p2.setPropertyType(PropertyType.APARTMENT);
            p2.setSize(1200.0);
            p2.setBedrooms(3);
            p2.setBathrooms(2);
            p2.setDescription("Spacious 3 bedroom apartment in the heart of Colombo.");
            p2.setStatus(PropertyStatus.AVAILABLE);

            Property p3 = new Property();
            p3.setTitle("Prime Land in Kandy");
            p3.setLocation("Kandy");
            p3.setPrice(12500000.0);
            p3.setPropertyType(PropertyType.LAND);
            p3.setSize(80.0);
            p3.setDescription("Prime residential land with mountain view.");
            p3.setStatus(PropertyStatus.AVAILABLE);

            propertyRepository.save(p1);
            propertyRepository.save(p2);
            propertyRepository.save(p3);

            System.out.println("✅ Sample properties seeded successfully!");
        }
    }
}