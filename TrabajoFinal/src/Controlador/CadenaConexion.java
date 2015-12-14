package Controlador;



public class CadenaConexion {

    String[] con = new String[4];

    public CadenaConexion() {
    }

    public String[] obtenerCadena() {

        con[0] = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        con[1] = "jdbc:sqlserver://;databaseName=trabajoFinal";
        con[2] = "BDlucho";
        con[3] = "terminal10";

        return con;
    }

}
