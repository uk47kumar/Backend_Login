package com.example.authentication.model.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "component")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "component_id", length = 11)
    private int componentId;

    @Column(name = "component_name", length = 30)
    private String componentName;

    @Column(name = "sub_component_name", length = 30)
    private String subComponentName;

    @Column(name = "component_order", length = 2)
    private int componentOrder;

    @Column(name = "sub_component_id", length = 11)
    private int subComponentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updated;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "component_type_id", referencedColumnName = "component_type_id")
    private ComponentType componentTypeId;
}
