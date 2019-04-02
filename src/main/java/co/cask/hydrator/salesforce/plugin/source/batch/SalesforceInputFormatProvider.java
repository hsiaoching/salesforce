/*
 * Copyright © 2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.hydrator.salesforce.plugin.source.batch;

import co.cask.cdap.api.data.batch.InputFormatProvider;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * InputFormatProvider used by cdap to provide configurations to mapreduce job
 */
public class SalesforceInputFormatProvider implements InputFormatProvider {
  private final Map<String, String> conf;

  SalesforceInputFormatProvider(SalesforceBatchSource.Config config) {
    this.conf = new ImmutableMap.Builder<String, String>()
    .put(SalesforceConstants.USERNAME, config.getUsername())
    .put(SalesforceConstants.PASSWORD, config.getPassword())
    .put(SalesforceConstants.CLIENT_ID, config.getClientId())
    .put(SalesforceConstants.CLIENT_SECRET, config.getClientSecret())
    .put(SalesforceConstants.QUERY, config.getQuery())
    .put(SalesforceConstants.LOGIN_URL, config.getLoginUrl())
    .put(SalesforceConstants.ERROR_HANDLING, config.getErrorHandling()).build();
  }

  @Override
  public String getInputFormatClassName() {
    return SalesforceInputFormat.class.getName();
  }

  @Override
  public Map<String, String> getInputFormatConfiguration() {
    return conf;
  }
}