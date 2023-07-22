package com.hust.historical.model;

import com.hust.utils.MyDate;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Human extends HistoricalObject {
    private MyDate death;
    private String birthPlace;
    private String deathPlace;
    private String dynasty;

    public Human(String name, MyDate birth, MyDate death, String birthPlace, String deathPlace, String dynasty) {
        super(name, birth);
        this.death = death;
        this.birthPlace = birthPlace;
        this.deathPlace = deathPlace;
        this.dynasty = dynasty;
    }

    @Override
    public MyDate getBirth() {
        return super.getBirth();
    }

    public MyDate getDeath() {
        return death;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getDeathPlace() {
        return deathPlace;
    }
    public String getDynastyName() {
        return dynasty;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ten", super.getName());
        jsonObject.put("sinh", super.getBirth().toString());
        jsonObject.put("mat", death.toString());
        jsonObject.put("noiSinh", birthPlace);
        jsonObject.put("trieuDai", dynasty);
        jsonObject.put("noiMat", deathPlace);
        return jsonObject;
    }
    public abstract String getDynasty();
}
