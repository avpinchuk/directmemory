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

package org.apache.directmemory.server.client.providers.asynchttpclient;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.Response;
import org.apache.directmemory.server.client.AbstractDirectMemoryHttpClient;
import org.apache.directmemory.server.commons.DirectMemoryRequest;
import org.apache.directmemory.server.commons.DirectMemoryResponse;

/**
 * @author Olivier Lamy
 */
public class DirectMemoryGetHandler extends AsyncCompletionHandler<DirectMemoryResponse> {

    private DirectMemoryRequest request;

    public DirectMemoryGetHandler(DirectMemoryRequest request) {
        this.request = request;
    }

    @Override
    public DirectMemoryResponse onCompleted(Response response) throws Exception {
        int statusCode = response.getStatusCode();
        // handle no content response
        if (statusCode == 204) {
            return new DirectMemoryResponse().setFound(false);
        }
        if (request.isDeleteRequest()) {
            return new DirectMemoryResponse().setFound(true).setDeleted(true);
        }
        return AbstractDirectMemoryHttpClient.buildResponse(response.getResponseBodyAsStream(), request).setFound(true);
    }
}
