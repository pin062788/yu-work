/****************************************************************************
 *  Copyright (c) 2011 Alipay.com Inc, All rights reserved.
 *
 *  CONFIDENTIAL TRADE SECRET: THIS PRODUCT CONSISTS OF TRADE SECRETS
 *  AND COPYRIGHT MATERIAL THAT ARE THE PROPERTY OF Alipay TECHNOLOGY,
 *  THE CONTENTS MAY NOT BE DISCLOSED.
 *
 *  Source Code License:  LIMITED TO AUTHORIZED DEVELOPERS ONLY
 ****************************************************************************/
package yuweixiang.first.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * 一个{@link Errors}的实现，从{@link BindingResult}的实现中剥离出来
 * 去除了和绑定有关的接口，专注于做校验结果
 * 适用于非Web页面表单的对象校验，比如和银行的通信报文
 * </pre>
 * @author kun.zhouk
 * @version $Id: ValidationResult.java, v 0.1 2011-9-1 下午02:28:55 kun.zhouk Exp $
 */
public class ValidationResult extends AbstractErrors {

    /**  */
    private static final long           serialVersionUID = -4199061149434402935L;

    /**  */
    private final Object                target;

    /**  */
    private final String                objectName;

    /**  */
    private final List<ObjectError>     errors           = new LinkedList<ObjectError>();

    /**  */
    private transient final BeanWrapper beanWrapper;

    /**
     * @param target
     * @param objectName
     */
    public ValidationResult(Object target, String objectName) {
        super();
        this.target = target;
        this.objectName = objectName;
        // initialize beanWrapper
        this.beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(this.target);
        this.beanWrapper.setExtractOldValueForEditor(true);
    }

    //---------------------------------------------------------------------
    // Implementation of the Errors interface
    //---------------------------------------------------------------------

    public String getObjectName() {
        return this.objectName;
    }

