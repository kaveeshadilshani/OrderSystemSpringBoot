package com.dfn.oms.newgen.testClientUI.bean;

public class OMSCoreRuntimeException extends RuntimeException {
    private ErrorCodesI errorCodes = ErrorCodes.ERROR_DEFAULT;
    private boolean sessionRollBack = true;
    private String[] params;

    public OMSCoreRuntimeException(String message, Exception e) {
        super(message, e);
    }

    public OMSCoreRuntimeException(String message, Exception e, boolean sessionRollBack) {
        super(message, e);
        this.sessionRollBack = sessionRollBack;
    }

    public OMSCoreRuntimeException(ErrorCodesI errorCodes, String message, Exception e) {
        super(message, e);
        this.errorCodes = errorCodes;
    }

    public OMSCoreRuntimeException(ErrorCodesI errorCodes, String message, Exception e, boolean sessionRollBack) {
        super(message, e);
        this.errorCodes = errorCodes;
        this.sessionRollBack = sessionRollBack;
    }

    public OMSCoreRuntimeException(ErrorCodesI errorCodes, String message) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public OMSCoreRuntimeException(ErrorCodesI errorCodes, String message, boolean sessionRollBack) {
        super(message);
        this.errorCodes = errorCodes;
        this.sessionRollBack = sessionRollBack;
    }

    public OMSCoreRuntimeException(String message) {
        super(message);
    }

    public OMSCoreRuntimeException(String message, String[] params) {
        super(message);
        this.params = params;

    }

    public OMSCoreRuntimeException(String message, boolean sessionRollBack) {
        super(message);
        this.sessionRollBack = sessionRollBack;
    }

    public OMSCoreRuntimeException(Exception e, boolean sessionRollBack) {
        super(e);
        this.sessionRollBack = sessionRollBack;
    }

    public OMSCoreRuntimeException(ErrorCodesI errorCodes, boolean sessionRollBack) {
        super(errorCodes.getDescription());
        this.errorCodes = errorCodes;
        this.sessionRollBack = sessionRollBack;
    }

    public ErrorCodesI getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodesI errorCodes) {
        this.errorCodes = errorCodes;
    }

    public boolean isSessionRollBack() {
        return sessionRollBack;
    }

    public void setSessionRollBack(boolean sessionRollBack) {
        this.sessionRollBack = sessionRollBack;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

//    @Override
//    public Throwable fillInStackTrace() {
//        return this;
//    }
}
