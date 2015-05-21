package ua.gerasimenko.data_structure;

import com.sun.xml.internal.bind.api.Bridge;
import com.sun.xml.internal.ws.api.model.CheckedException;
import com.sun.xml.internal.ws.api.model.ExceptionType;
import com.sun.xml.internal.ws.api.model.JavaMethod;
import com.sun.xml.internal.ws.api.model.SEIModel;

/**
 * Created by gleb on 21.05.15.
 */
public class NotFoundKeyException extends RuntimeException implements CheckedException {

    @Override
    public SEIModel getOwner() {
        return null;
    }

    @Override
    public JavaMethod getParent() {
        return null;
    }

    @Override
    public Class getExceptionClass() {
        return null;
    }

    @Override
    public Class getDetailBean() {
        return null;
    }

    @Override
    public Bridge getBridge() {
        return null;
    }

    @Override
    public ExceptionType getExceptionType() {
        return null;
    }

    @Override
    public String getMessageName() {
        return null;
    }

}
