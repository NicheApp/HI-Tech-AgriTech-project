package com.mj.agritech;

public class ReportModelclass {

    public String respondent,caste,village,intervention,baselineincome,currentyear,percentage,serial;

  public  ReportModelclass()
    {



    }

    public  ReportModelclass(String serial,String respondent,String caste,String village,String intervention,String baselineincome,String currentyear,String percentage)
    {
   this.serial=serial;
   this.respondent=respondent;
   this.caste=caste;
   this.village=village;
   this.intervention=intervention;
   this.baselineincome=baselineincome;
   this.currentyear=currentyear;
   this.percentage=percentage;
 }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public String getBaselineincome() {
        return baselineincome;
    }

    public void setBaselineincome(String baselineincome) {
        this.baselineincome = baselineincome;
    }

    public String getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(String currentyear) {
        this.currentyear = currentyear;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
