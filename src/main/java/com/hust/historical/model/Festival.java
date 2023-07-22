package com.hust.historical.model;

import org.json.JSONObject;

public class Festival extends HistoricalObject {
    private String position;
    private String note;
    private String firsTime;
    private Human human;
    private String dateStart;

    public Festival(String name) {
        super(name);
    }
    public Festival(String name, String note, String firsTime, String position, Human human, String dateStart) {
        super(name);
        this.position = position;
        this.note = note;
        this.firsTime = firsTime;
        this.human = human;
        this.dateStart = dateStart;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ten", super.getName());
        jsonObject.put("ghiChu", note);
        jsonObject.put("viTri", position);
        jsonObject.put("lanDauToChuc", firsTime);
        jsonObject.put("ngayBatDau", dateStart);
        jsonObject.put("nhanVatLienQuan", human == null ? "" : human.getName());
        return jsonObject;
    }

    @Override
    public void setToTimeLine() {

    }
}
