package com.cst.hast.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CopyOfinfo", schema = "hast", catalog = "")
public class CopyOfinfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "world_id")
    private long worldId;
    @Basic
    @Column(name = "info_name")
    private String infoName;
    @Basic
    @Column(name = "info_capital")
    private String infoCapital;
    @Basic
    @Column(name = "info_money")
    private String infoMoney;
    @Basic
    @Column(name = "info_size")
    private String infoSize;
    @Basic
    @Column(name = "info_popul")
    private int infoPopul;

    public long getWorldId() {
        return worldId;
    }

    public void setWorldId(long worldId) {
        this.worldId = worldId;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getInfoCapital() {
        return infoCapital;
    }

    public void setInfoCapital(String infoCapital) {
        this.infoCapital = infoCapital;
    }

    public String getInfoMoney() {
        return infoMoney;
    }

    public void setInfoMoney(String infoMoney) {
        this.infoMoney = infoMoney;
    }

    public String getInfoSize() {
        return infoSize;
    }

    public void setInfoSize(String infoSize) {
        this.infoSize = infoSize;
    }

    public int getInfoPopul() {
        return infoPopul;
    }

    public void setInfoPopul(int infoPopul) {
        this.infoPopul = infoPopul;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopyOfinfoEntity that = (CopyOfinfoEntity) o;
        return worldId == that.worldId && infoPopul == that.infoPopul && Objects.equals(infoName, that.infoName) && Objects.equals(infoCapital, that.infoCapital) && Objects.equals(infoMoney, that.infoMoney) && Objects.equals(infoSize, that.infoSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worldId, infoName, infoCapital, infoMoney, infoSize, infoPopul);
    }
}
