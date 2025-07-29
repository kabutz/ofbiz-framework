/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ofbiz.entity.model;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.ofbiz.base.lang.ThreadSafe;
import org.apache.ofbiz.base.util.StringUtil;
import org.apache.ofbiz.base.util.UtilDateTime;
import org.apache.ofbiz.base.util.UtilXml;
import org.w3c.dom.Element;

/**
 * An object that models the <code>&lt;entitymodel&gt;</code> child elements that provide default values.
 *
 * @param title               The title for documentation purposes
 * @param description         The description for documentation purposes
 * @param copyright           The copyright for documentation purposes
 * @param author              The author for documentation purposes
 * @param version             The version for documentation purposes
 * @param defaultResourceName The default-resource-name of the Entity, used with the getResource call to check for a value in a resource bundle
 */
@ThreadSafe
// REFACTO: Replace simple data class with record
public record ModelInfo(String title, String description, String copyright,
                        String author, String version,
                        String defaultResourceName) {

    public static final ModelInfo DEFAULT = new ModelInfo("None", "None", getCopyrightString(), "None", "1.0", "");

    /**
     * Returns a new <code>ModelInfo</code> instance initialized to the values found in <code>element</code> attributes.
     *
     * @param defaultInfo A <code>ModelInfo</code> instance that will provide default values for missing attributes.
     * @param element
     */
    public static ModelInfo createFromAttributes(ModelInfo defaultInfo, Element element) {
        String title = element.getAttribute("title").intern();
        if (title.isEmpty()) {
            title = element.getAttribute("entity-name").intern();
        }
        String description = StringUtil.internString(UtilXml.childElementValue(element, "description"));
        if (description == null || description.isEmpty()) {
            description = defaultInfo.description();
        }
        String copyright = element.getAttribute("copyright").intern();
        if (copyright.isEmpty()) {
            copyright = defaultInfo.copyright();
        }
        String author = element.getAttribute("author").intern();
        if (author.isEmpty()) {
            author = defaultInfo.author();
        }
        String version = element.getAttribute("version").intern();
        if (version.isEmpty()) {
            version = defaultInfo.version();
        }
        String defaultResourceName = StringUtil.internString(element.getAttribute("default-resource-name"));
        if (defaultResourceName.isEmpty()) {
            defaultResourceName = defaultInfo.defaultResourceName();
        }
        return new ModelInfo(title, description, copyright, author, version, defaultResourceName);
    }

    /**
     * Returns a new <code>ModelInfo</code> instance initialized to the values found in <code>element</code> child elements.
     *
     * @param defaultInfo A <code>ModelInfo</code> instance that will provide default values for missing child elements.
     * @param element
     */
    public static ModelInfo createFromElements(ModelInfo defaultInfo, Element element) {
        String title = StringUtil.internString(UtilXml.childElementValue(element, "title"));
        if (title == null || title.isEmpty()) {
            title = defaultInfo.title();
        }
        String description = StringUtil.internString(UtilXml.childElementValue(element, "description"));
        if (description == null || description.isEmpty()) {
            description = defaultInfo.description();
        }
        String copyright = StringUtil.internString(UtilXml.childElementValue(element, "copyright"));
        if (copyright == null || copyright.isEmpty()) {
            copyright = defaultInfo.copyright();
        }
        String author = StringUtil.internString(UtilXml.childElementValue(element, "author"));
        if (author == null || author.isEmpty()) {
            author = defaultInfo.author();
        }
        String version = StringUtil.internString(UtilXml.childElementValue(element, "version"));
        if (version == null || version.isEmpty()) {
            version = defaultInfo.version();
        }
        String defaultResourceName = StringUtil.internString(UtilXml.childElementValue(element, "default-resource-name"));
        if (defaultResourceName == null || defaultResourceName.isEmpty()) {
            defaultResourceName = defaultInfo.defaultResourceName();
        }
        return new ModelInfo(title, description, copyright, author, version, defaultResourceName);
    }

    private static String getCopyrightString() {
        int year = UtilDateTime.getYear(UtilDateTime.nowTimestamp(), TimeZone.getDefault(), Locale.getDefault());
        return "Copyright 2001-" + year + " The Apache Software Foundation";
    }
}