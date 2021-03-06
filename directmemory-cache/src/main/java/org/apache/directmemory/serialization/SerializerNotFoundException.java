/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.directmemory.serialization;

import static java.lang.String.format;

public final class SerializerNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 5095679349348496962L;

    public SerializerNotFoundException(String serializerClassName) {
        super(format("Serializer of type '%s' has not been found in the current ClassLoader", serializerClassName));
    }

    public SerializerNotFoundException(Class<?> serializerType) {
        this(serializerType.getName());
    }

}
