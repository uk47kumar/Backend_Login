package com.example.authentication.model.component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "component_type")
public class ComponentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_type_id", length = 11)
    private int componentTypeId;

    @Column(name = "url1", length = 50)
    private String url1;

    @Column(name = "url2", length = 50)
    private String url2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated;

    @OneToMany(mappedBy = "componentTypeId",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Component> components;
}
