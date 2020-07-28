package com.mj.agritech;


public class Farmer {

    private String farmername;
    private String farmerphone;
    private String farmeraddress;



    public Farmer()
    {

    }
    public Farmer(String farmername,String farmerphone,String farmeraddress)
    {if(farmername.trim().equals(""))
    {farmername="No Name"; }

        this. farmername=farmername;
        this.farmerphone=farmerphone;
        this.farmeraddress=farmeraddress;

    }


    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public String getFarmerphone() {
        return farmerphone;
    }

    public void setFarmerphone(String farmerphone) {
        this.farmerphone = farmerphone;
    }

    public String getFarmeraddress() {
        return farmeraddress;
    }

    public void setFarmeraddress(String farmeraddress) {
        this.farmeraddress = farmeraddress;
    }
}