package hw3.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;

/**
 * This class describes all necessary
 * methods for communications with
 * EPAM mobilecloud REST-API services
 */
public class MobileCloudApi {

    private static final String ROOT_PATH = "https://mobilecloud.epam.com/automation/api/";
    private static final String DEVICE = "device/";
    private static final String INSTALL = "storage/install/";

    private MobileCloudApi() {
    }

    private HashMap<String, String> params = new HashMap<>();
    private File appFile;

    // Builder-pattern for manipulations with mobile cloud
    public static class ApiBuilder {
        MobileCloudApi mobileCloudApi;

        private ApiBuilder(MobileCloudApi mobileCloudApi) {
            this.mobileCloudApi = mobileCloudApi;
        }

        // This method adds a serial number
        // as query parameter
        public ApiBuilder serial(String serialNumber) {
            mobileCloudApi.params.put("serial", serialNumber);
            return this;
        }

        // This method adds a file number
        // as query parameter
        public ApiBuilder file(File appFile) {
            mobileCloudApi.appFile = appFile;
            return this;
        }

        // This method prepares the needable
        // device for further manipulations with it
        public Response takeInUse(String serialId) {
            return RestAssured
                    .given(requestSpecification())
                    .with()
                    .log().all()
                    .post(ROOT_PATH + DEVICE + serialId).prettyPeek();
        }

        // This method install the file
        // on selected device
        public Response installApp(String serialId) {
            return RestAssured
                    .given(requestSpecification())
                    .with()
                    .queryParams(mobileCloudApi.params)
                    .multiPart("file", mobileCloudApi.appFile)
                    .contentType("multipart/form-data")
                    .log().all()
                    .post(ROOT_PATH + INSTALL + serialId).prettyPeek();
        }
    }

    public static ApiBuilder with() {
        MobileCloudApi mobileCloudApi = new MobileCloudApi();
        return new ApiBuilder(mobileCloudApi);
    }

    private static RequestSpecification requestSpecification() {
        String token = TokenReaderSingleton.getInstance().getProperty("token");
        return new RequestSpecBuilder()
                .setContentType("JSON")
                .setAccept("JSON")
                .setRelaxedHTTPSValidation()
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
