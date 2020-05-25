package builders;

import io.restassured.specification.RequestSpecification;

public class DatasetRequestBuilder {

    private RequestSpecification requestSpecification;

    public DatasetRequestBuilder(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public DatasetRequestBuilder apiKey(String key) {
        requestSpecification.queryParams("api_key", key);
        return this;
    }

    public DatasetRequestBuilder sol(int sol) {
        requestSpecification.queryParams("sol", sol);
        return this;
    }

    public DatasetRequestBuilder imgSrc(String img_src) {
        requestSpecification.queryParams("img_src", img_src);
        return this;
    }

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
