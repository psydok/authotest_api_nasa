package builders;

import io.restassured.specification.RequestSpecification;

public class DatasetRequestBuilder {

    private RequestSpecification requestSpecification;

    public DatasetRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Марсианский золь миссии Ровера
     */
    public DatasetRequestBuilder sol(int sol) {
        requestSpecification.queryParams("sol", sol);
        return this;
    }

    /**
     * Вводить аббревиатурой.
     * Пример: FHAZ, RHAZ, MAST
     */
    public DatasetRequestBuilder camera(String camera) {
        requestSpecification.queryParams("camera", camera);
        return this;
    }

    public DatasetRequestBuilder page(int page) {
        requestSpecification.queryParams("page", page);
        return this;
    }

    /**
     * Формат: YYYY-MM-DD
     */
    public DatasetRequestBuilder earthDate(String earth_date) {
        requestSpecification.queryParams("earth_date", earth_date);
        return this;
    }

    public DatasetRequestBuilder getFields(String... fields) {
        requestSpecification.body(fields);
        return this;
    }

    public RequestSpecification build() {
        return requestSpecification;
    }


}
