package services;

import builders.DatasetRequestBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.DatasetModel;

import java.util.Properties;

public class DatasetsService extends BaseService {
    private static final String ENDPOINT = "/mars-photos/api/v1/rovers/curiosity/photos";

    public DatasetsService(Properties properties) {
        super(properties, false);
    }

    public DatasetsService(Properties properties, boolean isNegativeTest) {
        super(properties, isNegativeTest);
    }

    public DatasetRequestBuilder requestBuilder() {
        return new DatasetRequestBuilder(baseRequest());
    }

    public DatasetModel getDataset(RequestSpecification requestSpecification) {
        return executeGetDatasets(requestSpecification).then()
                .extract()
                .body().as(DatasetModel.class);
    }

    public Response executeGetDatasets(RequestSpecification requestSpecification) {
        return requestSpecification.get(ENDPOINT);
    }
}
