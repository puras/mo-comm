package me.puras.mo.common.controller;

import me.puras.mo.common.pagination.Pagination;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 所有需要分页功能的Controller都要继承此类，此类会自动生成一个Pagination类型的ModelAttribute，并且根据请求的URL设置其url属性。
 * 子类需要在Handler方法里加入Pagination参数，然后在方法中调用Pagination.setTotalCount()设置总记录数。
 * @author puras <he@puras.me>
 * @since 16/1/14  上午11:17
 */
public abstract class PaginationController {
    @ModelAttribute("pagination")
    public Pagination pagination(Pagination pagination, HttpServletRequest httpServletRequest) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        String uri = httpServletRequest.getRequestURI();
        uri = customizeUri(uri);
        StringBuilder sb = new StringBuilder(uri);
        boolean isFirstParam = true;
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String name = entry.getKey();
            if (Pagination.PARAM_NAME_CURRENT_PAGE.equals(name) || Pagination.PARAM_NAME_PAGE_SIZE.equals(name)
                    || Pagination.PARAM_NAME_TOTAL_COUNT.equals(name)) {
                continue;
            }
            sb.append(isFirstParam ? "?" : "&").append(name).append('=');
            if (isFirstParam) {
                isFirstParam = false;
            }
            boolean isFirstValue = true;
            for (String value : entry.getValue()) {
                try {
                    if (!isFirstValue) {
                        sb.append(',');
                    } else {
                        isFirstValue = false;
                    }
                    sb.append(URLEncoder.encode(value, "UTF-8"));

                } catch (UnsupportedEncodingException ignore) {
                }
            }
        }
        pagination.setUrl(sb.toString());
        return pagination;
    }

    protected abstract String customizeUri(String uri);

}
