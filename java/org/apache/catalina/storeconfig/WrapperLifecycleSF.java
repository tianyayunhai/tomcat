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
package org.apache.catalina.storeconfig;

import java.io.PrintWriter;

import org.apache.catalina.core.StandardContext;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class WrapperLifecycleSF extends StoreFactoryBase {
    private static final Log log = LogFactory.getLog(WrapperLifecycleSF.class);

    @Override
    public void store(PrintWriter aWriter, int indent, Object aElement) throws Exception {
        if (aElement instanceof StandardContext) {
            StoreDescription elementDesc =
                    getRegistry().findDescription(aElement.getClass().getName() + ".[WrapperLifecycle]");
            String[] listeners = ((StandardContext) aElement).findWrapperLifecycles();
            if (elementDesc != null) {
                if (log.isTraceEnabled()) {
                    log.trace("store " + elementDesc.getTag() + "( " + aElement + " )");
                }
                getStoreAppender().printTagArray(aWriter, "WrapperLifecycle", indent, listeners);
            }
        } else {
            log.warn(sm.getString("storeFactory.noDescriptor", aElement.getClass(), "WrapperLifecycle"));
        }
    }
}