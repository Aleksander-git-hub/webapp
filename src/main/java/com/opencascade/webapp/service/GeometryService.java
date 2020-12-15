package com.opencascade.webapp.service;

import com.opencascade.webapp.bl.SessionUtil;
import com.opencascade.webapp.dao.GeometryDAO;
import com.opencascade.webapp.entity.Geometry;
import org.hibernate.Session;

import java.util.List;

public class GeometryService extends SessionUtil implements GeometryDAO
{

    @Override
    public void add(List<Geometry> geometryList) {
        openTransactionSession();

        Session session = getSession();
        session.save(geometryList);

        closeTransactionSession();
    }

    @Override
    public void remove(Geometry geometry) {
        openTransactionSession();

        Session session = getSession();
        session.delete(geometry);

        closeTransactionSession();
    }
}
