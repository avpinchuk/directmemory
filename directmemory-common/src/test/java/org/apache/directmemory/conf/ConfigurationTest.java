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

package org.apache.directmemory.conf;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConfigurationTest {

    @Test
    public void testBaseConfiguration() {
        assertTrue(Configuration.getNumberOfBuffers() > 0);
        assertTrue(Configuration.getInitialCapacity() > 0);
        assertTrue(Configuration.getRamMegaBytes() > 0);
        assertTrue(Configuration.getConcurrencyLevel() > 0);
        assertTrue(Configuration.getDisposalTime() > 0L);
    }

    @Test
    public void testYamlConfiguration() {
        Configuration.configureFromYaml();
        assertTrue(Configuration.getNumberOfBuffers() > 0);
        assertTrue(Configuration.getInitialCapacity() > 0);
        assertTrue(Configuration.getRamMegaBytes() > 0);
        assertTrue(Configuration.getConcurrencyLevel() > 0);
        assertTrue(Configuration.getDisposalTime() > 0L);
    }
}
