package org.example.service.urltemplate;

public class PetServiceUrl {

    public static final UrlTemplate ADD_PET = new UrlTemplate("pet");
    public static final UrlTemplate PET_BY_ID = new UrlTemplate("pet/%s");
    public static final UrlTemplate PET_BY_STATUS = new UrlTemplate("pet/findByStatus?status=%s");
    public static final UrlTemplate DELETE_PET = new UrlTemplate("pet/%s");
}
