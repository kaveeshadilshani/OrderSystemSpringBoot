package com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent;

import com.dfn.oms.newgen.testClientUI.bean.OMS.OMSTnsAbstractMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderApproveRequestBean extends OMSTnsAbstractMessage {

    @JsonProperty("DAT")
    private RequestBody body;

    public OrderApproveRequestBean() {
        body = new RequestBody();
    }

    @JsonIgnore
    public String getClOrdID() {
        return body.getClOrdID();
    }

    @JsonIgnore
    public void setClOrdID(String clOrdID) {
        body.setClOrdID(clOrdID);
    }

    @JsonIgnore
    public int getApprovedBy() {
        return body.getApprovedBy();
    }

    @JsonIgnore
    public void setApprovedBy(int approvedBy) {
        body.setApprovedBy(approvedBy);
    }

    @JsonIgnore
    public int getStatus() {
        return body.getStatus();
    }

    @JsonIgnore
    public void setStatus(int status) {
        body.setStatus(status);
    }

    @JsonIgnore
    public String getApproveRejectReason() {
        return body.getApproveRejectReason();
    }

    @JsonIgnore
    public void setApproveRejectReason(String approveRejectReason) {
        body.setApproveRejectReason(approveRejectReason);
    }

    public class RequestBody {
        @JsonProperty(value = "clOrdId")
        private String clOrdID;
        @JsonProperty(value = "approvedBy")
        private int approvedBy;
        @JsonProperty(value = "status")
        private int status;
        @JsonProperty(value = "approveRejectReason")
        private String approveRejectReason;

        public String getClOrdID() {
            return clOrdID;
        }

        public void setClOrdID(String clOrdID) {
            this.clOrdID = clOrdID;
        }

        public int getApprovedBy() {
            return approvedBy;
        }

        public void setApprovedBy(int approvedBy) {
            this.approvedBy = approvedBy;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getApproveRejectReason() {
            return approveRejectReason;
        }

        public void setApproveRejectReason(String approveRejectReason) {
            this.approveRejectReason = approveRejectReason;
        }

    }
}

