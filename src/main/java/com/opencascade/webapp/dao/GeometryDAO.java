package com.opencascade.webapp.dao;

import com.opencascade.webapp.entity.Geometry;

import java.util.List;

public interface GeometryDAO
{
    void add(List<Geometry> geometryList);

    void remove(Geometry geometry);
}
