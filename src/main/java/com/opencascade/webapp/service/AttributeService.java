package com.opencascade.webapp.service;

import com.opencascade.webapp.bl.SessionUtil;
import com.opencascade.webapp.dao.AttributeDAO;
import com.opencascade.webapp.entity.Attribute;
import org.hibernate.Session;

import java.util.List;

public class AttributeService extends SessionUtil implements AttributeDAO
{

    @Override
    public void add(List<Attribute> attributeList) {
        openTransactionSession();

        Session session = getSession();
        session.save(attributeList);

        closeTransactionSession();
    }

    @Override
    public void remove(Attribute attribute) {
        openTransactionSession();

        Session session = getSession();
        session.delete(attribute);

        closeTransactionSession();
    }
}
