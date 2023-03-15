package com.cst.hast.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "hast", catalog = "")
public class EventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "event_id")
    private long eventId;
    @Basic
    @Column(name = "world_id")
    private long worldId;
    @Basic
    @Column(name = "event_code")
    private String eventCode;
    @Basic
    @Column(name = "event_class")
    private Integer eventClass;
    @Basic
    @Column(name = "event_gold")
    private Double eventGold;
    @Basic
    @Column(name = "event_ton")
    private Integer eventTon;
    @Basic
    @Column(name = "event_url")
    private String eventUrl;
    @Basic
    @Column(name = "event_latitude")
    private String eventLatitude;
    @Basic
    @Column(name = "event_longtitude")
    private String eventLongtitude;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getWorldId() {
        return worldId;
    }

    public void setWorldId(long worldId) {
        this.worldId = worldId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Integer getEventClass() {
        return eventClass;
    }

    public void setEventClass(Integer eventClass) {
        this.eventClass = eventClass;
    }

    public Double getEventGold() {
        return eventGold;
    }

    public void setEventGold(Double eventGold) {
        this.eventGold = eventGold;
    }

    public Integer getEventTon() {
        return eventTon;
    }

    public void setEventTon(Integer eventTon) {
        this.eventTon = eventTon;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getEventLatitude() {
        return eventLatitude;
    }

    public void setEventLatitude(String eventLatitude) {
        this.eventLatitude = eventLatitude;
    }

    public String getEventLongtitude() {
        return eventLongtitude;
    }

    public void setEventLongtitude(String eventLongtitude) {
        this.eventLongtitude = eventLongtitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return eventId == that.eventId && worldId == that.worldId && Objects.equals(eventCode, that.eventCode) && Objects.equals(eventClass, that.eventClass) && Objects.equals(eventGold, that.eventGold) && Objects.equals(eventTon, that.eventTon) && Objects.equals(eventUrl, that.eventUrl) && Objects.equals(eventLatitude, that.eventLatitude) && Objects.equals(eventLongtitude, that.eventLongtitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, worldId, eventCode, eventClass, eventGold, eventTon, eventUrl, eventLatitude, eventLongtitude);
    }
}
