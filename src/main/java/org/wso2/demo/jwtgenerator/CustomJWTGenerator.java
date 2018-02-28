/*
 *
 *   Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 * /
 */

package org.wso2.demo.jwtgenerator;

import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.apimgt.impl.token.ClaimsRetriever;
import org.wso2.carbon.apimgt.keymgt.service.TokenValidationContext;
import org.wso2.carbon.apimgt.keymgt.token.JWTGenerator;
import org.wso2.carbon.um.ws.api.stub.RemoteAuthorizationManagerService;

import java.util.Map;

/**
 * Custom JWTGenerator, which reads the scope list from MessageContext and set it as a claim.
 */
public class CustomJWTGenerator extends JWTGenerator {

    @Override
    public Map<String, String> populateCustomClaims(TokenValidationContext validationContext)
            throws APIManagementException {
        Map<String, String> claims = super.populateCustomClaims(validationContext);

        claims.put(ClaimsRetriever.DEFAULT_DIALECT_URI + "/time", Long.toString(System.currentTimeMillis()));
        return claims;
    }
}
