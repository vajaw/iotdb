/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iotdb.db.mpp.sql.planner.plan.node.write;

import org.apache.iotdb.db.mpp.sql.analyze.Analysis;
import org.apache.iotdb.db.mpp.sql.planner.plan.node.PlanNode;
import org.apache.iotdb.db.mpp.sql.planner.plan.node.PlanNodeId;
import org.apache.iotdb.tsfile.utils.BitMap;

import java.util.List;

public class InsertTabletNode extends InsertNode {

  private long[] times; // times should be sorted. It is done in the session API.

  private BitMap[] bitMaps;
  private Object[] columns;

  private int start;
  private int end;
  // when this plan is sub-plan split from another InsertTabletPlan, this indicates the original
  // positions of values in
  // this plan. For example, if the plan contains 5 timestamps, and range = [1,4,10,12], then it
  // means that the first 3
  // timestamps in this plan are from range[1,4) of the parent plan, and the last 2 timestamps are
  // from range[10,12)
  // of the parent plan.
  // this is usually used to back-propagate exceptions to the parent plan without losing their
  // proper positions.
  private List<Integer> range;

  public InsertTabletNode(PlanNodeId id) {
    super(id);
  }

  @Override
  public List<PlanNode> getChildren() {
    return null;
  }

  @Override
  public PlanNode clone() {
    return null;
  }

  @Override
  public PlanNode cloneWithChildren(List<PlanNode> children) {
    return null;
  }

  @Override
  public List<String> getOutputColumnNames() {
    return null;
  }

  @Override
  public List<InsertNode> splitByPartition(Analysis analysis) {
    return null;
  }

  public int getRowCount() {
    return times.length;
  }

  public long[] getTimes() {
    return times;
  }

  public Object[] getColumns() {
    return columns;
  }

  public BitMap[] getBitMaps() {
    return bitMaps;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }
}
