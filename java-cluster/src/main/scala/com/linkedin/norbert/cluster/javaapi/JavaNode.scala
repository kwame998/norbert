/*
 * Copyright 2009-2010 LinkedIn, Inc
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
package com.linkedin.norbert.cluster.javaapi

import reflect.BeanProperty

object JavaNode {
  def apply(node: com.linkedin.norbert.cluster.Node): Node = {
    if (node == null) {
      null
    } else {
      var s = new java.util.HashSet[Integer]
      if (node.partitions != null) {
        node.partitions.foreach {id => s.add(id.asInstanceOf[java.lang.Integer])}
      }
      JavaNode(node.id, node.url, s, node.available)
    }
  }
}

case class JavaNode(@BeanProperty id: Int, @BeanProperty url: String, @BeanProperty partitions: java.util.Set[java.lang.Integer],
        @BeanProperty available: Boolean) extends Node
