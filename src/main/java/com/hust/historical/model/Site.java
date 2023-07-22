package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONObject;

public class Site extends HistoricalObject {
    private String position;
    private String note;
    private String relatedHuman;

    public Site(String name, MyDate birth, String position, String note) {
        super(name, birth);
        this.position = position;
        this.note = note;
    }

    public void setRelatedHuman(String relatedHuman) {
        this.relatedHuman = relatedHuman;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("diTich", super.getName());
        jsonObject.put("namCN", super.getBirth().toString());
        jsonObject.put("viTri", position);
        jsonObject.put("ghiChu", note);
        jsonObject.put("nhanVatLienQuan", relatedHuman == null ? "" : relatedHuman);
        return jsonObject;
    }

    @Override
    public void setToTimeLine() {

    }
}
