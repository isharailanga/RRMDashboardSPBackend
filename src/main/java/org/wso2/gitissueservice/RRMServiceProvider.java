/*
 * Copyright (c) 2019, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.gitissueservice;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is do the http actions to retrieve the data from ballerina backend
 **/
public class RRMServiceProvider {
    private static final String HOST_URL = "http://localhost:9095/gitIssues/";


    public Object retrieveIssuesFromRepoByLabel(String labels, String repos) throws IOException, URISyntaxException {

        String response;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            URIBuilder uriBuilder = new URIBuilder(HOST_URL + "repository/label");
            uriBuilder.addParameter("labels", labels);
            uriBuilder.addParameter("repos", repos);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                response = EntityUtils.toString(response1.getEntity(), "UTF-8");
            }
        }
        return response;
    }

    public Object retrieveIssuesFromProduct(String product, String labels) throws IOException, URISyntaxException {

        String response;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            URI uri = new URI(HOST_URL + "product/" + product.replace(" ", "%20"));

            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.addParameter("labels", labels);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                HttpEntity entity1 = response1.getEntity();
                response = EntityUtils.toString(entity1, "UTF-8");
            }
        }
        return response;
    }

    public Object retrieveRepoNamesByProduct(String product) throws IOException, URISyntaxException {

        String response;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            URI uri = new URI(HOST_URL + "repos/");

            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.addParameter("product", product);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                HttpEntity entity1 = response1.getEntity();
                response = EntityUtils.toString(entity1, "UTF-8");
            }
        }
        return response;
    }


    public Object retrieveProductNames() throws IOException, URISyntaxException {
        String response;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            URI uri = new URI(HOST_URL + "products/");

            URIBuilder uriBuilder = new URIBuilder(uri);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                HttpEntity entity1 = response1.getEntity();
                response = EntityUtils.toString(entity1, "UTF-8");
            }
        }
        return response;
    }
}
