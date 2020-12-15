package com.opencascade.webapp.dao;

import com.opencascade.webapp.entity.Attribute;

import java.util.List;

public interface AttributeDAO
{
    void add(List<Attribute> attributeList);

    void remove(Attribute attribute);
}
