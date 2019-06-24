package com.dfn.oms.newgen.testClientUI.bean;

public class StatGatherBean_InternalTmp {
    private String requestID;
    private String groupID;
    private long startTime;
    private long endTime;
    //    private int currentIteration=1;
//    private int status;
//    private String captureTime;
//    private String inputParams;
    private boolean requestSkip = false;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public StatGatherBean_InternalTmp(String groupID) {
        this.groupID = groupID;
    }

//    public StatGatherBean requestID(String requestID){
//        this.requestID=requestID;
//        return this;
//    }

   /* public StatGatherBean currentIteration(int currentIteration){
        this.currentIteration=currentIteration;
        return this;
    }*/

    public StatGatherBean_InternalTmp startTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
//        this.captureTime= DateUtils.getCurrentDate(DateUtils.DATE_PATTERN_YYYY_MM_DD_HH_MM_SS_SSS);
    }

 /*   public int getCurrentIteration() {
        return currentIteration;
    }

    public void setCurrentIteration(int currentIteration) {
        this.currentIteration = currentIteration;
    }
*/
//    public int getOrdStatus() {
//        return status;
//    }

//    public void setStatus(int status) {
//        this.status = status;
//    }

//    public String getInputParams() {
//        return inputParams;
//    }
//
//    public void setInputParams(String inputParams) {
//        this.inputParams = inputParams;
//    }

    public boolean isRequestSkip() {
        return requestSkip;
    }

    public void setRequestSkip(boolean requestSkip) {
        this.requestSkip = requestSkip;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("ITERATION:").append(currentIteration);
        stringBuilder.append(",REQUEST:").append(requestID);
//        stringBuilder.append(",CaptureTime:").append(captureTime);
        stringBuilder.append(",START:").append(startTime);
        stringBuilder.append(",END:").append(endTime);
        stringBuilder.append(",DUE:").append((endTime - startTime));
//        stringBuilder.append(",STATUS:").append(status);
        return stringBuilder.toString();
    }

//    public String getCaptureTime() {
//        return captureTime;
//    }
}
