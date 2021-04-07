package main;

public class RobotAction {

    private int Sende_ID;
    private String Action_String;
    private int Action_ID;
    private int Bauteil_ID;
    private double[] Koordinaten;

    public RobotAction(int Sende_ID, String Action_String, int Action_ID, int Bauteil_ID, double[] Koordinaten) {
        this.Sende_ID = Sende_ID;
        this.Action_String = Action_String;
        this.Action_ID = Action_ID;
        this.Bauteil_ID = Bauteil_ID;
        this.Koordinaten = Koordinaten;
    }

    public void setSende_ID(int Sende_ID) {
        this.Sende_ID = Sende_ID;
    }

    public void setAction_String(String Action_String) {
        this.Action_String = Action_String;
    }

    public void setAction_ID(int Action_ID) {
        this.Action_ID = Action_ID;
    }

    public void setBauteil_ID(int Bauteil_ID) {
        this.Bauteil_ID = Bauteil_ID;
    }

    public void setKoordinaten(double[] Koordinaten) {
        this.Koordinaten = Koordinaten;
    }

    public int getSende_ID() {
        return Sende_ID;
    }

    public String getAction_String() {
        return Action_String;
    }

    public int getAction_ID() {
        return Action_ID;
    }

    public int getBauteil_ID() {
        return Bauteil_ID;
    }

    public double[] getKoordinaten() {
        return Koordinaten;
    }
}
