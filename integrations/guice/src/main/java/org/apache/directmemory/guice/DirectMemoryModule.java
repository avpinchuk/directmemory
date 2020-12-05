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

package org.apache.directmemory.guice;

import static com.google.inject.Scopes.SINGLETON;

import org.apache.directmemory.cache.CacheService;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public final class DirectMemoryModule<K, V> extends AbstractModule {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure() {
        bind(new TypeLiteral<CacheService<K, V>>() {}).toProvider(new CacheServiceProvider<K, V>()).in(SINGLETON);
    }
}
