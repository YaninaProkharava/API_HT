package org.example.service.urltemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UrlTemplate {
        private final String url;

        public String getUri() {
            return String.format(url, "");
        }

        public String getUri(Object... params) {
            return String.format(url, params);
        }
    }
