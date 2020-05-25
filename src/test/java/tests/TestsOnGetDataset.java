package tests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.DatasetModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import services.DatasetsService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestsOnGetDataset extends BaseTest {

    @Test(groups = "positiveTest")
    public void dataProjectionQuery() {
        DatasetsService datasetsService = new DatasetsService(properties);
        checkDataPosProjectionQuery(datasetsService,"photos");
    }

    @Test(groups = "negativeTest")
    public void dataNegativeProjectionQuery() {
        DatasetsService datasetsService = new DatasetsService(properties);
        checkDataNegProjectionQuery(datasetsService);
    }

    private void checkDataPosProjectionQuery(DatasetsService datasetsService, String... fields) {
        int valueSol = 1000;

        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .sol(valueSol)
                .apiKey("TTkL1PixNcZg2juw04NRwY0bBtPKxh3DhKMRUzPd")
                .getFields(fields)
                .build();
        ValidatableResponse response = datasetsService.executeGetDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("size()", notNullValue());

        response.statusCode(HttpStatus.SC_OK);

    }

    private void checkDataNegProjectionQuery(DatasetsService datasetsService, String... fields) {
        RequestSpecification requestSpecification = datasetsService.requestBuilder()
                .sol(1000)
                .getFields(fields)
                .build();
        ValidatableResponse response = datasetsService.executeGetDatasets(requestSpecification)
                .then()
                .assertThat()
                .body("error.code", containsString("API_KEY_MISSING"));

        response.statusCode(HttpStatus.SC_FORBIDDEN);
    }


//    @Test(groups = "models")
//    public void getDatasetId() {
//        DatasetsService datasetsService = new DatasetsService(properties);
//        RequestSpecification requestSpecification = datasetsService.requestBuilder()
//                .sol(1001)
//                .apiKey("TTkL1PixNcZg2juw04NRwY0bBtPKxh3DhKMRUzPd")
//                .build();
//        DatasetModel datasets = datasetsService.getDatasets(requestSpecification);
//        for (DatasetModel dataset : datasets) {
//            assertThat(dataset.getImgSrc(), containsString("img_src"));
//        }
//    }
}
