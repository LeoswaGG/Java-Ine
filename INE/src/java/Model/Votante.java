package Model;

public class Votante {

    private String vName;
    private String vLastName;
    private int vAge;
    private String vBirthday;
    private int idAdmin;
    private int idVotante;
    
    public int getIdVotante(){
        return idVotante;
    }
    
    public void setIdVotante(int idVotante){
        this.idVotante = idVotante;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvLastName() {
        return vLastName;
    }

    public void setvLastName(String vLastName) {
        this.vLastName = vLastName;
    }

    public int getvAge() {
        return vAge;
    }

    public void setvAge(int vAge) {
        this.vAge = vAge;
    }

    public String getvBirthday() {
        return vBirthday;
    }

    public void setvBirthday(String vBirthday) {
        this.vBirthday = vBirthday;
    }

    
    public int getIdAdmin(){
        return idAdmin;
    }
    
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
}
    