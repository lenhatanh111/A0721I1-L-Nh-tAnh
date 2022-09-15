package com.example.codegym.models.dto;

import com.example.codegym.models.entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public interface GetProductDto {
     Long getId();
     String getName();
     String getDescription();
     BigDecimal getUnit_price();
     String getImage_url();
     Boolean getActive();
     int getUnit_in_stock();
     Date getDate_created();
     Date getLast_update();
     long getAuthor_id();
     long getPublisher_id();
     String getAuthor_name();
     String getPublisher_name();


}
