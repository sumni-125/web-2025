package tripMate.model;

import java.util.List;

public class TripData {
    private String sd_code;
    private String title;
    private List<MarkerData> markers;

    public String getSd_code() {
        return sd_code;
    }

    public void setSd_code(String sd_code) {
        this.sd_code = sd_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MarkerData> getMarkers() {
        return markers;
    }

    public void setMarkers(List<MarkerData> markers) {
        this.markers = markers;
    }
}
