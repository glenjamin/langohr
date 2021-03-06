// Copyright (c) 2011-2020 Michael S. Klishin
//
// The use and distribution terms for this software are covered by the
// Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
// which can be found in the file epl-v10.html at the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by
// the terms of this license.
// You must not remove this notice, or any other, from this software.

package com.novemberain.langohr.queue;

import clojure.lang.IPersistentMap;
import clojure.lang.Keyword;
import clojure.lang.PersistentHashMap;
import clojure.lang.RT;
import com.novemberain.langohr.PersistentMapLike;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.Map;

public class DeclareOk extends PersistentMapLike implements AMQP.Queue.DeclareOk {
  private final AMQP.Queue.DeclareOk method;

  public DeclareOk(AMQP.Queue.DeclareOk method) {
    this.method = method;

    this.map = mapFrom(method);

  }

  public static IPersistentMap mapFrom(AMQP.Queue.DeclareOk method) {
    Map<Keyword, Object> m = new HashMap<Keyword, Object>();
    m.put(RT.keyword(null, "queue"), method.getQueue());
    m.put(RT.keyword(null, "message-count"), method.getMessageCount());
    m.put(RT.keyword(null, "consumer-count"), method.getConsumerCount());
    m.put(RT.keyword(null, "message_count"), method.getMessageCount());
    m.put(RT.keyword(null, "consumer_count"), method.getConsumerCount());

    return PersistentHashMap.create(m);
  }

  public int getConsumerCount() {
    return method.getConsumerCount();
  }

  public int getMessageCount() {
    return method.getMessageCount();
  }

  public String getQueue() {
    return method.getQueue();
  }

  public int protocolClassId() {
    return method.protocolClassId();
  }

  public int protocolMethodId() {
    return method.protocolMethodId();
  }

  public String protocolMethodName() {
    return method.protocolMethodName();
  }
}
