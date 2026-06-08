****Real Estate Management System - Sri Lanka****

****1. Project Overview****

****RealEstate LK**** is a full-stack web application designed to simplify property buying, selling, and renting in Sri Lanka. It provides a user-friendly platform for customers to browse properties, send inquiries, and for administrators to manage listings and inquiries.

****Key Features:****

    Browse and search properties with filters
    Send property inquiries
    Admin panel for property and inquiry management
    Reports dashboard (MIS Reports)
    Responsive and modern UI

****2. System Architecture****
   
****Frontend (Angular 18)****

    Standalone components
    Reactive forms
    HttpClient for API communication
    Routing-based navigation

****Backend (Spring Boot)****

    RESTful APIs
    JPA / Hibernate with MySQL
    Service-Repository Layer Architecture
    DTO pattern for data transfer

****Database****

    MySQL (real_estate_db)
    Entities: Property, Inquiry, User

****Architecture Diagram (Layered)****

Frontend (Angular) 

    ↓ HTTP
    
Backend (Spring Boot)

    ↓
    
Service Layer → Repository Layer → MySQL Database

****3. Technologies Used****
   
****Frontend:****

    Angular 18 (Standalone Components)
    TypeScript
    HTML5 & CSS3
    RxJS

****Backend:****

    Spring Boot 3
    Java 17+
    Spring Data JPA
    Hibernate
    MySQL Database

****Tools & Others:****

    Maven
    Git
    Postman (API Testing)
    MySQL Workbench
    Lombok


****4. Screenshots / UI Previews****

Home Page
<img width="1916" height="888" alt="image" src="https://github.com/user-attachments/assets/c34db6f6-1b5f-427e-8259-6733ccc5223e" />
<img width="1912" height="872" alt="image" src="https://github.com/user-attachments/assets/308d550a-0cb5-402c-857a-0325c03e710d" />

Properties Page
<img width="1912" height="874" alt="image" src="https://github.com/user-attachments/assets/08a03b19-9181-48c8-9bef-716a5f6ea2b0" />

My Inquiries Page
<img width="1913" height="888" alt="image" src="https://github.com/user-attachments/assets/326812fc-b821-4a3e-b5cf-169e5a0ca6b7" />

Admin Panel
<img width="1905" height="887" alt="image" src="https://github.com/user-attachments/assets/c4458a1c-e8b1-4a79-968e-b1593b0b12bf" />
<img width="1899" height="866" alt="image" src="https://github.com/user-attachments/assets/38a3d455-cb92-4430-9d2f-12f3832a77e4" />

Transactions Page
<img width="1904" height="864" alt="image" src="https://github.com/user-attachments/assets/d55cc50e-5d40-41f6-8c0c-39a8501c87fa" />

Reports Dashboard
<img width="1911" height="877" alt="image" src="https://github.com/user-attachments/assets/577637e1-f11d-40e7-9fa2-2a911f157122" />

Login Dashboard
<img width="1904" height="876" alt="image" src="https://github.com/user-attachments/assets/0f9ed131-a469-4693-8c77-3af0603ca63c" />

****5. How to Run the Project****
   
****Backend:****

    Bash
    cd real-estate-system
    mvn spring-boot:run
****Frontend:****

    Bashc
    d real-estate-frontend
    ng serve
    
Access:

    Frontend: http://localhost:4200
    Backend: http://localhost:8080
