package com.hust.historical.model;

import com.hust.utils.MyDate;
import de.vandermeer.asciitable.AsciiTable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dynasty extends HistoricalObject {
    private MyDate end;
    private String countryName;
    private String capital;
    private String language;
    private String religion;
    private String position;
    private String unit;
    private ArrayList<Human> humanArrayList;
    private ArrayList<Event> events;

    public Dynasty(String name, String countryName, MyDate start, MyDate end, String capital, String language, String religion, String position, String unit) {
        super(name, start);
        this.end = end;
        this.countryName = countryName;
        this.capital = capital;
        this.language = language;
        this.religion = religion;
        this.position = position;
        this.unit = unit;
        humanArrayList = new ArrayList<Human>();
        events = new ArrayList<Event>();
    }

    public ArrayList<Human> getHumanArrayList() {
        return humanArrayList;
    }
    public String getStrHuman() {
        StringBuilder str = new StringBuilder();
        for (Human human : humanArrayList) {
            str.append(human.getName()).append(", ");
        }
        return str.toString();
    }
    public String getStrEvent() {
        StringBuilder str = new StringBuilder();
        for (Event event : events) {
            str.append(event.getName()).append(", ");
        }
        return str.toString();
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public boolean addEvent(Event event) {
        if (events.contains(event))
            return false;
        events.add(event);
        return true;
    }

    public boolean removeEven(Event event) {
        return events.remove(event);
    }

    public Event findEven(String name) {
        for(Event e : events) {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }
    public boolean addHuman(Human human) {
        if (humanArrayList.contains(human))
            return false;
        humanArrayList.add(human);
        return true;
    }

    public boolean removeHuman(Human human) {
        return humanArrayList.remove(human);
    }

    public Human findHuman(String name) {
        for(Human human : humanArrayList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }

    @Override
    public String toString() {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Triều đại", "Bắt đầu", "Kết thúc", "Quốc gia", "Thủ đô", "Ngôn ngữ", "Tôn giáo", "Vị thế", "Đơn vị tiền tệ", "Nhân vật liên quan", "Sự kiện liên quan");
        at.addRule();
        at.addRow(super.getName(), super.getBirth().toString(), end.toString(), countryName, capital, language, religion, position, unit, getStrHuman(), getStrEvent());
        at.addRule();
        at.getContext().setWidth(150);
        return at.render();

    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("trieuDai", super.getName());
        jsonObject.put("batDau", super.getBirth().toString());
        jsonObject.put("ketThuc", end.toString());
        jsonObject.put("quocGia", countryName);
        jsonObject.put("thuDo", capital);
        jsonObject.put("ngonNgu", language);
        jsonObject.put("tonGiao", religion);
        jsonObject.put("viThe", position);
        jsonObject.put("donViTienTe", unit);
        StringBuilder relatedHumans = new StringBuilder();
        for (Human human : humanArrayList) {
            relatedHumans.append(human.getName()).append(", ");
        }
        jsonObject.put("nhanVat", relatedHumans);
        StringBuilder relatedEvents = new StringBuilder();
        for (Event event : events) {
            relatedEvents.append(event.getName()).append(", ");
        }
        jsonObject.put("suKienLienQuan", relatedEvents);
        return jsonObject;
    }
    @Override
    public void setToTimeLine() {

    }
}
