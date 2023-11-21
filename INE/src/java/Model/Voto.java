package Model;

public class Voto {
    private int idVotante;
    private String idPartido;
    
   public void setidVotante(int idVotante){
       this.idVotante = idVotante;
   }
   
   public int getIdVotante(){
       return idVotante;
   }
   
   public void setIdPartido(String idPartido){
       this.idPartido = idPartido;
   }
   
   public String getIdPartido(){
       return idPartido;
   }
}
