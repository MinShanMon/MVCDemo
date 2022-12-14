package nus.edu.sa.iss.demoDay1.model;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Person {
    private String id;
    private String firstName;
    private String lastName;


        public Person(String firstName, String lastName){
            this.id = UUID.randomUUID().toString().substring(0, 8);
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Person(String id, String fname, String lname){
            this.firstName = fname;
            this.lastName = lname;
            this.id = id;
        }
    }

    //mvn spring-boot:run
    
    

