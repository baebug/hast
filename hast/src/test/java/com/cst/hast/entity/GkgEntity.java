package com.cst.hast.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gkg", schema = "hast", catalog = "")
public class GkgEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "gkg_id")
    private long gkgId;
    @Basic
    @Column(name = "world_id")
    private long worldId;
    @Basic
    @Column(name = "gkg_code")
    private String gkgCode;
    @Basic
    @Column(name = "gkg_theme")
    private Integer gkgTheme;
    @Basic
    @Column(name = "gkg_url")
    private String gkgUrl;
    @Basic
    @Column(name = "Field")
    private String field;
    @Basic
    @Column(name = "Field2")
    private String field2;
    @Basic
    @Column(name = "Field3")
    private String field3;

    public long getGkgId() {
        return gkgId;
    }

    public void setGkgId(long gkgId) {
        this.gkgId = gkgId;
    }

    public long getWorldId() {
        return worldId;
    }

    public void setWorldId(long worldId) {
        this.worldId = worldId;
    }

    public String getGkgCode() {
        return gkgCode;
    }

    public void setGkgCode(String gkgCode) {
        this.gkgCode = gkgCode;
    }

    public Integer getGkgTheme() {
        return gkgTheme;
    }

    public void setGkgTheme(Integer gkgTheme) {
        this.gkgTheme = gkgTheme;
    }

    public String getGkgUrl() {
        return gkgUrl;
    }

    public void setGkgUrl(String gkgUrl) {
        this.gkgUrl = gkgUrl;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GkgEntity gkgEntity = (GkgEntity) o;
        return gkgId == gkgEntity.gkgId && worldId == gkgEntity.worldId && Objects.equals(gkgCode, gkgEntity.gkgCode) && Objects.equals(gkgTheme, gkgEntity.gkgTheme) && Objects.equals(gkgUrl, gkgEntity.gkgUrl) && Objects.equals(field, gkgEntity.field) && Objects.equals(field2, gkgEntity.field2) && Objects.equals(field3, gkgEntity.field3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gkgId, worldId, gkgCode, gkgTheme, gkgUrl, field, field2, field3);
    }
}
