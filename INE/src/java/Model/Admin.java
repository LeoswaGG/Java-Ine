    // clase admin con los metodos setters y getters
    package Model;

    public class Admin {

        private String userName;
        private String passwordAdmin;
        private int idAdmin; 
        private int nVotantes;

        public String getUserName() {
            return userName;
        }

        public String getPasswordAdmin() {
            return passwordAdmin;
        }

        public int getIdAdmin(){
            return idAdmin;
        }
        
        public int getNVotantes(){
            return nVotantes;
        }
        
        public void setNVotantes(int nVotantes){
            this.nVotantes = nVotantes;
        }

        public void setIdAdmin(int idAdmin){
            this.idAdmin = idAdmin;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPasswordAdmin(String passwordAdmin) {
            this.passwordAdmin = passwordAdmin;
        }
        
        
    }
