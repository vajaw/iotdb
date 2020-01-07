/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership.  The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at      http://www.apache.org/licenses/LICENSE-2.0  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 */

package org.apache.iotdb.cluster.log.common;

import java.io.IOException;
import org.apache.iotdb.cluster.client.ClientPool;
import org.apache.iotdb.cluster.client.MetaClient;
import org.apache.iotdb.cluster.rpc.thrift.Node;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TProtocolFactory;

public class TestMetaClient extends MetaClient {

  private Node node;

  protected TestMetaClient(TProtocolFactory protocolFactory,
      TAsyncClientManager clientManager,
      Node node, ClientPool pool)
      throws IOException {
    super(protocolFactory, clientManager, node, pool);
    this.node = node;
  }

  public Node getNode() {
    return node;
  }

  public void setNode(Node node) {
    this.node = node;
  }
}
