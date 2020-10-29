package com.mj.agritech;


public class Farmer {

    private String farmername;
    private String farmerphone;
    private String farmeraddress;
    private String res_id;



    public Farmer()
    {

    }
    public Farmer(String farmername,String farmerphone,String farmeraddress,String res_id)
    {if(farmername.trim().equals(""))
    {farmername="No Name"; }

        this. farmername=farmername;
        this.farmerphone=farmerphone;
        this.farmeraddress=farmeraddress;
        this.res_id=res_id;

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
    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id= res_id;
    }

}