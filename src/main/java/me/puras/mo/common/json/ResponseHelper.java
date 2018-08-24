package me.puras.mo.common.json;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:16
 */
public class ResponseHelper {
    public static <T> Response<T> createSuccessResponse() {
        return createResponse(ReturnCode.SUCCESS, null);
    }

    public static <T> Response<T> createSuccessResponse(T payload) {
        Response<T> response = createResponse(ReturnCode.SUCCESS, null);
        response.setPayload(payload);
        return response;
    }


    public static <T> Response<T> createResponse() {
        return createResponse(ReturnCode.NEVER_USED_CODE, null);
    }

    public static <T> Response<T> createResponse(int code, String description) {
        Response<T> response = new Response<>();
        if (code != ReturnCode.NEVER_USED_CODE) response.setCode(code);
        if (description != null) response.setDescription(description);
        return response;
    }

    public static <T> Response<T> createResponse(int code, long lastUpdateTime) {
        Response<T> response = new Response<T>();
        if (code != ReturnCode.NEVER_USED_CODE) response.setCode(code);
        response.setLastUpdateTime(lastUpdateTime);
        return response;
    }

    public static <T> Response<T> createBusinessErrorResponse(String description) {
        return createResponse(ReturnCode.BUSINESS_ERROR, description);
    }

    public static <T> Response<T> createExceptionResponse(Exception e) {
        return createResponse(ReturnCode.EXCEPTION, e.getMessage());
    }

    public static <T> Response<T> createBindErrorResponse(String description) {
        return createResponse(ReturnCode.BIND_ERROR, description);
    }

    public static <T> Response<T> createNotFoundErrorResponse() {
        return createResponse(ReturnCode.NOT_FOUND, "Data not found!");
    }

    public static <T> Response<T> createParameterErrorResponse() {
        return createResponse(ReturnCode.PARAM_ERROR, "Error parameter!");
    }

    public static <T> Response<T> createRemoteCallErrorResponse() {
        return createResponse(ReturnCode.REMOTE_CALL_ERROR, "Remote call error!");
    }
}
