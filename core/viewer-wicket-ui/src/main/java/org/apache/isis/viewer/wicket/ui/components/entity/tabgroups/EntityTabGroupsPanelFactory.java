/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.isis.viewer.wicket.ui.components.entity.tabgroups;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

import org.apache.isis.core.metamodel.facets.object.layoutxml.LayoutXmlFacet;
import org.apache.isis.core.metamodel.spec.ObjectSpecification;
import org.apache.isis.viewer.wicket.model.models.EntityModel;
import org.apache.isis.viewer.wicket.ui.ComponentFactory;
import org.apache.isis.viewer.wicket.ui.ComponentType;
import org.apache.isis.viewer.wicket.ui.components.entity.EntityComponentFactoryAbstract;

/**
 * {@link ComponentFactory} for {@link EntityTabGroupsPanel}.
 */
public class EntityTabGroupsPanelFactory extends EntityComponentFactoryAbstract {

    private static final long serialVersionUID = 1L;

    private static final String NAME = "tabbed";

    public EntityTabGroupsPanelFactory() {
        super(ComponentType.ENTITY, NAME, EntityTabGroupsPanel.class);
    }

    @Override
    protected ApplicationAdvice doAppliesTo(final EntityModel entityModel) {
        final ObjectSpecification specification = entityModel.getTypeOfSpecification();
        return appliesIf(specification.containsDoOpFacet(LayoutXmlFacet.class));
    }

    @Override
    public Component createComponent(final String id, final IModel<?> model) {
        final EntityModel entityModel = (EntityModel) model;
        return new EntityTabGroupsPanel(id, entityModel);
    }
}