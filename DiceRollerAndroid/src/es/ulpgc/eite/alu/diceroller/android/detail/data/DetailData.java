package es.ulpgc.eite.alu.diceroller.android.detail.data;

import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;
/**
 * Created by David on 6/6/16.
 */

@Table(name="master_detail")
public class DetailData {

    @PrimaryKey(autoIncrement = true)
    @Column(name="id")
    private Long id;

    @Column(name="label")
    private String label;

    public DetailData(){
        setLabel("");
    }

    public DetailData(String txt){
        setLabel(txt);
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
    public boolean equals(Object obj){
        if (obj instanceof DetailData){
            DetailData data = (DetailData) obj;
            if (data.getId() == getId()){ //TODO
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return getLabel();
    }

}
