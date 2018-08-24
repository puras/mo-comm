package me.puras.mo.common.json;

/**
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:16
 */
public class Response <T> {

    private int code;
    private String description = "";
    private Long lastUpdateTime = 0l;
    private T payload;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Response [code=" + code + ", description=" + description
                + ", lastUpdateTime=" + lastUpdateTime + ", payload=" + payload
                + "]";
    }
}
