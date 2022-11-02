
public class Medication {
  private String type;
  private String dose;
  private String time;
  
  public Medication(String type, String dose, String time){
    this.type = type;
    this.dose = dose;
    this.time = time;
  }
    
  public String getType(){
    return this.type;
  }

  public String getDose(){
    return this.dose;
  }

  public String getTime(){
    return this.time;
  }
  
  public String toString()
  {
    return "Type: " + this.type + "\nDose: " + this.dose + "\nTime: " + this.time;
  }
}
