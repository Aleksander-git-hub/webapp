/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.opencascade.webapp.ui;

import com.opencascade.webapp.dao.HibernateUtil;
import com.opencascade.webapp.entity.Attribute;
import com.opencascade.webapp.entity.Geometry;
import com.opencascade.webapp.entity.Project;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class SampleWebStaticApplication
{
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Project project = new Project();
            project.setProjectName("project1");

            List<Geometry> geometryList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Geometry geometry = new Geometry();
                geometry.setGeometryName("Geom" + i);
                geometry.setProject(project);
                geometryList.add(geometry);
            }

            List<Attribute> attributeList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Attribute attribute = new Attribute();
                attribute.setAttributeName("Attr" + i);
                attribute.setProject(project);
                attribute.setGeometry(geometryList.get(1));
                attributeList.add(attribute);
            }

            session.save(project);
            session.save(geometryList);
            session.save(attributeList);

            session.getTransaction().commit();
        }
    }
}

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class SampleWebStaticApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebStaticApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SampleWebStaticApplication.class);
	}

}*/
