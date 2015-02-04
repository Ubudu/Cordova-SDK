//
// Copyright (c) 2011-2015, UBUDU SAS
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer.
//
// * Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
//         SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//

package com.ubudu.cordova.sdk;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import com.ubudu.sdk.UbuduUser;

public class UbuduUserCordova implements UbuduUser {

    public UbuduUserCordova() {
        this.userId = null;
        this.tags = new ArrayList<String>();
        this.properties = new HashMap<String, String>();
    }

    public UbuduUserCordova(JSONObject jsonUserObject) {
        this();

        String userID = jsonUserObject.optString("userID");
        if (userID != null && !userID.isEmpty()) {
            this.userId = userID;
        }

        JSONObject jsonProperties = jsonUserObject.optJSONObject("properties");
        if (jsonProperties != null) {
            Iterator<?> keys = jsonProperties.keys();
            while (keys.hasNext()) {
                String propertyKey = (String)keys.next();
                String propertyValue = jsonProperties.optString(propertyKey);
                // Reject null properties, allow empty ones
                if (propertyValue != null) {
                    this.properties.put(propertyKey, (String)propertyValue);
                }
            }
        }

        JSONArray jsonTags = jsonUserObject.optJSONArray("tags");
        if (jsonTags != null) {
            for (int i = 0; i < jsonTags.length(); i++) {
                String tagValue = jsonTags.optString(i);
                // Reject empty tags
                if (tagValue != null && !tagValue.isEmpty()) {
                    this.tags.add(tagValue);
                }
            }

        }
    }

    public String userId() {
        return userId;
    }

    public Map<String, String> properties() {
        return properties;
    }

    public Collection<String> tags() {
        return tags;
    }

    private String userId;
    private HashMap<String, String> properties;
    private ArrayList<String> tags;

};