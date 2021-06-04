package com.meicai.ppblossom.theone.commons.enums;

public enum UriEnum {

    ///api/gw/dmall-api
    API_GW_DMALLAPI("/api/gw/dmall-api", "/api/gw/dmall-api");

    private String uri;
    private String message;

    UriEnum(String uri, String message) {
        this.uri = uri;
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public String getMessage() {
        return message;
    }

    public static boolean checkUri(String uri) {
        UriEnum[] uriEnums = values();
        for (UriEnum uriEnum : uriEnums) {
            if (uriEnum.uri.equals(uri)) {
                return true;
            }
        }
        return false;
    }

}
