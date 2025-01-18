package entities;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name= "name")
    private String name;
    @Column( name= "state")
    private State state;
}
