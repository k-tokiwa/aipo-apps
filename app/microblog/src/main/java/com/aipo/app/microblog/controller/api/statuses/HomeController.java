/*
 * This file is part of official Aipo App.
 * Copyright (C) 2011-2011 Aimluck,Inc.
 * http://www.aipo.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.aipo.app.microblog.controller.api.statuses;

import java.util.Map;

import org.slim3.util.IntegerUtil;
import org.slim3.util.LongUtil;
import org.slim3.util.StringUtil;

import com.aipo.app.microblog.controller.JSONController;
import com.aipo.app.microblog.service.MessageService;
import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class HomeController extends JSONController {

  /**
   * @return
   * @throws Exception
   */
  @Override
  protected Map<String, Object> execute() throws Exception {
    MessageService messageService = MessageService.get();
    Map<String, Object> result = Maps.newHashMap();

    String cursor = request.getParameter("start");
    if (StringUtil.isEmpty(cursor)) {
      cursor = null;
    }

    Integer count = null;
    try {
      count = IntegerUtil.toInteger(request.getParameter("count"));
    } catch (Throwable ignore) {
      // ignore
    }

    Long id = null;

    try {
      id = LongUtil.toLong(request.getParameter("id"));
    } catch (Throwable ignore) {
      // ignore
    }

    result.put("data", messageService.fetchData(cursor, id, count));

    return result;
  }
}
