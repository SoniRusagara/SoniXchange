package com.soniXchange.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
}
