/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.naming;

import java.io.Serial;

import javax.naming.StringRefAddr;

/**
 * Represents a reference address to an EJB.
 *
 * @author Remy Maucherat
 */
public class EjbRef extends AbstractRef {

    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * Default factory for this reference.
     */
    public static final String DEFAULT_FACTORY = org.apache.naming.factory.Constants.DEFAULT_EJB_FACTORY;


    /**
     * EJB type address type.
     */
    public static final String TYPE = "type";


    /**
     * Remote interface classname address type.
     */
    public static final String REMOTE = "remote";


    /**
     * Link address type.
     */
    public static final String LINK = "link";


    /**
     * EJB Reference.
     *
     * @param ejbType EJB type
     * @param home    Home interface classname
     * @param remote  Remote interface classname
     * @param link    EJB link
     */
    public EjbRef(String ejbType, String home, String remote, String link) {
        this(ejbType, home, remote, link, null, null);
    }


    /**
     * EJB Reference.
     *
     * @param ejbType         EJB type
     * @param home            Home interface classname
     * @param remote          Remote interface classname
     * @param link            EJB link
     * @param factory         The possibly null class name of the object's factory.
     * @param factoryLocation The possibly null location from which to load the factory (e.g. URL)
     */
    public EjbRef(String ejbType, String home, String remote, String link, String factory, String factoryLocation) {
        super(home, factory, factoryLocation);
        StringRefAddr refAddr;
        if (ejbType != null) {
            refAddr = new StringRefAddr(TYPE, ejbType);
            add(refAddr);
        }
        if (remote != null) {
            refAddr = new StringRefAddr(REMOTE, remote);
            add(refAddr);
        }
        if (link != null) {
            refAddr = new StringRefAddr(LINK, link);
            add(refAddr);
        }
    }


    @Override
    protected String getDefaultFactoryClassName() {
        return DEFAULT_FACTORY;
    }
}
