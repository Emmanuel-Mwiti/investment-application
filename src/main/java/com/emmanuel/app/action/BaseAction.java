package com.emmanuel.app.action;

import javax.servlet.http.HttpServlet;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by emmanuel on 11/6/23
 *
 * @author: emmanuel
 * @date: 11/6/23
 * @project: IntelliJ IDEA
 */
public class BaseAction extends HttpServlet {


    public void serializeForm(Object bean, Map<String, String[]> requestMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());

            for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
                String propertyName = descriptor.getName();
                String[] propertyValues = requestMap.get(propertyName);

                if (propertyValues != null && propertyValues.length > 0) {
                    Object propertyValue = convertToDesiredType(propertyValues[0], descriptor.getPropertyType());

                    descriptor.getWriteMethod().invoke(bean, propertyValue);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object convertToDesiredType(String value, Class<?> targetType) {
        if (targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == Long.class) {
            return Long.parseLong(value);
        }
        return value;
    }

}
