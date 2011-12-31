package org.apache.directmemory.memory;

import java.nio.ByteBuffer;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

public class Pointer
{
    public int start;

    public int end;

    public long created;

    public long expires;

    public long expiresIn;

    public long hits;

    public boolean free;

    public long lastHit;

    public int bufferNumber;

    public Class<? extends Object> clazz;

    public ByteBuffer directBuffer = null;

    public byte[] content()
    {
        return null;
    }

    public boolean expired()
    {
        if ( expires > 0 || expiresIn > 0 )
        {
            return ( expiresIn + created < System.currentTimeMillis() );
        }
        else
        {
            return false;
        }
    }

    public float getFrequency()
    {
        return (float) ( System.currentTimeMillis() - created ) / hits;
    }
}
