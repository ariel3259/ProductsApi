package com.ariel.ProductsApi.Abstractions;

import java.sql.Date;
import org.springframework.data.annotation.CreatedBy;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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

    @Column(name="created_at")
    protected Date createdAt;

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
        this.createdAt = new Date(System.currentTimeMillis());
        this.updatedAt = new Date(System.currentTimeMillis());
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.status = status;
    }

}
