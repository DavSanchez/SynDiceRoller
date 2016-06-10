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
    private int sides;

    @Column(name = "modificador")
    private int modifier;

    public String getTypeOfRoll() {
        return typeOfRoll;
    }

    public void setTypeOfRoll(String typeOfRoll) {
        this.typeOfRoll = typeOfRoll;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public DetailData() {
        setLabel("");
        setTypeOfRoll("");
        setSides(0);
        setModifier(0);
    }

    public DetailData(String txt, String type, int sid, int mod) {
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
