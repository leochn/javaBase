package com.vnext.w15jdk8.stream;

/**
 * @author leo
 * @since 2018/2/28 8:46
 */
public class HistoryData {

    public HistoryData(){

    }

    private Float avgData;

    private String idService;

    private String dateTime;

    public Float getAvgData() {
        return avgData;
    }

    public void setAvgData(Float avgData) {
        this.avgData = avgData;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public HistoryData(Float avgData, String idService, String dateTime) {
        this.avgData = avgData;
        this.idService = idService;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "avgData=" + avgData +
                ", idService='" + idService + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryData that = (HistoryData) o;

        if (idService != null ? !idService.equals(that.idService) : that.idService != null) return false;
        return dateTime != null ? dateTime.equals(that.dateTime) : that.dateTime == null;
    }

    @Override
    public int hashCode() {
        int result = idService != null ? idService.hashCode() : 0;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
