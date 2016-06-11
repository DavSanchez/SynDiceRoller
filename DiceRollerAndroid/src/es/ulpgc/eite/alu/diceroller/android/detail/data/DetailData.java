package es.ulpgc.eite.alu.diceroller.android.detail.data;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

@Table(name="master_detail")
public class DetailData {

    @PrimaryKey(autoIncrement = true)
    @Column(name = "id")
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "tipo de tirada")
    private String typeOfRoll;

    @Column(name = "dado")
    private String sides;

    @Column(name = "modificador")
    private String modifier;

    public String getTypeOfRoll() {
        return typeOfRoll;
    }

    public void setTypeOfRoll(String typeOfRoll) {
        this.typeOfRoll = typeOfRoll;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public DetailData() {
        setLabel("");
        setTypeOfRoll("");
        setSides("");
        setModifier("");
    }

    public DetailData(String txt, String type, String sid, String mod) {
        setLabel(txt);
        setTypeOfRoll(type);
        setSides(sid);
        setModifier(mod);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long num) {
        id = num;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String txt) {
        label = txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DetailData){
            DetailData data = (DetailData) obj;

            if(data.getId() == getId()){   //todo
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
