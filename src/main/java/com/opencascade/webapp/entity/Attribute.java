package com.opencascade.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "attribute")
public class Attribute
{
    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL)
    private Geometry geometry;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attributeId;

    @Column(name = "attribute_name")
    private String attributeName;

    public Attribute() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "project=" + project +
                ", geometry=" + geometry +
                ", attributeId=" + attributeId +
                ", attributeName='" + attributeName + '\'' +
                '}';
    }
}
