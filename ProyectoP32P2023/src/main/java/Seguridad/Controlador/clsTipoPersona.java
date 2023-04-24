/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoUsuario;
/**
 *
 * @author visitante
 */
public class clsTipoPersona {
    private int perTipoId;
    private String tipPerDescripcion;
    private String tipPerEstatus;

    public int getPerTipoId() {
        return perTipoId;
    }

    public void setPerTipoId(int perTipoId) {
        this.perTipoId = perTipoId;
    }

    public String getTipPerDescripcion() {
        return tipPerDescripcion;
    }

    public void setTipPerDescripcion(String tipPerDescripcion) {
        this.tipPerDescripcion = tipPerDescripcion;
    }

    public String getTipPerEstatus() {
        return tipPerEstatus;
    }

    public void setTipPerEstatus(String tipPerEstatus) {
        this.tipPerEstatus = tipPerEstatus;
    }
 public clsTipoPersona( ) {
   
    }
    public clsTipoPersona(int perTipoId) {
        this.perTipoId = perTipoId;
    }

    public clsTipoPersona(int perTipoId, String tipPerDescripcion) {
        this.perTipoId = perTipoId;
        this.tipPerDescripcion = tipPerDescripcion;
    }

    public clsTipoPersona(int perTipoId, String tipPerDescripcion, String tipPerEstatus) {
        this.perTipoId = perTipoId;
        this.tipPerDescripcion = tipPerDescripcion;
        this.tipPerEstatus = tipPerEstatus;
    }



    
    @Override
    public String toString() {
        return "clsTipoPersona{" + "IdTipoPersona=" + perTipoId + ", DescripcionTipoPersona=" + tipPerDescripcion + ", EstatusTipoPersona=" + tipPerEstatus +'}';
    }
    //Metodos de acceso a la capa controlador
   // public clsTipoPersona getBuscarInformacionUsuarioPorNombre(clsTipoPersona usuario)
   // {
    //    daoUsuario daousuario = new daoUsuario();
    //    return daousuario.consultaUsuariosPorNombre(usuario);
   // }
    public clsTipoPersona getBuscarInformacionTipPersonaPorId(clsTipoPersona TipPersona)
    {
        daoTipoPersona daoTipPersona = new daoTipoPersona();
        return daoTipPersona.consultaTipPersonaPorId(TipPersona);
    }    
    public List<clsTipoPersona> getListadoTipoPersona()
    {
        daoTipoPersona daoTipPersona = new daoTipoPersona();
        List<clsTipoPersona> listadoTipoPersona = daoTipPersona.consultaTipPersona();
        return listadoTipoPersona;
    }
    public int setBorrarTipoPersona(clsTipoPersona TipPersona)
    {
        daoTipoPersona daoTipPersona = new daoTipoPersona();
        return daoTipPersona.borrar(TipPersonaTipPersona);
    }          
    public int setIngresarTipoPersona(clsTipoPersona TipPersona)
    {
        daoTipoPersona daoTipPersona = new daoTipoPersona();
        return daoTipPersona.ingresaTipPersona(TipPersona);
    }              
    public int setModificarTipoPersona(clsTipoPersona TipPersona)
    {
        daoTipoPersona daoTipPersona = new daoTipoPersona();
        return daoTipPersona.actualizaTipPersona(TipPersona);
    }              
}
