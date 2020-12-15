package com.opencascade.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "geometry")
public class Geometry
{
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "geometry_project_id")
    private Project project;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geometry_id")
    private Integer geometryId;

    @Column(name = "geometry_name")
    private String geometryName;

    public Geometry() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getGeometryId() {
        return geometryId;
    }

    public void setGeometryId(Integer geometryId) {
        this.geometryId = geometryId;
    }

    public String getGeometryName() {
        return geometryName;
    }

    public void setGeometryName(String geometryName) {
        this.geometryName = geometryName;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "project=" + project +
                ", geometryId=" + geometryId +
                ", geometryName='" + geometryName + '\'' +
                '}';
    }
}
