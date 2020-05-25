package services;

import builders.DatasetRequestBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.DatasetModel;

import java.util.Properties;

public class DatasetsService extends BaseService {
    private static final String ENDPOINT = "photos";

    public DatasetsService(Properties properties) {
        super(properties);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetModel getDatasets(RequestSpecification requestSpecification) {
        return executeGetDatasets(requestSpecification).then()
                .extract()
                .body().as(DatasetModel.class);
    }

    public Response executeGetDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.get(ENDPOINT);
    }
}
