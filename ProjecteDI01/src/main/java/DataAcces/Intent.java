/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAcces;

import java.sql.Date;

/**
 *
 * @author Maqrok
 */
public class Intent {
    private int Id;
    private int IdUsuari;
    private int IdExercici;
    private Date TimestampInici;
    private Date TimestampFi;
    private String Videofile;
    private String exerciseName;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdUsuari() {
        return IdUsuari;
    }

    public void setIdUsuari(int IdUsuari) {
        this.IdUsuari = IdUsuari;
    }

    public int getIdExercici() {
        return IdExercici;
    }

    public void setIdExercici(int IdExercici) {
        this.IdExercici = IdExercici;
    }

    public Date getTimestampInici() {
        return TimestampInici;
    }

    public void setTimestampInici(Date TimestampInici) {
        this.TimestampInici = TimestampInici;
    }

    public Date getTimestampFi() {
        return TimestampFi;
    }

    public void setTimestampFi(Date TimestampFi) {
        this.TimestampFi = TimestampFi;
    }

    

    public String getVideofile() {
        return Videofile;
    }

    public void setVideofile(String Videofile) {
        this.Videofile = Videofile;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
    
    
    
}
