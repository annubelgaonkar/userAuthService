package dev.anuradha.userauthservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;


}
