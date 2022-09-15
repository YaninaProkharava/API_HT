package org.example.service;

import io.restassured.response.Response;
import org.example.service.urltemplate.UrlTemplate;

public class PetService extends CommonService {

    private static PetService instance;

    public static PetService getInstance() {
        if (instance == null) {
            instance = new PetService();
        }
        return instance;
    }

    public Response getRequest(UrlTemplate uri, long id) {
        return super.getRequest(uri.getUri(id));
    }

    public Response getRequest(UrlTemplate uri, String status){
        return super.getRequest(uri.getUri(status));
    }

    public Response postRequest(UrlTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public void deleteRequest(UrlTemplate uri, long id) {
        super.deleteRequest(uri.getUri(id));
    }
}
