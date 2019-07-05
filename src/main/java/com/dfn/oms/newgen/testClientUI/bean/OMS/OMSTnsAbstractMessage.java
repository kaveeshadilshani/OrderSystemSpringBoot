package com.dfn.oms.newgen.testClientUI.bean.OMS;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class OMSTnsAbstractMessage implements OMSTnsMessageI {
    @JsonProperty("HED")
    protected OMSMsgHeader omsMsgHeader;


    public OMSTnsAbstractMessage() {
        omsMsgHeader = new OMSMsgHeader();
    }

    @Override
    public OMSMsgHeader getOmsMsgHeader() {
        return omsMsgHeader;
    }

    @Override
    public void setOmsMsgHeader(OMSMsgHeader omsMsgHeader) {
        this.omsMsgHeader = omsMsgHeader;
    }

}