    public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
        addError(new ObjectError(getObjectName(), new String[] { errorCode }, errorArgs,
            defaultMessage));
    }

    public void rejectValue(String field, String errorCode, Object[] errorArgs,
                            String defaultMessage) {
        if ("".equals(getNestedPath()) && !StringUtils.hasLength(field)) {
            // We're at the top of the nested object hierarchy,
            // so the present level is not a field but rather the top object.
            // The best we can do is register a global error here...
            reject(errorCode, errorArgs, defaultMessage);
            return;
        }
        String fixedField = fixedField(field);
        Object newVal = getActualFieldValue(fixedField);
        FieldError fe = new FieldError(getObjectName(), fixedField, newVal, false,
            new String[] { errorCode }, errorArgs, defaultMessage);
        addError(fe);
    }

    /**
     * 
     * @param error
     */
    public void addError(ObjectError error) {
        this.errors.add(error);
    }

    public void addAllErrors(Errors errors) {
        if (!errors.getObjectName().equals(getObjectName())) {
            throw new IllegalArgumentException("Errors object needs to have same object name");
        }
        this.errors.addAll(errors.getAllErrors());
    }

    @Override
    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    @Override
    public int getErrorCount() {
        return this.errors.size();
    }

    @Override
    public List<ObjectError> getAllErrors() {

        // 由于this.errors中的objecterror返回的errorCode形如TestingPerson.phone[mobilePhoneError]，不符合业务要求，应返回mobilePhoneError，
        // 故先做过滤操作：TestingPerson.phone[mobilePhoneError] ---> mobilePhoneError
        List<ObjectError> result = new LinkedList<ObjectError>();
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError error = it.next();
            error = new ObjectError(error.getObjectName(), filterCodes(error.getCodes()), error
                .getArguments(), error.getDefaultMessage());
            result.add(error);
        }

        return Collections.unmodifiableList(result);
    }

    public List<ObjectError> getGlobalErrors() {
        List<ObjectError> result = new LinkedList<ObjectError>();
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError error = it.next();
            if (!(error instanceof FieldError)) {
                // 过滤错误码
                error = new ObjectError(error.getObjectName(), filterCodes(error.getCodes()), error
                    .getArguments(), error.getDefaultMessage());
                result.add(error);
            }
        }
        return Collections.unmodifiableList(result);
    }

    @Override
    public ObjectError getGlobalError() {
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError objectError = it.next();
            if (!(objectError instanceof FieldError)) {
                // 过滤错误码
                objectError = new ObjectError(objectError.getObjectName(), filterCodes(objectError
                    .getCodes()), objectError.getArguments(), objectError.getDefaultMessage());
                return objectError;
            }
        }
        return null;
    }

    public List<FieldError> getFieldErrors() {
        List<FieldError> result = new LinkedList<FieldError>();
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError error = it.next();
            if (error instanceof FieldError) {
                // 过滤错误码
                FieldError fieldError = (FieldError) error;
                fieldError = new FieldError(fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getRejectedValue(), fieldError.isBindingFailure(),
                    filterCodes(fieldError.getCodes()), fieldError.getArguments(), fieldError
                        .getDefaultMessage());
                result.add(fieldError);
            }
        }
        return Collections.unmodifiableList(result);
    }

    @Override
    public FieldError getFieldError() {
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError error = it.next();
            if (error instanceof FieldError) {
                // 过滤错误码
                FieldError fieldError = (FieldError) error;
                fieldError = new FieldError(fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getRejectedValue(), fieldError.isBindingFailure(),
                    filterCodes(fieldError.getCodes()), fieldError.getArguments(), fieldError
                        .getDefaultMessage());
                return fieldError;
            }
        }
        return null;
    }

    @Override
    public List<FieldError> getFieldErrors(String field) {
        List<FieldError> result = new LinkedList<FieldError>();
        String fixedField = fixedField(field);
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            ObjectError error = it.next();
            if (error instanceof FieldError && isMatchingFieldError(fixedField, (FieldError) error)) {
                // 过滤错误码
                FieldError fieldError = (FieldError) error;
                fieldError = new FieldError(fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getRejectedValue(), fieldError.isBindingFailure(),
                    filterCodes(fieldError.getCodes()), fieldError.getArguments(), fieldError
                        .getDefaultMessage());
                result.add(fieldError);
            }
        }
        return Collections.unmodifiableList(result);
    }

    @Override
    public FieldError getFieldError(String field) {
        String fixedField = fixedField(field);
        for (Iterator<ObjectError> it = this.errors.iterator(); it.hasNext();) {
            Object error = it.next();
            if (error instanceof FieldError) {
                FieldError fe = (FieldError) error;
                if (isMatchingFieldError(fixedField, fe)) {
                    // 过滤错误码
                    fe = new FieldError(fe.getObjectName(), fe.getField(), fe.getRejectedValue(),
                        fe.isBindingFailure(), filterCodes(fe.getCodes()), fe.getArguments(), fe
                            .getDefaultMessage());
                    return fe;
                }
            }
        }
        return null;
    }

    public Object getFieldValue(String field) {
        FieldError fe = getFieldError(field);
        // Use rejected value in case of error, current bean property value
        // else.
        Object value = null;
        if (fe != null) {
            value = fe.getRejectedValue();
        } else {
            value = getActualFieldValue(fixedField(field));
        }
        return value;
    }

    /**
     * This default implementation determines the type based on the actual field
     * value, if any. Subclasses should override this to determine the type from
     * a descriptor, even for <code>null</code> values.
     * 
     * @see #getActualFieldValue
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class getFieldType(String field) {
        Object value = getActualFieldValue(fixedField(field));
        if (value != null) {
            return value.getClass();
        }
        return null;
    }

    /**
     * Extract the actual field value for the given field.
     * 
     * @param field
     *            the field to check
     * @return the current value of the field
     */
    protected Object getActualFieldValue(String field) {
        return this.beanWrapper.getPropertyValue(field);
    }

    /**
     * 过滤错误码，获取[]中用户所需信息
     * 形如：TestingPerson.phone[mobilePhoneError] ---> mobilePhoneError
     * @param codes
     * @return 字符串数组
     */
    private String[] filterCodes(String[] codes) {
        String[] newCodes = new String[codes.length];

        for (int i = 0; i < codes.length; i++) {
            int start = codes[i].indexOf("[");
            int end = codes[i].indexOf("]");
            newCodes[i] = codes[i].substring(start + 1, end);
        }

        return newCodes;
    }
}
