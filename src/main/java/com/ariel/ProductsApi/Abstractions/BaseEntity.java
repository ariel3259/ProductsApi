package com.ariel.ProductsApi.Abstractions;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id()
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected long id;

    @CreatedDate
    @Column(name="created_at")
    protected Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    protected Date updatedAt;

    @CreatedBy()
    @Column
    protected String createdBy;

    @Column
    protected String updatedBy;

    @Column
    protected boolean status;

    public BaseEntity(String createdBy, String updatedBy, boolean status) {
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.status = status;
    }

}
